package com.example.springmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.springmongo.domanin.User;

@Repository
public interface UserRepository extends MongoRepository<User, String>{

}
