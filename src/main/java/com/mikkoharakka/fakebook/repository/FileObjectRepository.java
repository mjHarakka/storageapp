package com.mikkoharakka.fakebook.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mikkoharakka.fakebook.model.FileObject;

public interface FileObjectRepository extends JpaRepository<FileObject, Long> {

}    