package com.qa.animes.rest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.animes.domain.Animes;

@SpringBootTest  
@AutoConfigureMockMvc
@Sql(scripts = {"classpath:animes-schema.sql", "classpath:animes-data.sql"}, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@ActiveProfiles("test")
public class AnimesControllerTest {

	@Autowired 
	private MockMvc mock; 
	
	@Autowired
	private ObjectMapper map; 
	
	@Test
	void testCreate() throws Exception {
		Animes create = new Animes("Naruto",2002,"Shonen", "Studio Pierrot");
		String createJSON =this.map.writeValueAsString(create);
		RequestBuilder mockRequest = post("/create").contentType(MediaType.APPLICATION_JSON).content(createJSON);
		Animes saved = new Animes(3L,"Naruto",2002,"Shonen", "Studio Pierrot");
		String savedJSON =this.map.writeValueAsString(saved);
		ResultMatcher matchStatus = status().isCreated();
		ResultMatcher matchBody = content().json(savedJSON);
		this.mock.perform(mockRequest).andExpect(matchStatus).andExpect(matchBody);
	} 
	
	
	
	@Test
	void testRemove() throws Exception {
		Long id = 1L;
		RequestBuilder mockRequest = delete("/remove/?id="+id);
		ResultMatcher status = status().isGone();
		ResultMatcher body = content().string("true");
		this.mock.perform(mockRequest).andExpect(body).andExpect(status);
	}
	
}
