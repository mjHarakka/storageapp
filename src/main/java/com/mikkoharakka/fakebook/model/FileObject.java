package com.mikkoharakka.fakebook.model;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FileObject extends AbstractPersistable<Long> {

    private String name;
    private String contentType;
    private Long contentLength;
    
    @Lob
    @Basic(fetch = FetchType.LAZY)
    private byte[] content;
    
    @ManyToOne
    private Account account;

}