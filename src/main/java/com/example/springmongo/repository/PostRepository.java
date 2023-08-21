package com.example.springmongo.repository;

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
}
