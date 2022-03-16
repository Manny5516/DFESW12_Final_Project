package com.qa.animes.service;

import java.util.List;

import com.qa.animes.domain.Animes;

public interface AnimesInterface<T> {

Animes create(Animes x); 
	
	List<Animes> read(); 
	
	Animes readId(T id);
	
	Animes update(T id, Animes y); 
	
	Animes delete(T id); 
	
	boolean remove(T id);
	
}
