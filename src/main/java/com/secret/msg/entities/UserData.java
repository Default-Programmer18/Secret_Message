package com.secret.msg.entities;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

@Document
public class UserData {
		@Id
		private ObjectId id;
		
		private String name;
		private String displayname;
		private String email;
		private String photo;
		@DocumentReference
		private List<Message> msg;
		private String newid;
		
		
		
		
		
		

		

		public UserData(ObjectId id, String name, String displayname, String email, String photo) {
			super();
			this.id = id;
			this.name = name;
			this.displayname = displayname;
			this.email = email;
			this.photo = photo;
		}
		
		public UserData(String name, String displayname, String email) {
			super();
			this.name = name;
			this.displayname = displayname;
			this.email = email;
		}

		
		public UserData(ObjectId id, String name, String displayname, String email, String photo, List<Message> msg) {
			super();
			this.id = id;
			this.name = name;
			this.displayname = displayname;
			this.email = email;
			this.photo = photo;
			this.msg = msg;
		}
		

		public UserData(String name, String displayname, String email, String photo) {
			super();
			this.name = name;
			this.displayname = displayname;
			this.email = email;
			this.photo = photo;
		}
		public String getNewid() {
			return newid;
		}
		public void setNewid(String newid) {
			this.newid = newid;
		}
		public List<Message> getMsg() {
			return msg;
		}
		public void setMsg(List<Message> msg) {
			this.msg = msg;
		}
		public ObjectId getId() {
			return id;
		}
		public void setId(ObjectId id) {
			this.id = id;
		}
		
		public String getPhoto() {
			return photo;
		}
		public void setPhoto(String photo) {
			this.photo = photo;
		}
		
		public UserData() {
			super();
			// TODO Auto-generated constructor stub
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getDisplayname() {
			return displayname;
		}
		public void setDisplayname(String displayname) {
			this.displayname = displayname;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
}
