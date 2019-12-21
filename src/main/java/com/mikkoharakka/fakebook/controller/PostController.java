package com.mikkoharakka.fakebook.controller;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.mikkoharakka.fakebook.model.Account;
import com.mikkoharakka.fakebook.model.Comment;
import com.mikkoharakka.fakebook.model.Post;
import com.mikkoharakka.fakebook.repository.PostRepository;
import com.mikkoharakka.fakebook.repository.AccountRepository;
import com.mikkoharakka.fakebook.repository.CommentRepository;

@Controller
public class PostController {
	
	@Autowired
	PostRepository postRepository;
	@Autowired
	AccountRepository accountRepository;
	@Autowired
	CommentRepository commentRepository;

	@GetMapping("/")
	public String getPosts(Model model) {
		model.addAttribute("users", accountRepository.findAll());
		return "index";
	}
	
	@PostMapping("/{id}")
	public String createComment(@RequestParam String content, @PathVariable Long id) {
		// Save the comment to the repo
		Comment comment = new Comment();
		
		comment.setContent(content);
		comment.setPost(postRepository.getOne(id));
		commentRepository.save(comment);
		// Get the post referenced by id from repo and save the comment to the list it contains
		Post post = postRepository.getOne(id);
		post.getComments().add(comment);
		
		return "redirect:/";
	}
	
	@PostMapping("/")
	public String createPost(@RequestParam String content) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String email = auth.getName();
		
		Post p = new Post();
		p.setDate(new Date());
		p.setAccount(accountRepository.findByEmail(email));
		p.setContent(content);
		p.setComments(new ArrayList<>());
		
		postRepository.save(p);
		
		return "redirect:/";
	}
	
	
}
