//This file holds sets of methods that we will use for this class in different files


package com.gri.JavaExam.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gri.JavaExam.models.Game;
import com.gri.JavaExam.repos.GameRepo;

@Service
public class GameService {
	@Autowired
	private GameRepo gameRepo;
	
	// create/update
	public Game save(Game c) {
		return gameRepo.save(c);
	}
	
	// read
	public List<Game>getAll() {
		return gameRepo.findAll();
	}
	
	public Game getOne(Long id) {
		Optional<Game>optGame = gameRepo.findById(id);
		
		if(optGame.isPresent()) {
			return optGame.get();
		}else {
			return null;
		}
	}
	
	// delete
	public void delete(Long id) {
		gameRepo.deleteById(id);
	}
	
	
}