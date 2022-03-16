package com.qa.animes.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.qa.animes.domain.Animes;
import com.qa.animes.repo.AnimesRepo;

@Service
public class AnimesServiceDB implements AnimesInterface<Long>{

	private AnimesRepo repo; 
	
	public AnimesServiceDB(AnimesRepo repo) { 
		super();
		this.repo = repo;
	}

	@Override
	public Animes create(Animes x) {
		return this.repo.save(x);
	}

	@Override
	public List<Animes> read() {
		return this.repo.findAll();
	}

	@Override
	public Animes readId(Long id) {
		Optional<Animes> optRead = this.repo.findById(id);
		return optRead.orElse(null);
	}

	@Override
	public Animes update(Long id, Animes y) {
		Optional<Animes> optAni = this.repo.findById(id); 
		Animes found = optAni.get(); 
		found.setAnimeGenre(y.getAnimeGenre()); 
		found.setAnimeName(y.getAnimeName()); 
		found.setAnimeStudio(y.getAnimeStudio()); 
		found.setYearOfProduction(y.getYearOfProduction()); 
		return this.repo.save(found);
	}

	@Override
	public Animes delete(Long id) {
	Optional<Animes> toDelete = this.repo.findById(id);
	this.repo.deleteById(id);
	return toDelete.orElse(null);
	}

	@Override
	public boolean remove(Long id) {
		this.repo.deleteById(id);//id = 1 - gone
		return !this.repo.existsById(id);//false - true
	}
	
	
}
