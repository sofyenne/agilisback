package tn.ISTIC.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.ISTIC.Models.User;







public interface  UserRepository extends JpaRepository<User, Integer>  {
	
	
	Optional<User> findByEmail(String email);

}
