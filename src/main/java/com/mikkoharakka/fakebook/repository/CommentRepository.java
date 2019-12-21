package com.mikkoharakka.fakebook.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.mikkoharakka.fakebook.model.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {

}
