package com.green.myspringboot21.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import com.green.myspringboot21.entity.User;

public interface UserRepository extends JpaRepositoryImplementation<User, Long>{
	Optional<User> findByName(String name);
}
