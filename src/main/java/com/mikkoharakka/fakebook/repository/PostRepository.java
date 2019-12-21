package com.mikkoharakka.fakebook.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.mikkoharakka.fakebook.model.Post;

public interface PostRepository extends JpaRepository<Post, Long> {

}
