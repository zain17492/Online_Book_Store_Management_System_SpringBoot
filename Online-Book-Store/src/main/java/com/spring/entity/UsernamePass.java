package com.spring.entity;

public class UsernamePass {
	
	private String username;
		private String password;
		
		// AllArgsConstructor
		public UsernamePass(String username, String password) {
			super();
			this.username = username;
			this.password = password;
		}
		
		// NoArgsConstructor 
		public UsernamePass() {
			super();
			// TODO Auto-generated constructor stub
		}

		//Getter Setter Method
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		
		
	}

