package com.infosys.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infosys.exceptions.ExceptionInValidating;
import com.infosys.exceptions.InvalidEmailException;
import com.infosys.exceptions.InvalidUserNameException;
import com.infosys.exceptions.UserAlreadyExist;
import com.infosys.model.User;
import com.infosys.model.UserEntity;
import com.infosys.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	
	
	public String registerUserService(User user) throws Exception {
		
		validateUser(user);
		
		
		boolean b=repository.existsById(user.getUid());
		
		if(b == false)
			throw new UserAlreadyExist("User Id already exsists.Please try with the new one...");
		
		
		UserEntity	 entity=new UserEntity();
			
			entity.setName(user.getUname());
			entity.setEmail(user.getUemail());
			repository.save(entity);
			return "User Registered Successfully with the ID "+entity.getId();
		
		}
	
	public void validateUser(User user) throws ExceptionInValidating {
		
		if(!isValidName(user.getUname()))
		
			throw new InvalidUserNameException("Please Enter Correct User Name");
		
			if(!isValidEmail(user.getUemail()))
			throw new InvalidEmailException("Please Enter Valid Mail Id");
	}
	

	
	public boolean isValidName(String name) {
		String regex2="^[a-zA-Z]*$";
		Boolean b1=false;
		Pattern pattern1=Pattern.compile(regex2);
		Matcher matcher1=pattern1.matcher(name);
		if(matcher1.matches())
		b1=true;
		return b1;
		
	}
	
	public boolean isValidEmail(String email) {
		String regex3="^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$";
		Boolean b1=false;
		Pattern pattern1=Pattern.compile(regex3);
		Matcher matcher1=pattern1.matcher(email);
		if(matcher1.matches())
		b1=true;
		return b1;
		
	}


}
