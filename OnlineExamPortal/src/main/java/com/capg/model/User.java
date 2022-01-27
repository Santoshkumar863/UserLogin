package com.capg.model;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "user_details")
public class User {
	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	private String uniqueId;
	@Column(name = "userid", length = 200, unique = true)
	private long userid;
	
	@Column(unique=true)
	private String useremail;
	
	@Column(name = "username", length = 200, unique = true)
	private String username;
	
    @Column(name = "usermobileNo", length = 200, unique = true)
	private long usermobileno;
	
	@Embedded
	@Column(name = "useraddress", length = 200)
	private UserAddress useraddress;
	
	@Column(name = "password", length = 200)
	private String password;
	
	@Column(name = "reset-password-token")
	private String resetPasswordToken;

	public String getResetPasswordToken() {
		return resetPasswordToken;
	}

	public void setResetPasswordToken(String resetPasswordToken) {
		this.resetPasswordToken = resetPasswordToken;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	public long getUserid() {
		return userid;
	}

	public void setUserid(long userid) {
		this.userid = userid;
	}

	public String getUseremail() {
		return useremail;
	}

	public void setUseremail(String useremail) {
		this.useremail = useremail;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public long getUsermobileno() {
		return usermobileno;
	}

	public void setUsermobileno(long usermobileno) {
		this.usermobileno = usermobileno;
	}

	public UserAddress getUseraddress() {
		return useraddress;
	}

	public void setUseraddress(UserAddress useraddress) {
		this.useraddress = useraddress;
	}

	@Override
	public String toString() {
		return "User [userid=" + userid + ", useremail=" + useremail + ", username=" + username + ", usermobileno="
				+ usermobileno + ", useraddress=" + useraddress + ", password=" + password + ", resetPasswordToken="
				+ resetPasswordToken + "]";
	}



}
