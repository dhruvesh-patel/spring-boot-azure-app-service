package com.dpinc.springbootazureappservice;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * User Service
 * @author Dhruvesh
 *
 */
@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	/**
	 * To get all users 
	 * @return List<User> - List of users
	 */
	public List<User> findAll() {
		return userRepository.findAll();
	}

	/**
	 * To find user by user id
	 * @param userId - user id 
	 * @return Optional<User> - Optional of user
	 */
	public Optional<User> findById(Long userId) {
		return userRepository.findById(userId);
	}

	/**
	 * To save user
	 * @param user - user
	 * @return User - user object
	 */
	public User save(User user) {
		return userRepository.save(user);
	}

	/**
	 * To delete user
	 * @param user
	 */
	public void delete(User user) {
		userRepository.delete(user);
	}
	
}
