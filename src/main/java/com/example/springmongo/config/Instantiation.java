package com.example.springmongo.config;


import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.example.springmongo.domanin.Post;
import com.example.springmongo.domanin.User;
import com.example.springmongo.dto.AutorDto;
import com.example.springmongo.dto.ComentarioDto;
import com.example.springmongo.repository.PostRepository;
import com.example.springmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		userRepository.deleteAll();
		postRepository.deleteAll();
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		
		userRepository.saveAll(Arrays.asList(maria, alex, bob));
		

		Post post1 = new Post(null, sdf.parse("21/03/2018"), "Partiu viagem", "Vou viajar",new AutorDto(maria));
		Post post2 = new Post(null, sdf.parse("21/03/2018"), "Bom dia", "Acordei Feliz!", new AutorDto(maria));
		
		ComentarioDto c1 = new ComentarioDto("Boa viagem mano!", sdf.parse("21/03/2018"), new AutorDto(alex));
		ComentarioDto c2 = new ComentarioDto("Aproveite!", sdf.parse("22/03/2018"), new AutorDto(bob));
		ComentarioDto c3 = new ComentarioDto("Tenha um otimo dia!", sdf.parse("23/03/2018"), new AutorDto(alex));
		
		post1.getComentarios().addAll(Arrays.asList(c1,c2));
		post2.getComentarios().addAll(Arrays.asList(c3));
		
		postRepository.saveAll(Arrays.asList(post1, post2));
		
		maria.getPosts().addAll(Arrays.asList(post1, post2));
		userRepository.save(maria);
	}

}
