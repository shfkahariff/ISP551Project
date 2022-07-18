package donation.model;

public class DonationRequest {
	private int requestno;
	private String requestdate;
	private double requestamount;
	private String requestapproval;
	private int beneficiaryic;
	private int managerid;
	private int donationno;
	private Staff manager;
	private Beneficiary beneficiary;
	private Donation donation;
	
	public int getRequestno() {
		return requestno;
	}
	public void setRequestno(int requestno) {
		this.requestno = requestno;
	}
	public String getRequestdate() {
		return requestdate;
	}
	public void setRequestdate(String requestdate) {
		this.requestdate = requestdate;
	}
	public double getRequestamount() {
		return requestamount;
	}
	public void setRequestamount(double requestamount) {
		this.requestamount = requestamount;
	}
	public String getRequestapproval() {
		return requestapproval;
	}
	public void setRequestapproval(String requestapproval) {
		this.requestapproval = requestapproval;
	}
	public Staff getManager() {
		return manager;
	}
	public void setManager(Staff manager) {
		this.manager = manager;
	}
	public Beneficiary getBeneficiary() {
		return beneficiary;
	}
	public void setBeneficiary(Beneficiary beneficiary) {
		this.beneficiary = beneficiary;
	}
	public Donation getDonation() {
		return donation;
	}
	public void setDonation(Donation donation) {
		this.donation = donation;
	}
	public int getBeneficiaryIC() {
		return beneficiaryic;
	}
	public void setBeneficiaryIC(int beneficiaryIC) {
		this.beneficiaryic = beneficiaryIC;
	}
	public int getManagerID() {
		return managerid;
	}
	public void setManagerID(int managerID) {
		this.managerid = managerID;
	}
	public int getDonationno() {
		return donationno;
	}

	public void setDonationno(int donationno) {
		this.donationno = donationno;
	}
	
	
}
