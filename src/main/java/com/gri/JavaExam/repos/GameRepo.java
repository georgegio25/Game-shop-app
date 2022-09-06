// game
package com.gri.JavaExam.repos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.gri.JavaExam.models.Game;

@Repository
public interface GameRepo extends CrudRepository <Game, Long>{
	List<Game>findAll(); // this should be a camel case (framework requirement, if it's not, it may not let to start the app)

}