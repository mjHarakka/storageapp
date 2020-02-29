package com.mikkoharakka.fakebox.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mikkoharakka.fakebox.model.FileObject;

public interface FileObjectRepository extends JpaRepository<FileObject, Long> {

}    