package tn.ISTIC.Services;

import java.util.List;

import tn.ISTIC.Models.User;

;



public interface UserService {

	
	 User save (User user);
	
	
	
	User findById (int id);
		
	List<User> findAll ();
	
	void deleteById (int id);
	
	void deleteAll();
	
	User update(User user , int id);

}
