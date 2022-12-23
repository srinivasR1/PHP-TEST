package com.userRegistration.User;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	@Autowired
	private UserRepository ur;
	
	@PostMapping("/save")
	public User save(@RequestBody User user) {
		return ur.save(user);
	}

	@GetMapping("/get")
	public List<User>getAlldata(){
		return (List<User>) ur.findAll();
	}
	@GetMapping("get/{phone}")
	public Optional<User>getdata(@PathVariable Long phone){
		return ur.findById(phone);
	}
	@PutMapping("/update")
	public User update(@RequestParam long phone,@RequestBody User user) {
		ur.findById(phone);
		return ur.save(user);
	}
	@DeleteMapping("/delete/{phone}")
	public void delete(@PathVariable long phone) {
		ur.deleteById(phone);
	}
}