package com.example.springmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.springmongo.domanin.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String>{

}
