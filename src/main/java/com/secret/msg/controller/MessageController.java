package com.secret.msg.controller;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.secret.msg.entities.Message;
import com.secret.msg.entities.UserData;
import com.secret.msg.repository.MessageRepo;
import com.secret.msg.repository.UserRepo;

@RestController
@RequestMapping("api/v1")
@CrossOrigin("http://localhost:3000")
public class MessageController {
	
	@Autowired
	private UserRepo userrepo;
	@Autowired
	private MongoTemplate  mongotemplate;
	@Autowired
	private MessageRepo  msgrepo;
	
	
	@PostMapping("/sendmessage")
	@CrossOrigin("*")
	public void sendMessage(@RequestBody Message m,@RequestParam("uid") String uid)
	{
		ObjectId id=new ObjectId(uid);
		Message newmsg=msgrepo.insert(m);
		mongotemplate.update(UserData.class)
		.matching(Criteria.where("id").is(id))
	    .apply(new Update().push("msg",newmsg))
	    .first();
		
	}
	@PostMapping("/getmessage")
	@CrossOrigin("*")
	public ResponseEntity<List<Message>> retrieveMessages(@RequestBody UserData user)
	{
		List<Message> messages=userrepo.findByEmail(user.getEmail()).orElse(null).getMsg();
		return new ResponseEntity(messages,HttpStatus.ACCEPTED);
	}

}
