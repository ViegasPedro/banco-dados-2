package com.unisinos.rediscache.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unisinos.rediscache.model.User;
import com.unisinos.rediscache.model.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repo;
	
	public User get(Long id) {
		System.out.println("Consultando o usuário no Postgres");
		return repo.findById(id).get();
	}
	
	public void insert() {
		User user = new User();
		user.setName("Pedro");
		user.setPassword("123");
		user.setEmail("pedro@pedro");
		
		User user2 = new User();
		user.setName("Pedro2");
		user.setPassword("321");
		user.setEmail("pedro2@pedro2");
		
		repo.save(user);
		repo.save(user2);
	}
}
