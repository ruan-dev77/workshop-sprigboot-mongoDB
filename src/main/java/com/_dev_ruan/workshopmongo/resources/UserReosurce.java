package com._dev_ruan.workshopmongo.resources;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com._dev_ruan.workshopmongo.domain.User;
import com._dev_ruan.workshopmongo.dto.UserDTO;
import com._dev_ruan.workshopmongo.services.UserService;

@RestController
@RequestMapping(value = "/Users")
public class UserReosurce {
	@Autowired
	UserService serv;
	
	
	@GetMapping
	public ResponseEntity<List<UserDTO>> findAll() {	
		List<User> list = serv.findAll();
		List<UserDTO> listDTO = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList()) ;
		return ResponseEntity.ok().body(listDTO);
	}
}
