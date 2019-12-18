package com.green.myspringboot21.repository;

//static 매서드를 임포트
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.green.myspringboot21.entity.Account;
import com.green.myspringboot21.exception.ResourceNotFoundException;


// Junit이 어떤 러너클래스를 사용할지 결정
@RunWith(SpringRunner.class)
@SpringBootTest // SpringBootTest를 위한 설정들을 세팅
public class AccountRepositoryTest {
	@Autowired
	AccountRepository accountRepository;
	
	// 테스트케이스 매서드는 반드시 퍼블릭 보이드여야한다.
	@Test 
	@Ignore // 테스트케이스를 잠시 무시한다.
	public void insertAccountTest() {
		//before
		Account account = new Account();
		account.setUserName("spring");
		account.setPassword("1234");
		
		//after
		Account insertedAccount = accountRepository.save(account);
		System.out.println(insertedAccount);
		assertThat(insertedAccount).isNotNull();
	}
	
	@Test
	public void getAccountTest() {
		Optional<Account> account1 = accountRepository.findByUserName("spring");
		Optional<Account> account2 = accountRepository.findByUserName("test");
		
		if(account1.isPresent()) System.out.println(account1.get().toString());
		System.out.println(""+account2.isPresent());
		
		String resource = "Account";
		String fieldName = "userName";
		String fieldValue = "test";
		
		// 에러가 날경우 exception 클래스를 반환, 아닐경우 get() 실행 결과 반환
		Account account = account1.orElseThrow(() -> new ResourceNotFoundException(resource, fieldName, fieldValue));
		
		System.out.println(account.toString());
//		assertThat(account1).isNotNull();
//		assertThat(account2).isNull();
		
		Optional<Account> opt = accountRepository.findById(1L);
		Account acct = opt.orElseThrow(() -> new ResourceNotFoundException(resource, fieldName, fieldValue));
		
		// 값이 있다면 ? 함수를 실행
		opt.ifPresent(localValue -> System.out.println(localValue));
		// 위와 동일
		opt.ifPresent(System.out::println); // Method Reference
		//ifPresent : 
	}
}
