package donation.model;

public class Beneficiary {
	private String beneficiaryic;
	private String address;
	private String category;
	private String occupation;
	private double monthlyincome;
	private String bankaccno;
	private String banktype;
	private int noofdependents;
	
	private String donationform;
	private String status;
	private String userid;
	
	public String getBeneficiaryIC() {
		return beneficiaryic;
	}
	public void setBeneficiaryIC(String beneficiaryIC) {
		this.beneficiaryic = beneficiaryIC;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getOccupation() {
		return occupation;
	}
	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}
	public double getMonthlyIncome() {
		return monthlyincome;
	}
	public void setMonthlyIncome(double monthlyIncome) {
		this.monthlyincome = monthlyIncome;
	}
	public String getBankAccNo() {
		return bankaccno;
	}
	public void setBankAccNo(String bankAccNo) {
		this.bankaccno = bankAccNo;
	}
	public String getBankType() {
		return banktype;
	}
	public void setBankType(String bankType) {
		this.banktype = bankType;
	}
	public int getNoOfDependents() {
		return noofdependents;
	}
	public void setNoOfDependents(int noOfDependents) {
		this.noofdependents = noOfDependents;
	}
	public String getDonationForm() {
		return donationform;
	}
	public void setDonationForm(String donationForm) {
		this.donationform = donationForm;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getUserID() {
		return userid;
	}
	public void setUserID(String userID) {
		this.userid = userID;
	}
	public void setUserFullName(Object user) {
		// TODO Auto-generated method stub
		
	}
	
	
}
