package com.waylau.spring.boot.jpa.contrller;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.waylau.spring.boot.jpa.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

/**
 * Hello World 控制器测试类
 * @author <a href="https://waylau.com">Way Lau</a> 
 * @date 2017年1月26日
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class HelloControllerTest {

	@Autowired
    private MockMvc mockMvc;

	@Autowired
    private ObjectMapper objectMapper;
	
    @Test
    public void testHello() throws Exception {
    	mockMvc.perform(MockMvcRequestBuilders.get("/hello").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("Hello World! Welcome to visit waylau.com!")));
    }


    @Test
    public void createUser() throws Exception {

        User user = new User("张三",12);


        mockMvc.perform(MockMvcRequestBuilders.post("/users")
                .accept(MediaType.APPLICATION_JSON)
                .param("name","张三")
                .param("age","12")) ;
    }


}
