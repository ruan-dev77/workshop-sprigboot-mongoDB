package com._dev_ruan.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com._dev_ruan.workshopmongo.domain.User;
import com._dev_ruan.workshopmongo.dto.UserDTO;
import com._dev_ruan.workshopmongo.repository.UserRepository;
import com._dev_ruan.workshopmongo.services.Exception.ObjectNotFoundException;

@Service
public class UserService {
	@Autowired
	UserRepository userRepository;
	
	public List<User> findAll(){
		return userRepository.findAll();
	}
	
	public User findById(String id) {
		Optional<User> user = userRepository.findById(id);
		return user.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	public User insert(User user) {
		return userRepository.insert(user);
	}
	
	public User fromDTO(UserDTO objDTO) {
		return new User(objDTO.getId(),objDTO.getName(),objDTO.getEmail());
	}
}
