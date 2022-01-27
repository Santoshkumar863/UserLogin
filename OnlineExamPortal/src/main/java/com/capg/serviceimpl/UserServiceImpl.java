package com.capg.serviceimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.constant.Constant;
import com.capg.dto.UserDTO;
import com.capg.exception.NoUserFoundException;
import com.capg.model.Login;
import com.capg.model.User;
import com.capg.repositories.UserDAO;
import com.capg.service.UserService;

@Service
@Transactional
public  class UserServiceImpl implements UserService {
	@Autowired
	UserDAO userRepo;
	
	@Override
	public Boolean userRegister(User user) {

		Boolean flag = false;
		if (user == null) {
			return flag;
		}
		userRepo.save(user);
		flag = true;
		return flag;
	}

	@Override
	public User validateUser(Login login) {
		return userRepo.findByUsername(login.getUserName());
	}

	@Override
	public User getUserDetailsById(String userId) {

		return userRepo.findById(userId).orElseThrow(NoUserFoundException::new);

	}
	
	@Override
	public UserDTO updateUser(String userId, UserDTO userDTO) {
		UserDTO returnUserDTO = new UserDTO();
		User userEntityByUserId = userRepo.findByUserId(userId);

		if (userEntityByUserId == null) {
			throw new NoUserFoundException(Constant.RECORD_NOT_FOUND);
		}

		
		userEntityByUserId.setUseremail(userDTO.getUseremail());
		userEntityByUserId.setPassword(userDTO.getPassword());

		User updatedUserEntity = userRepo.save(userEntityByUserId);

		BeanUtils.copyProperties(updatedUserEntity, returnUserDTO);

		return returnUserDTO;
	}

	public User updateUser(User user) {

		String ue = user.getUseremail();
		User ud = userRepo.findById(ue).get();

		ud.setUserid(user.getUserid());
		ud.setUseremail(user.getUseremail());
		ud.setPassword(user.getPassword());
		

		return userRepo.save(ud);
	}

	@Override
	public List<User> getAllUser() {
		return userRepo.findAll();
		
	}

	
	}