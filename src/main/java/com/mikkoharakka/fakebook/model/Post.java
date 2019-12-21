package com.mikkoharakka.fakebook.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.springframework.data.jpa.domain.AbstractPersistable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Post extends AbstractPersistable<Long> {

	@ManyToOne
	private Account account;
	
	@OneToMany(mappedBy = "post")
	private List<Comment> comments;
	
	private Date date;
	private String content;
	
	

	
}
