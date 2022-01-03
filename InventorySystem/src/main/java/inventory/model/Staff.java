package inventory.model;

public class Staff {
	private String staffID;
	private String staffUsername;
	private String staffPassword;
	private String staffName;
	private String staffTelnum;
	private String role="staff";
	private boolean valid;
	
	
	public Staff() {
	super();
	}
	public Staff(String Id,String uname,String pswd,String name,String telnum) {
		super();
		this.staffID=Id;
		this.staffUsername=uname;
		this.staffName=name;
		this.staffPassword=pswd;
		this.staffTelnum=telnum;
	}
	public String getStaffID() {
		return staffID;
	}
	public void setStaffID(String ID) {
		staffID = ID;
	}
	public  String getStaffUsername() {
		return staffUsername;
	}
	public void setStaffUsername(String Username) {
		staffUsername = Username;
	}
	public String getStaffPassword() {
		return staffPassword;
	}
	public void setStaffPassword(String Password) {
		staffPassword = Password;
	}
	public String getStaffName() {
		return staffName;
	}
	public void setStaffName(String Name) {
		staffName = Name;
	}
	public String getStaffTelnum() {
		return staffTelnum;
	}
	public void setStaffTelnum(String Telnum) {
		staffTelnum = Telnum;
	}
	public boolean isValid() {
		return valid;
	}
	public void setValid(boolean valid) {
		this.valid = valid;
	}
	public String getRole() {
		
		return role;
	}

}
