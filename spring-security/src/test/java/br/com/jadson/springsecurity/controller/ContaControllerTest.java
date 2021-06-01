package br.com.jadson.springsecurity.controller;

import br.com.jadson.springsecurity.SpringSecurityAuthenticationTestConfig;
import br.com.jadson.springsecurity.model.Conta;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestEntityManager;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors;
import org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import javax.persistence.Query;

import java.util.List;

/**
 * This is a example of integration test with spring security.
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest (classes = SpringSecurityAuthenticationTestConfig.class)
@AutoConfigureMockMvc
@AutoConfigureTestEntityManager
@Transactional
class ContaControllerTest {

    @Autowired
    WebApplicationContext context;

    @Autowired
    MockMvc mockMvc;

    MockMvc mockMvc2;

    @Autowired
    TestEntityManager testEntityManager;

    /**
     * Inicia todos os mock no serviço que estamos testando
     */
    @BeforeEach
    void setUp() {
        mockMvc2 = MockMvcBuilders
                .webAppContextSetup(context)
                .apply(SecurityMockMvcConfigurers.springSecurity())
                .build();
    }

    @AfterEach
    void tearDown() {
        // apaga os registros feitos para nao influencia os outros testes
        testEntityManager.getEntityManager().createQuery("DELETE FROM Conta").executeUpdate();

    }

    /**
     * A integration test of back account save
     */
    @Test
    @WithUserDetails("gerente")  // username
    void saveContaTest() throws Exception {

        ResultActions result = mockMvc.perform(MockMvcRequestBuilders.post("/conta/save")
                .param("saldo", "120.d")
                .param("numero", "123456")
                .param("nome", "Teste")
                .with(SecurityMockMvcRequestPostProcessors.user(SpringSecurityAuthenticationTestConfig.getTesteGerenterUser()))
        )
         // the method send a redirect
        .andExpect(MockMvcResultMatchers.status().is(302))
        //.andExpect(MockMvcResultMatchers.redirectedUrl("all?conta=1"))
        .andDo(MockMvcResultHandlers.print());


        /*******************************************************
         * Verifica se a conta foi salva no banco
         ******************************************************/
        Query query = testEntityManager.getEntityManager().createQuery("SELECT c FROM Conta c");

        @SuppressWarnings("unchecked")
        List<Conta> contas = query.getResultList();
        Assertions.assertEquals(1, contas.size());

        Assertions.assertEquals(123456, contas.get(0).getNumero());
    }


    /**
     * A integration test of back account save
     */
    @Test
    void saveContaTest2() throws Exception {

        ResultActions result = mockMvc2.perform(MockMvcRequestBuilders.post("/conta/save")
                .param("saldo", "120.d")
                .param("numero", "654321")
                .param("nome", "Teste")
                .with(SecurityMockMvcRequestPostProcessors.csrf())
                .with(SecurityMockMvcRequestPostProcessors.user("admin").password("pass").roles("USER","ADMIN"))
                .with(SecurityMockMvcRequestPostProcessors.user(SpringSecurityAuthenticationTestConfig.getTesteGerenterUser()))
        )
                // the method send a redirect
                .andExpect(MockMvcResultMatchers.status().is(302))
                //.andExpect(MockMvcResultMatchers.redirectedUrl("all?conta=1"))
                .andDo(MockMvcResultHandlers.print());


        /*******************************************************
         * Verifica se a conta foi salva no banco
         ******************************************************/
        Query query = testEntityManager.getEntityManager().createQuery("SELECT c FROM Conta c");

        @SuppressWarnings("unchecked")
        List<Conta> contas = query.getResultList();
        Assertions.assertEquals(1, contas.size());

        Assertions.assertEquals(654321, contas.get(0).getNumero());
    }


    /**
     * A integration test of back account save
     */
    @Test
    @WithUserDetails("funcionario")  // username
    void saveContaTestForbiden() throws Exception {

        ResultActions result = mockMvc.perform(MockMvcRequestBuilders.post("/conta/save")
                .param("saldo", "120.d")
                .param("numero", "123456")
                .param("nome", "Teste")
        )
                // the method send a redirect to login
                .andExpect(MockMvcResultMatchers.status().isForbidden())
                .andDo(MockMvcResultHandlers.print());

        Query query = testEntityManager.getEntityManager().createQuery("SELECT c FROM Conta c");

        @SuppressWarnings("unchecked")
        List<Conta> contas = query.getResultList();
        Assertions.assertEquals(0, contas.size());

    }


    /**
     * A integration test of back account save
     */
    @Test
    void saveContaTestUsuarioNaoLogado() throws Exception {

        ResultActions result = mockMvc.perform(MockMvcRequestBuilders.post("/conta/save")
                .param("saldo", "120.d")
                .param("numero", "123456")
                .param("nome", "Teste")
        )
                // the method send a redirect to login
                .andExpect(MockMvcResultMatchers.status().is(302))
                .andExpect(MockMvcResultMatchers.redirectedUrl("http://localhost/login"))
                .andDo(MockMvcResultHandlers.print());

        Query query = testEntityManager.getEntityManager().createQuery("SELECT c FROM Conta c");

        @SuppressWarnings("unchecked")
        List<Conta> contas = query.getResultList();
        Assertions.assertEquals(0, contas.size());


    }
}