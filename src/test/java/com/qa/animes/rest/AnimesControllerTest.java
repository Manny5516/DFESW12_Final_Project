package com.qa.animes.rest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

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
	void testReadAll() throws Exception {
		Animes dragonBallZ = new Animes(1L, "Dragon Ball Z", 1989, "Shonen", "Toei Animations"); 
		Animes onePiece = new Animes(2L, "One Piece", 1999, "Shonen", "Toei Animations"); 
		List<Animes> allAnimes = List.of(dragonBallZ, onePiece);
		String allAnimesJSON = this.map.writeValueAsString(allAnimes); 
		RequestBuilder mockRequest = get("/readAll"); 
		ResultMatcher status = status().isAccepted();
		ResultMatcher body = content().json(allAnimesJSON);
		this.mock.perform(mockRequest).andExpect(status).andExpect(body);
	} 
	
	@Test 
	void testReadById() throws Exception { 
		Long ID = 1L;
		Animes dragonBallZ = new Animes(ID, "Dragon Ball Z", 1989, "Shonen", "Toei Animations"); 
		String readAnimesJSON = this.map.writeValueAsString(dragonBallZ);  
		RequestBuilder mockRequest = get("/readById/" + ID); 
		ResultMatcher status = status().isNonAuthoritativeInformation();
		ResultMatcher body = content().json(readAnimesJSON);
		this.mock.perform(mockRequest).andExpect(status).andExpect(body);
	} 
	
	@Test 
	void testUpdate() throws Exception { 
		Long ID = 1L;
		Animes updateAnimes = new Animes("Naruto",2002,"Shonen", "Studio Pierrot"); 
		String updateAnimesJSON = this.map.writeValueAsString(updateAnimes); 
		RequestBuilder mockRequest = put("/update/" + ID).contentType(MediaType.APPLICATION_JSON).content(updateAnimesJSON);
		Animes updatedAni = new Animes(ID,"Naruto",2002,"Shonen", "Studio Pierrot"); 
		String updatedAniJSON = this.map.writeValueAsString(updatedAni); 
		ResultMatcher retStatus = status().isImUsed(); 
		ResultMatcher retBody = content().json(updatedAniJSON); 
		this.mock.perform(mockRequest).andExpect(retStatus).andExpect(retBody);
	}
	
	@Test 
	void testDelete() throws Exception { 
		Long ID = 1L;
		Animes deleteAnime = new Animes(ID, "Dragon Ball Z", 1989, "Shonen", "Toei Animations");  
		String deleteAnimeJSON = this.map.writeValueAsString(deleteAnime);
		RequestBuilder mockRequest = delete("/delete/" + ID); 
		ResultMatcher status = status().isGone();
		ResultMatcher body = content().json(deleteAnimeJSON); 
		this.mock.perform(mockRequest).andExpect(status).andExpect(body);
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
