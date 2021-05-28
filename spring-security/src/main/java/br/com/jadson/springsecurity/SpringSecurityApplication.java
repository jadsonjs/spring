package br.com.jadson.springsecurity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 *  @see // https://www.tutorialspoint.com/spring_security/spring_security_form_login_with_database.htm
 *  @see // https://medium.com/@gustavo.ponce.ch/spring-boot-spring-mvc-spring-security-mysql-a5d8545d837d
 *  @see // https://www.baeldung.com/spring-security-jdbc-authentication
 */
@SpringBootApplication
public class SpringSecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityApplication.class, args);
	}

}
