package com.capg.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.capg.model.User;

@Repository
public interface UserDAO extends JpaRepository<User, String>, CrudRepository<User, String>  {
	
	@Query("SELECT u FROM user_details u WHERE u.username LIKE %?1%")
	User findByUsername(@Param("username") String username);

	@Query("SELECT u FROM user_details u WHERE u.useremail =?1")
	User findByUserEmail(@Param("useremail") String useremail);

	User findByUserId(String userid);
	
	public User findByResetPasswordToken(String token);
}
