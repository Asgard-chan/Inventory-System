package inventory.model;

public class SupplierBean {

	private String supplierID;
	private String supplierUsername;
	private String supplierPassword;
	private String supplierEmail;
	private String supplierAddress;
	private String supplierTelnum;
	private String role="supplier";
	private boolean valid;
	
	
	public SupplierBean() {
	super();
	}
	public SupplierBean(String SupplierId,String SupplierUsername,String Supplierpassword,String SupplierEmail,String SupplierAddress,String Suppliertelnum) {
		super();
		this.supplierID=SupplierId;
		this.supplierUsername=SupplierUsername;
		this.supplierEmail=SupplierEmail;
		this.supplierPassword=Supplierpassword;
		this.supplierAddress=SupplierAddress;
		this.supplierTelnum=Suppliertelnum;
	}
	

public String getSupplierID() {
		return supplierID;
	}
	public void setSupplierID(String supplierID) {
		this.supplierID = supplierID;
	}
	public String getSupplierUsername() {
		return supplierUsername;
	}
	public void setSupplierUsername(String supplierUsername) {
		this.supplierUsername = supplierUsername;
	}
	public String getSupplierPassword() {
		return supplierPassword;
	}
	public void setSupplierPassword(String supplierPassword) {
		this.supplierPassword = supplierPassword;
	}
	public String getSupplierEmail() {
		return supplierEmail;
	}
	public void setSupplierEmail(String supplierEmail) {
		this.supplierEmail = supplierEmail;
	}
	public String getSupplierAddress() {
		return supplierAddress;
	}
	public void setSupplierAddress(String supplierAddress) {
		this.supplierAddress = supplierAddress;
	}
	public String getSupplierTelnum() {
		return supplierTelnum;
	}
	public void setSupplierTelnum(String supplierTelnum) {
		this.supplierTelnum = supplierTelnum;
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
