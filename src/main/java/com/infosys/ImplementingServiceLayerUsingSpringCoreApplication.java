package com.infosys;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.infosys.model.User;
import com.infosys.service.UserService;

@SpringBootApplication
public class ImplementingServiceLayerUsingSpringCoreApplication implements CommandLineRunner {

	
	@Autowired
	private UserService service;
	
	Scanner scan;
	public static void main(String[] args) {
		SpringApplication.run(ImplementingServiceLayerUsingSpringCoreApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		
	try {
		scan=new Scanner(System.in);
	
		
		System.out.println("Enter User Id");
		Long cid=scan.nextLong();
		
		System.out.println("Enter User Name");
		String cname=scan.next();
		
		System.out.println("Enter Email ID");
		String cemail=scan.next();

		User user=new User();
		user.setUid(cid);
		user.setUname(cname);
		user.setUemail(cemail);
		
		
		String registrationMessage=service.registerUserService(user);
		System.out.println(registrationMessage);
	}
	catch(Exception e){
		System.out.println(e.getMessage());
	}
	finally {
		scan.close();
	}
	}
	
}
