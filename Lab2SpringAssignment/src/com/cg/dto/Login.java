package com.cg.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="cg_admin")
public class Login {
	@Override
	public String toString() {
		return "Login [username=" + username + ", password=" + password + "]";
	}

	@Id
	@Column(name="user_name",length=4000)
	private String username;
	
	@Column
	private String password;
	
	public Login() {}

	@NotNull(message="user name is mandatory")
	@Size(min=5,message="Min 5 char require")
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	@NotNull(message="Password is mandatory")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
