package com.green.myspringboot21;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

	@Test
	public void contextLoads() {
		// 결국 Runable클래스는 run매서드를 오버라이딩 하는 역할만 한다.
		Thread t1 = new Thread(new Runnable() { // Runable 익명클래스
			
			// Runable 인터페이스는 하나의 추상매서드만 가지고 있다.
			@Override
			public void run() {
				System.out.println("기존 쓰레드를 실행하는 방법");
			}
		});
		t1.start();
	}
	
	@Test
	public void ramdaTest() {
		// () : run의 args, -> : run매서드 로직
		Thread t2 = new Thread(() -> System.out.println("람다식으로 쓰레드생성."));
	}

}
