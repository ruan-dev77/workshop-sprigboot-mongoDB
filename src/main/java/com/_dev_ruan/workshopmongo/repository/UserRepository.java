package com._dev_ruan.workshopmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com._dev_ruan.workshopmongo.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

}
