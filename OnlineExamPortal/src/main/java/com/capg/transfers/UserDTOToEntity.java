package com.capg.transfers;

import com.capg.dto.UserDTO;
import com.capg.model.User;

public class UserDTOToEntity {
	public User convertUserDTOToEntity(UserDTO userDto, User user ) {
		user.setPassword(userDto.getPassword());
		
		return user;
	}

}
