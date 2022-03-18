package com.qa.animes.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.animes.domain.Animes;

@Repository
public interface AnimesRepo extends JpaRepository<Animes, Long> {

}
