package com.secret.msg.entities;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Document
public class Message {
	@Id
	private ObjectId sid;
	
	private String displayName;
	private String email;
	private String photoURL;
	private String message;
	
	
	
	
	public Message() {
		super();
		// TODO Auto-generated constructor stub
	}




	

	public Message(ObjectId sid, String displayName, String email, String photoURL, String message) {
		super();
		this.sid = sid;
		this.displayName = displayName;
		this.email = email;
		this.photoURL = photoURL;
		this.message = message;
	}






	public Message(String displayName, String email, String photoURL, String message) {
		super();
		this.displayName = displayName;
		this.email = email;
		this.photoURL = photoURL;
		this.message = message;
	}






	public ObjectId getSid() {
		return sid;
	}




	public void setSid(ObjectId sid) {
		this.sid = sid;
	}




	


	public String getDisplayName() {
		return displayName;
	}






	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}






	public String getEmail() {
		return email;
	}




	public void setEmail(String email) {
		this.email = email;
	}




	public String getPhotoURL() {
		return photoURL;
	}




	public void setPhotoURL(String photoURL) {
		this.photoURL = photoURL;
	}




	public String getMessage() {
		return message;
	}




	public void setMessage(String message) {
		this.message = message;
	}

	
	
	
}