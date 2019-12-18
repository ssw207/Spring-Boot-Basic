package com.green.myspringboot21.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import com.green.myspringboot21.entity.Account;

public interface AccountRepository extends JpaRepositoryImplementation<Account, Long>{
	Optional<Account> findByUserName(String userName);
}
