package donation.model;

public class Donation {
	private int donationNo;
	private String donationType;
	private String donationDate;
	private double donationTotal;
	
	public Donation() {
		
	}

	public int getDonationNo() {
		return donationNo;
	}

	public void setDonationNo(int donationNo) {
		this.donationNo = donationNo;
	}

	public String getDonationType() {
		return donationType;
	}

	public void setDonationType(String donationType) {
		this.donationType = donationType;
	}

	public String getDonationDate() {
		return donationDate;
	}

	public void setDonationDate(String donationDate) {
		this.donationDate = donationDate;
	}

	public double getDonationTotal() {
		return donationTotal;
	}

	public void setDonationTotal(double donationTotal) {
		this.donationTotal = donationTotal;
	}
}