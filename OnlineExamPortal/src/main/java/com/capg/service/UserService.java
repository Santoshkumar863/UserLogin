package com.capg.service;

import java.util.List;

import com.capg.dto.UserDTO;
import com.capg.exception.NoUserFoundException;
import com.capg.model.Login;
import com.capg.model.User;

public interface UserService {

	public Boolean userRegister(User user);

    public User validateUser(Login login);

	public User getUserDetailsById(String userId);



	public List<User> getAllUser();

	public UserDTO updateUser(String userId, UserDTO userDTO);



}
