package com.qa.animes.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import com.qa.animes.domain.Animes;
import com.qa.animes.repo.AnimesRepo;

@SpringBootTest
@ActiveProfiles("test")
public class AnimesServiceDBTest {

	private Animes input; 
	private Animes returned;
	
	@Autowired
	private AnimesServiceDB serv; 
	
	@MockBean
	private AnimesRepo rep;
	
	@BeforeEach 
	void setUp() {
		input = new Animes("Dragon Ball Z", 1989, "Shonen", "Toei Animations"); 
		returned = new Animes(1L, "Dragon Ball Z", 1989, "Shonen", "Toei Animations");
	}
	
	@Test
	void testsCreate() {
		Mockito.when(this.rep.save(input)).thenReturn(returned);
		assertThat(this.serv.create(input)).isEqualTo(returned);
		Mockito.verify(this.rep, Mockito.times(1)).save(input);
	}  
	
	@Test 
	void testRead() { 
		List<Animes> readList = new ArrayList<>(); 
		readList.add(input);
		Mockito.when(this.rep.findAll()).thenReturn(readList);
		assertThat(this.serv.read()).isEqualTo(readList);
		Mockito.verify(this.rep, Mockito.times(1)).findAll();
	} 
	
	@Test
	void testReadId() {
		Long id = 1L;
		Optional<Animes> optAnim = Optional.of(returned); 
		Mockito.when(this.rep.findById(id)).thenReturn(optAnim);
		assertThat(this.serv.readId(id)).isEqualTo(returned);
		Mockito.verify(this.rep, Mockito.times(1)).findById(id);
	}
	
	@Test
	void testUpdate() {
		Long id = 1L; 
		Animes toUpdate = new Animes("One Piece",1999,"Shonen", "Toei Animations"); 
		Optional<Animes> opt = Optional.of(returned); 
		Animes updated = new Animes(id, toUpdate.getAnimeName(), toUpdate.getYearOfProduction(), toUpdate.getAnimeGenre(), toUpdate.getAnimeStudio()); 
		Mockito.when(this.rep.findById(id)).thenReturn(opt);
		Mockito.when(this.rep.save(updated)).thenReturn(updated);
		assertThat(this.serv.update(id, toUpdate)).isEqualTo(updated);
		Mockito.verify(this.rep, Mockito.times(1)).findById(id);
		Mockito.verify(this.rep, Mockito.times(1)).save(updated);
	} 
	
	@Test
	void testDelete() { 
		Long id = 1L; 
		Optional<Animes> optChoco = Optional.of(returned); 
		Mockito.when(this.rep.findById(id)).thenReturn(optChoco);
		assertThat(this.serv.delete(id)).isEqualTo(returned);
		Mockito.verify(this.rep, Mockito.times(1)).deleteById(id);
		Mockito.verify(this.rep, Mockito.times(1)).findById(id);
	} 
	
	@Test
	void testRemove() {
		Long id = 1L;
		Mockito.when(this.rep.existsById(id)).thenReturn(false);
		assertThat(this.serv.remove(id)).isTrue();
		Mockito.verify(this.rep, Mockito.times(1)).deleteById(id);
		Mockito.verify(this.rep, Mockito.times(1)).existsById(id);
	}
	
	@AfterEach 
	void clear() { 
		
	}
}
