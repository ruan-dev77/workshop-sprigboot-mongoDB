package com._dev_ruan.workshopmongo.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<UserDTO> findByID(@PathVariable String id) {
		User user = serv.findById(id);
		return ResponseEntity.ok().body(new UserDTO(user));
	}
	
	@PostMapping
	public ResponseEntity<Void> insertUser(@RequestBody UserDTO objDTO) {
		User obj = serv.fromDTO(objDTO);
		obj = serv.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("{/id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
}
