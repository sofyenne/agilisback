package tn.ISTIC.IServices;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import tn.ISTIC.Models.User;
import tn.ISTIC.Repository.UserRepository;
import tn.ISTIC.Services.UserService;





@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public User save( User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		
		return userRepository.save(user);
	}
	

	@Override
	public User findById(int id) {
		Optional<User> user;
		user = userRepository.findById(id);
		if (user.isPresent()) {
			return user.get();
		}
		throw new NullPointerException("user not found");
	}

	@Override
	public List<User> findAll() {
		return userRepository.findAll();
	}

	@Override
	public void deleteById(int id) {
		userRepository.deleteById(id);
	}

	@Override
	public void deleteAll() {
		userRepository.deleteAll();

	}
	 @Override
	 public User update(User user , int id ) {
		 
		User userexist = userRepository.getOne(id);
		if (userexist != null) {
			userexist.setUser_Id(id);
			userexist.setNom(user.getNom());
			userexist.setCode(user.getCode());
			userexist.setEmail(user.getEmail());
			userexist.setPassword(passwordEncoder.encode(user.getPassword()));
			userexist.setRole(user.getRole());
			userexist.setPrenom(user.getPrenom());
			return userRepository.save(userexist);
		}
		else 
		{user.setPassword(passwordEncoder.encode(user.getPassword()));
			 return userRepository.save(user);}
		 
	 }

}
