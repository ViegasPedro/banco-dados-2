package com.unisinos.rediscache.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unisinos.rediscache.model.User;
import com.unisinos.rediscache.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService service;

	@GetMapping("/{id}")
	@Cacheable(value = "User", key = "#id")
	public User get(@PathVariable("id") Long id) {
		return service.get(id);
	}
	
	@PostMapping
	public void insert() {
		service.insert();
	}
}
