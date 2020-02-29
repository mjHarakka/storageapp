package com.mikkoharakka.fakebox.controller;

import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.mikkoharakka.fakebox.Service.AccountService;
import com.mikkoharakka.fakebox.Service.FileService;
import com.mikkoharakka.fakebox.model.Account;
import com.mikkoharakka.fakebox.model.FileObject;
import com.mikkoharakka.fakebox.repository.FileObjectRepository;

@Controller
public class FileController {

    @Autowired
    private FileObjectRepository fileRepository;
    @Autowired
    private AccountService accountService;
    @Autowired
    private FileService fileService;
 
    @GetMapping("/dashboard")
    public String list(Model model) {
    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    	String email = auth.getName();
    	long id = accountService.getOneAccountWithEmail(email).getId();
    	
        model.addAttribute("files", fileService.getFilesFromAccount(id));
        return "files";
    }
 
    @GetMapping("dashboard/{id}")
    public ResponseEntity<byte[]> viewFile(@PathVariable Long id, @PathVariable Long accountId) {
        FileObject fo = fileRepository.getOne(id);
 
        final HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.parseMediaType(fo.getContentType()));
        headers.add("Content-Disposition", "attachment; filename=" + fo.getName());
        headers.setContentLength(fo.getContentLength());
 
        return new ResponseEntity<>(fo.getContent(), headers, HttpStatus.CREATED);
    }
 
    @PostMapping("/dashboard")
    public String addFile(@RequestParam("file") MultipartFile file) throws IOException {
    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    	String email = auth.getName();
    	
        FileObject fileObject = new FileObject();
        fileObject.setContentType(file.getContentType());
        fileObject.setContent(file.getBytes());
        fileObject.setName(file.getOriginalFilename());
        fileObject.setContentLength(file.getSize());
        fileObject.setAccount(accountService.getOneAccountWithEmail(email));
        fileRepository.save(fileObject);
 
        return "redirect:/";
    }
    
}