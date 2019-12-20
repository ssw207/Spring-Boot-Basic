package com.green.myspringboot21.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.green.myspringboot21.entity.Account;
import com.green.myspringboot21.repository.AccountRepository;

@Service
public class AccountService implements UserDetailsService {
	@Autowired
	AccountRepository accountRepository;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@PostConstruct // 해당클래스가 Bean으로 등록되자마자 실행됨
	public void init() {
		Optional<Account> opt = accountRepository.findByUserName("admin");
		if(!opt.isPresent()) {
			Account account = createAccount("admin", passwordEncoder.encode("1234"));
			System.out.println(account);
		}
	}
	
	public Account createAccount(String userName, String password) {
		Account account = new Account();
		account.setUserName(userName);
		account.setPassword(password);
		return accountRepository.save(account);
	}
	
	// view에서 로그인시 실행. 입력한 로그인 username(id)이 들어온다. 
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Account> beforeAccount = accountRepository.findByUserName(username);
		// 조회된 유저정보가 없으면 에러를 발생
		Account exisAccount = beforeAccount.orElseThrow(() -> new UsernameNotFoundException(username));
		// 시큐리티에 User 객체를 반화
		return new User(username, exisAccount.getPassword(), authorities());
	}
	
	// User객체에 인자 USER라는 ROLE을 가진 사용자 권한을 설정 
	private Collection<? extends GrantedAuthority> authorities() {
		return Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
	}

}
