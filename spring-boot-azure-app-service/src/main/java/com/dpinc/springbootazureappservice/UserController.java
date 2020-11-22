package com.dpinc.springbootazureappservice;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Rest Controller for User Controller
 * @author Dhruvesh
 *
 */
@RestController
public class UserController {

	@Autowired
	private UserService userService;

	/**
	 * To get health of the app
	 * @return ResponseEntity<String>  - Response entity with HTTP status code
	 */
	@GetMapping("/health")
	public ResponseEntity<String> getHealth() {
		return new ResponseEntity<String>("Successful health check - User Service", HttpStatus.OK);
	}

	/**
	 * To get all users list
	 * @return List<User> - List of all users
	 */
	@GetMapping("/users")
	public List<User> getAllUsers() {
		return userService.findAll();
	}

	/**
	 * To get user by Id
	 * @param userId - Unique user id
	 * @return ResponseEntity<User> - Response Entity with status code and user object
	 */
	@GetMapping("/users/{id}")
	public ResponseEntity<User> getUsersById(@PathVariable(value = "id") Long userId) {

		Optional<User> userOptional = userService.findById(userId);	
		return ResponseEntity.ok().body(userOptional.get());
	}

	/**
	 * To create new user
	 * @param user
	 * @return ResponseEntity<User> - Response Entity with status code and user object
	 */
	@PostMapping("/users")
	public ResponseEntity<User> createUser(@RequestBody User user) {
		User createdUser = userService.save(user);
		return ResponseEntity.ok().body(createdUser);
	}

	/**
	 * To update existing user details
	 * @param userId
	 * @param userDetails
	 * @return ResponseEntity<User> - Response Entity with status code and user object
	 */
	@PutMapping("/users/{id}")
	public ResponseEntity<User> updateUser(@PathVariable(value = "id") Long userId, @RequestBody User userDetails) {

		User user = userService.findById(userId).get();
				

		user.setEmail(userDetails.getEmail());
		user.setLastName(userDetails.getLastName());
		user.setFirstName(userDetails.getFirstName());
		user.setUpdatedAt(new Date());
		final User updatedUser = userService.save(user);
		return ResponseEntity.ok(updatedUser);
	}

	/**
	 * to delete existing user
	 * @param userId
	 * @return ResponseEntity<String> - Response Entity with status code and deleted user id
	 */
	@DeleteMapping("/users/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable(value = "id") Long userId) {
		User user = userService.findById(userId).get();

		userService.delete(user);
		return new ResponseEntity<String>("User Deteted Successfully with user id : " + userId, HttpStatus.OK);
	}

}
