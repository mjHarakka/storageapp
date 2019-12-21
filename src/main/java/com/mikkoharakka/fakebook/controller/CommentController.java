package com.mikkoharakka.fakebook.controller;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mikkoharakka.fakebook.model.Comment;
import com.mikkoharakka.fakebook.model.Post;
import com.mikkoharakka.fakebook.repository.CommentRepository;
import com.mikkoharakka.fakebook.repository.PostRepository;
import com.mikkoharakka.fakebook.repository.AccountRepository;

@Controller
public class CommentController {
	
	@Autowired
	PostRepository postRepository;
	@Autowired
	AccountRepository accountRepository;
	@Autowired
	CommentRepository commentRepository;

	@PostMapping("/{accountId}/{postId/}")
	public String createPost(@RequestParam String content, @PathVariable long accountId, long postId) {

		Comment c = new Comment();
		c.setAccount(accountRepository.getOne(accountId));
		c.setContent(content);
		postRepository.getOne(postId).getComments().add(c);
	
		return "redirect:/";
	}
	
	
}
