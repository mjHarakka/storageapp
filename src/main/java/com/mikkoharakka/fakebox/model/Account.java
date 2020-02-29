package com.mikkoharakka.fakebox.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.*;

import org.springframework.data.jpa.domain.AbstractPersistable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Account extends AbstractPersistable<Long> {

	@NotNull
	@NotEmpty
	private String email;
	
	@NotNull
    @NotEmpty
    private String password;

	@NotNull
	@NotEmpty
	private String firstName;
	
	@NotNull
	@NotEmpty
	private String lastName;

	@OneToMany(mappedBy="account")
	private List<FileObject> files;     
	
	

	
	
}
