package com._dev_ruan.workshopmongo.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com._dev_ruan.workshopmongo.domain.User;
import com._dev_ruan.workshopmongo.services.UserService;

@RestController
@RequestMapping(value = "/Users")
public class UserReosurce {
	@Autowired
	UserService serv;
	
	
	@GetMapping
	public ResponseEntity<List<User>> findAll() {	
		List<User> list = serv.findAll();
		return ResponseEntity.ok().body(list);
	}
}
