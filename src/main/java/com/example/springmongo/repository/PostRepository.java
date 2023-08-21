package com.example.springmongo.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.springmongo.domanin.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String>{
	List<Post> findByTituloContainingIgnoreCase(String texto);
	
	@Query("{ 'titulo': { $regex: ?0, $options: 'i' } }")
	List<Post> findByTitutlo(String texto);
	
	@Query("{ $and: [ { data: { $gte: ?1 } }, { data: { $lte: ?2 } } , { $or: [ { 'titulo': { $regex: ?0, $options: 'i' } }, { 'corpo': { $regex: ?0, $options: 'i' } }, { 'comentarios.texto': { $regex: ?0, $options: 'i' } } ] } ] } ")
	List<Post> fullsearch(String texto, Date minDate, Date maxData);
}
