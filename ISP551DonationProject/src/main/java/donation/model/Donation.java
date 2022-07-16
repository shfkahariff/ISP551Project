package donation.model;

public class Donation {
	private int donationno;
	private String donationtype;
	private String donationdate;
	private double donationtotal;
	
	public Donation() {
		
	}

	public int getDonationno() {
		return donationno;
	}

	public void setDonationno(int donationno) {
		this.donationno = donationno;
	}

	public String getDonationtype() {
		return donationtype;
	}

	public void setDonationtype(String donationtype) {
		this.donationtype = donationtype;
	}

	public String getDonationdate() {
		return donationdate;
	}

	public void setDonationdate(String donationdate) {
		this.donationdate = donationdate;
	}

	public double getDonationtotal() {
		return donationtotal;
	}

	public void setDonationtotal(double donationtotal) {
		this.donationtotal = donationtotal;
	}


}