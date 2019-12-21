package com.mikkoharakka.fakebook;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import com.mikkoharakka.fakebook.controller.RegisterController;
import com.mikkoharakka.fakebook.model.Account;
import com.mikkoharakka.fakebook.model.Comment;
import com.mikkoharakka.fakebook.model.Post;
import com.mikkoharakka.fakebook.repository.AccountRepository;
import com.mikkoharakka.fakebook.repository.CommentRepository;
import com.mikkoharakka.fakebook.repository.PostRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FakebookApplicationTests {

	@Autowired
	private RegisterController controller;
	@Autowired
	private AccountRepository accountRepository;
	@Autowired
	private PostRepository postRepository;
	@Autowired
	private CommentRepository commentRepository;
	
	@Test
	public void contexLoads() throws Exception {
	    assertThat(controller).isNotNull();
	}	
	
	@Test
	public void createNewAccount() {
    	Account a = new Account("test@test.com", "1234", "Testi", "Testinen", null, null);
    	accountRepository.save(a);
    	assertThat(a.getId()).isNotNull();
    }    
	
	@Test
    public void createNewPostAndComment() {
		Account a = new Account("test@test.com", "1234", "Testi", "Testinen", null, null);
    	accountRepository.save(a);
    	
    	Post p = new Post();
		p.setDate(new Date());
		p.setAccount(a);
		p.setContent("testi sisältöä");
		p.setComments(new ArrayList<>());
		postRepository.save(p);
		
		Comment c = new Comment();
		c.setAccount(a);
		c.setContent("testi komentti");
		c.setPost(p);
		commentRepository.save(c);
	
    	assertThat(a.getId()).isNotNull();
    	assertThat(p.getId()).isNotNull();
    	assertThat(c.getId()).isNotNull();
    }
	
	
	
}
