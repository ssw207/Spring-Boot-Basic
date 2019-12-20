package com.green.myspringboot21.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
				.antMatchers("/mypage/**").authenticated() // 이경로로 접속하면 인증 처리
				.antMatchers("/**").permitAll() // 이 경로는 인증 안함
				.and()
				.formLogin() // 커스텀 form로그인 사용?
				.and()
				.httpBasic() // Basic 인증사용
				.and()
				.logout() // 로그아웃 처리
					.logoutUrl("/app-logout") // 이 경로로 접근시 로그아웃 처리
					.deleteCookies("JSESSIONID") // JSESSION 쿠키 삭제, F12 > application > cokies에서 확인
					.logoutSuccessUrl("/");  // 로그아웃 성공시 이동 경로
		
		super.configure(http);
	}
	
	// 회원가입 로직에서 호출해서 비밀번호 암호화하여 저장
	@Bean
	public PasswordEncoder passwordEncoder() {
		// 인코딩을 설정하지 않으면 디폴트로 bcrypt 설정
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}
}
