package com._dev_ruan.workshopmongo.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com._dev_ruan.workshopmongo.domain.User;

@RestController
@RequestMapping(value = "/Users")
public class UserReosurce {
	
	
	@GetMapping
	public ResponseEntity<List<User>> findAll() {
		User maria = new User(1,"mAria silva", "maria@gmail.com");
		User alex = new User(2,"Alex mato", "alex@gamil.com");
		
		List<User> list = new ArrayList<>();
		list.addAll(Arrays.asList(maria,alex));
		return ResponseEntity.ok().body(list);
	}
}
