package donation.model;

public class User {
	private String userid;
	private String username;
	private String userfullname;
	private String usercontactno;
	private String useremail;
	private String userpassword;
	private boolean valid;
	private Beneficiary beneficiary;
	private Staff staff;
	
	public String getUserID() {
		return userid;
	}
	public void setUserID(String userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUserFullName() {
		return userfullname;
	}
	public void setUserFullName(String userfullname) {
		this.userfullname = userfullname;
	}
	public String getUserContactNo() {
		return usercontactno;
	}
	public void setUserContactNo(String usercontactno) {
		this.usercontactno = usercontactno;
	}
	public String getUserEmail() {
		return useremail;
	}
	public void setUserEmail(String useremail) {
		this.useremail = useremail;
	}
	public String getUserPassword() {
		return userpassword;
	}
	public void setUserPassword(String userpassword) {
		this.userpassword = userpassword;
	}
	public boolean isValid() {
		return valid;
	}
	public void setValid(boolean valid) {
		this.valid = valid;
	}
	public Beneficiary getBeneficiary() {
		return beneficiary;
	}
	public void setBeneficiary(Beneficiary beneficiary) {
		this.beneficiary = beneficiary;
	}
	public Staff getStaff() {
		return staff;
	}
	public void setStaff(Staff staff) {
		this.staff = staff;
	}
	
	
}