package com.secret.msg.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.secret.msg.entities.UserData;
import com.secret.msg.repository.UserRepo;
@RestController
@RequestMapping("api/v1")
@CrossOrigin("http://localhost:3000")
public class UserController {
	@Autowired
	private UserRepo userrepo;
	@CrossOrigin("*")
	@PostMapping("/storeUserAfterCreateLink")
	public ResponseEntity<String> storeAfterCreateLink(@RequestBody UserData u)
	{  
		System.out.println(u);
		UserData user=userrepo.findByEmail(u.getEmail()).orElse(null);
		
		if(user == null)
		{
			u = userrepo.insert(u);
			
			u.setNewid(u.getId().toString());
				return new ResponseEntity(u,HttpStatus.CREATED);
		}
		user.setName(u.getName());
		user.setNewid(user.getId().toString());
		userrepo.save(user);
		
		return new ResponseEntity(user,HttpStatus.OK);
	}
}