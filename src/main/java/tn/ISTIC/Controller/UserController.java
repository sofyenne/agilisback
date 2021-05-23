package tn.ISTIC.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.ISTIC.Models.User;
import tn.ISTIC.Services.UserService;





@RestController
@RequestMapping(value = "/users")
public class UserController {
	@Autowired
	UserService userService;
	
	@PostMapping("/register")
	@ResponseBody
	public User createuser (@RequestBody User user) {
		return userService.save(user);
	}
	@GetMapping("/{id}")
	@ResponseBody
	public User getuser (@PathVariable int id) {
		return userService.findById(id);
	}
	
	@GetMapping("/all")
	@ResponseBody
	public List<User> getAlluser (){
		return userService.findAll();
	}
	
	@DeleteMapping("/{id}")
	@ResponseBody
	public void deleteuser(@PathVariable int id) {
		userService.deleteById(id);
	}
	@PutMapping("update/{id}")
	@ResponseBody
	public User update(@RequestBody User newuser , @PathVariable int id) {
		return userService.update(newuser, id);
	}
	
	

}
