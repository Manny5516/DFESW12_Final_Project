package com.qa.animes.rest;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.qa.animes.domain.Animes;
import com.qa.animes.service.AnimesServiceDB;

@RestController
public class AnimesController {

	private AnimesServiceDB service; 
	
	public AnimesController(AnimesServiceDB service) { 
		super(); 
		this.service = service;
	} 
	
		@PostMapping("create")
		public ResponseEntity<Animes> createAnime(@RequestBody Animes a) { 
			return new ResponseEntity<Animes>(this.service.create(a), HttpStatus.CREATED); 
		}
		
		
		@GetMapping("readAll")
		public ResponseEntity<List<Animes>> readAllAnimes() { 
		return new ResponseEntity<List<Animes>>(this.service.read(), HttpStatus.ACCEPTED); 
		}
		
		@GetMapping("readById/{id}")
		public ResponseEntity<Animes> getById(@PathVariable Long id) { 
			return new ResponseEntity<Animes>(this.service.readId(id), HttpStatus.NON_AUTHORITATIVE_INFORMATION); 
		}
		
		@PutMapping("update/{id}")	
		public ResponseEntity<Animes> update(@PathVariable Long id, @RequestBody Animes updated) {
			return new ResponseEntity<Animes>(this.service.update(id, updated),HttpStatus.IM_USED); 
			//Postman seems to give the old animal rather than the updated ones in the response body
		}
		
		@DeleteMapping("delete/{id}")
		public ResponseEntity<Animes> delete(@PathVariable Long id) {
			return new ResponseEntity<Animes>(this.service.delete(id),HttpStatus.GONE); 
	} 
		
		@DeleteMapping("/remove")
		public ResponseEntity<Boolean> remove(@PathVariable Long id) {
			return new ResponseEntity<Boolean>(this.service.remove(id), HttpStatus.GONE);
		} 
		
}
