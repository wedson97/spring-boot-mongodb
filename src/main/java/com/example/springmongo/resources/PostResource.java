package com.example.springmongo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.springmongo.domanin.Post;
import com.example.springmongo.resources.util.URL;
import com.example.springmongo.services.PostService;

@RestController
@RequestMapping(value="/posts")
public class PostResource {
	
	@Autowired
	private PostService service;
	
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Post> findById(@PathVariable String id){
		Post obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@GetMapping(value="/titulosearch")
	public ResponseEntity<List<Post>> findByTitulo(@RequestParam(value="text", defaultValue="") String text){
		text = URL.decodeParan(text);
		List<Post> list = service.findByTitulo(text);
		return ResponseEntity.ok().body(list);
	}
}
