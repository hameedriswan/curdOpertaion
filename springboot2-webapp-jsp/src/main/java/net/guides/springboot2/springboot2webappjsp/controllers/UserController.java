package net.guides.springboot2.springboot2webappjsp.controllers;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.bind.annotation.RestController;


import net.guides.springboot2.springboot2webappjsp.domain.User;
import net.guides.springboot2.springboot2webappjsp.repositories.UserRepository;

@RestController
public class UserController {
	
	public static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired	
		UserRepository userRepo;
	
	@GetMapping
	@RequestMapping("/users")	
		public List<User> home(Model model) {		
			
			return userRepo.findAll();
	}
	
	//////Fetch by id using back-end Arg Passing
	
	@GetMapping
	@RequestMapping("/getById")
	public User dataById(Model model){
	
	return userRepo.getById(2);
}

	//Fetch by using Url passing
	@GetMapping
	@RequestMapping("/getById/{id}")

	public Optional<User> getById(@PathVariable(value="id")Integer id) {
	
	return userRepo.findById(id);
}
	//Fetch by using key passing from postman
	@GetMapping
	@RequestMapping("/getFromId")
		public Optional<User>getFrId(@RequestParam(name="id")Integer id){
	
	return userRepo.findById(id);
}
    //Delete specific  id of data
	@GetMapping
	@RequestMapping("/delete")
		public   void deleteById(@RequestParam(name="id")Integer id){
			userRepo.deleteById(id);	
}
	//Insert data - Post Method
	@PostMapping("/insertUser")
	User insertUser(@RequestBody User user) {
		
		return userRepo.save(user);
	}
	
	//Update data - Post Method
	@PostMapping("/updateUser/{id}")
	User updateUser(@PathVariable(value = "id")Integer id,@RequestBody User user) {
		
		User currentUser = userRepo.getById(id);
		
		currentUser.setName(user.getName());
		
		return userRepo.saveAndFlush(currentUser);
	}
	
	
}
	
	
//	 @RequestMapping(value = "/create/", method = RequestMethod.POST)
//	    public ResponseEntity<?> createUser(@RequestBody User user, UriComponentsBuilder ucBuilder) {
//	        logger.info("Creating User : {}", user);
//	 
//	       
//	        userRepo.save(user);
//	 
//	        HttpHeaders headers = new HttpHeaders();
//	        headers.setLocation(ucBuilder.path("/api/user/{id}").buildAndExpand(user.getId()).toUri());
//	        return new ResponseEntity<String>(headers, HttpStatus.CREATED);
//	    }

