package user.model;

public class UserBean {
	private String username;
	 private String password;
	 private String firstname; 
	 private String lastname;
	 private String role;
	 public boolean valid;
	 
	 public UserBean() {
			super();
		}
	 
	 
	 public UserBean(String firstname, String lastname, String username, String password, String role) {
		super();
		 this.firstname = firstname;
		 this.lastname = lastname;
		 this.username = username;
		 this.password = password;
		 this.role=role;
	}
	 
	public String getFirstName() {
	 return firstname;
	}
	 public void setFirstName(String newFirstName) {
	 firstname = newFirstName;
	}
	 public String getLastName() {
	 return lastname;
	}
	 public void setLastName(String newLastName) {
	 lastname = newLastName;
	}
	 public String getPassword() {
	 return password;
	}
	 public void setPassword(String newPassword) {
	 password = newPassword;
	}
	 public String getUsername() {
	 return username;
	}
	 public void setUserName(String newUsername) {
	 username = newUsername;
	}
	 public boolean isValid() {
	 return valid;
	}
	 public void setValid(boolean newValid) {
	 valid = newValid;
	}


	public String  getId() {
		
		return username ;
	}


	public void setRole(String newrole) {
		role= newrole;
	}
	
	public String getRole() {
		return role;
	}

}
