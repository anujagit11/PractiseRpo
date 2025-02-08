package com.crud1.controllerTest;

import com.crud1.model.Student;
import com.crud1.serviceI.stuServiceI;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@WebMvcTest
public class ControllerTesting {

@MockBean
stuServiceI si;

@Autowired
MockMvc mvc;

private Student st;

@BeforeEach
void setUp()
{
	st=new Student("anuja","admin","admin");
}
@Test
void test_insertSingleData() throws JsonProcessingException, Exception
{
	mvc.perform(post("/insertSingleData")
			.contentType(MediaType.APPLICATION_JSON)
			.content(new ObjectMapper().writeValueAsString(st))).andExpect(status().isOk());

}

}
