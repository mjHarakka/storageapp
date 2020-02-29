package com.mikkoharakka.fakebox.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mikkoharakka.fakebox.model.Account;
import com.mikkoharakka.fakebox.model.FileObject;
import com.mikkoharakka.fakebox.repository.FileObjectRepository;

@Service
public class FileService {
	
	@Autowired
	private AccountService accountService;
	@Autowired
	private FileObjectRepository fileObjectRepository;
	
	public List<FileObject> getFilesFromAccount(long id) {
		Account account = accountService.getOneAccount(id);
		return account.getFiles();
	}
	
	public FileObject getOneFile(long id) {
		return fileObjectRepository.getOne(id);
	}
	
	public void deleteFile(long fileId) {
		fileObjectRepository.deleteById(fileId);
	}
	

}
