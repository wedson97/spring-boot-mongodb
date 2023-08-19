package com.example.springmongo.dto;

import java.io.Serializable;

import com.example.springmongo.domanin.User;

public class UserDto implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String nome, email;
	
	public UserDto() {
	}
	
	public UserDto(User user) {
		this.id = user.getId();
		this.email = user.getEmail();
		this.nome = user.getNome();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
	
}

