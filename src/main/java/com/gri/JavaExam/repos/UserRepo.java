//r
package com.gri.JavaExam.repos;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.gri.JavaExam.models.User;

@Repository
public interface UserRepo extends CrudRepository <User, Long>{
	List<User>findAll(); // this should be a camel case (framework requirement, if it's not, it may not let to start the app)
	Optional<User>findByEmail(String email);

}
