package com.example.demo.common.model;

import lombok.Data;

@Data
public class User extends BaseModel{
	
	private Long age;
	
	private String userName;
	private String fullName;	
	private String password;
	private String img;
	private String gender;
}
