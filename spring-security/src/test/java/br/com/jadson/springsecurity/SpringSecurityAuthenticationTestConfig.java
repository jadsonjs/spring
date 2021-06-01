/*
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 *
 *
 * spring-security
 * br.com.jadson.springsecurity
 * SpringSecurityWebTestConfig
 * 28/05/21
 */
package br.com.jadson.springsecurity;

import br.com.jadson.springsecurity.model.Papel;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import java.util.*;

/**
 * https://stackoverflow.com/questions/15203485/spring-test-security-how-to-mock-authentication
 *
 * Jadson Santos - jadsonjs@gmail.com
 */
@TestConfiguration
public class SpringSecurityAuthenticationTestConfig {

    static User testeGerenterUser;

    /**
     * cria um UserDetailsService em memória com os usuários para o teste
     * @return
     */
    @Bean
    @Primary
    public UserDetailsService userDetailsService() {

        List<GrantedAuthority> grantedAuthoritiesGerente = List.of(new SimpleGrantedAuthority(Papel.GERENTE.toString()));
        List<GrantedAuthority> grantedAuthoritiesFuncionario = List.of(new SimpleGrantedAuthority(Papel.FUNCIONARIO.toString()));

        testeGerenterUser =  new User("gerente", "1233456",
                true, true, true, true, grantedAuthoritiesGerente);

        User testeFuncionarioUser =  new User("funcionario", "1233456",
                true, true, true, true, grantedAuthoritiesFuncionario);

        return new InMemoryUserDetailsManager(Arrays.asList(testeGerenterUser, testeFuncionarioUser));
    }

    public static User getTesteGerenterUser() {
        return testeGerenterUser;
    }

}
