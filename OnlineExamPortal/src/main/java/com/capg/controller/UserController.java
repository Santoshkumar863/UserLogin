package com.capg.controller;


	import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capg.constant.Constant;
import com.capg.exception.EmailException;
import com.capg.exception.NoUserFoundException;
import com.capg.exception.RecordAlreadyExistException;
import com.capg.model.Login;
import com.capg.model.User;
import com.capg.service.UserService;

	@RestController
	@Component
	public class UserController {

		@Autowired
		UserService userService;

		@PostMapping("/user/registration")
		public String addUser(@RequestBody User user) {
			
			
			
			if (user.getUseremail().isEmpty() || user.getUseremail().isBlank()
					|| !user.getUseremail().matches("^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$")) {
				throw new EmailException(Constant.MISSING_REQUIRED_FIELDS);
			}

			else {
				Boolean isUserAdded;
				try {
					
					isUserAdded = userService.userRegister(user);
					if (Boolean.TRUE.equals(isUserAdded)) {
						return Constant.USER_REGISTERED_SUCCESSFULLY;
						
					} 
					
					return Constant.UNABLE_TO_REGISTER;
					
				} catch (Exception ex) {
					throw new RecordAlreadyExistException(Constant.RECORD_ALREADY_EXIST);
				}

			}
		}

		@PostMapping(value = "/user/login")
		public String login(@RequestBody Login login) throws NoUserFoundException {

			User user = userService.validateUser(login);

			boolean isValidUser = false;

			if (null != user) {
				if ((user.getUsername().equals(login.getUserName()) && user.getPassword().equals(login.getPassword()))) {
					isValidUser = true;
				} else {
					
					 throw new NoUserFoundException();
				}

			}

			return isValidUser ? Constant.SUCCESSFULLY_LOGGED_IN : Constant.LOGGED_IN_FAILED;
		}
		@GetMapping("/userlist")
		public List<User> getAllUser() {
		return userService.getAllUser();
		}
		


	}

