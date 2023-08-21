package com.example.springmongo.domanin;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.example.springmongo.dto.AutorDto;
import com.example.springmongo.dto.ComentarioDto;

@Document
public class Post implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	private String id;
	private Date data;
	private String titulo, corpo;
	private AutorDto autor;
	
	private List<ComentarioDto> comentarios = new ArrayList<>();
	
	public Post() {
	}

	public Post(String id, Date data, String titulo, String corpo, AutorDto user) {
		this.autor = user;
		this.id = id;
		this.data = data;
		this.titulo = titulo;
		this.corpo = corpo;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getCorpo() {
		return corpo;
	}

	public void setCorpo(String corpo) {
		this.corpo = corpo;
	}
	
	public AutorDto getAutor() {
		return autor;
	}

	public void setAutor(AutorDto autor) {
		this.autor = autor;
	}
	
	public List<ComentarioDto> getComentarios() {
		return comentarios;
	}

	public void setComentarios(List<ComentarioDto> comentarios) {
		this.comentarios = comentarios;
	}


	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Post other = (Post) obj;
		return Objects.equals(id, other.id);
	}

}
