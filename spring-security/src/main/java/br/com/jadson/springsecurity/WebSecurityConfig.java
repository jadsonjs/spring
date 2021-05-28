/*
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
 * WebSecurityConfig
 * 27/05/21
 */
package br.com.jadson.springsecurity;

import br.com.jadson.springsecurity.model.Papel;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Security configuration
 *
 * @reference: https://spring.io/guides/gs/securing-web/
 *
 * Jadson Santos - jadsonjs@gmail.com
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * The configure(HttpSecurity) method defines which URL paths should be secured and which should not.
     * Specifically, the / and /home paths are configured to not require any authentication.
     * All other paths must be authenticated.
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            /**
             * Desabilita para usar apenas a autenticação do banco de dados
             */
             .csrf().disable()
             /*
              * substituindo form de login padrão do spring e libera o acesso a ele
              */
            .formLogin().loginPage("/login").permitAll()

            .and()
                .authorizeRequests()
                 /*
                  * endpoints que começam com / /home não precisam ser protegidos
                  */
                .antMatchers("/", "/home").permitAll()

                // apenas o gerente podem salvar uma nova conta
                .antMatchers("/conta/pre-create").hasAuthority(Papel.GERENTE.toString())
                .antMatchers("/conta/save").hasAuthority(Papel.GERENTE.toString())

                //  funcionário ou o gerente podem acessar os recurso de conta
                .antMatchers("/conta/*").hasAnyAuthority(Papel.GERENTE.toString(), Papel.FUNCIONARIO.toString())

                /*
                 * Qualquer outra requisicao devem ser autenticada
                 */
                .anyRequest().authenticated()

            .and()
                 /* permite acesso ao logou e também especificamos que a sessão deve ser invalidada e a autenticação
                  * armazenada no SecurityContext do aplicativo deve ser apagada
                  */
                .logout().invalidateHttpSession(true).clearAuthentication(true).permitAll();
    }

    /**
     * Libera acesso ao recurso
     * @param web
     * @throws Exception
     */
    @Override
    public void configure(WebSecurity web) throws Exception {
        web
                .ignoring()
                .antMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/images/**");
    }




//    All way    withDefaultPasswordEncoder is deprecated.
//    @Bean
//    @Override
//    public UserDetailsService userDetailsService() {
//        UserDetails user =
//                User.withDefaultPasswordEncoder()
//                        .username("user")
//                        .password("password")
//                        .roles("USER")
//                        .build();
//
//        return new InMemoryUserDetailsManager(user);
//    }


//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//                .passwordEncoder(passwordEncoder())
//                    .withUser("user")
//                    .password("$2a$10$V9Hj5MzmdFAAHsd8FKZ7le81IwdShSEoXwZ4.t7b6ZC00WOjQjucm")
//                        .roles("USER");
//    }




    public static void main(String[] args) {
        System.out.println(new BCryptPasswordEncoder().encode("test"));
    }

}
