package donation.dao;

import java.sql.*;
import java.util.*;
import donation.db.*;
import donation.model.*;

public class DonationDAO {
	static Connection con = null;
	static PreparedStatement ps = null;
	static Statement st = null;
	static ResultSet rs = null;
	private int donationNo;
	private String donationDate, donationType;
	private double donationTotal;
	
	//create/add new donation
	public void createDonation(Donation bean) {
		donationType = bean.getDonationType();
		donationDate = bean.getDonationDate();
		donationTotal = bean.getDonationTotal();
		
		try {
			//call getConnection() method
			con = ConnectionManager.getConnection();
			
			//create statement
			ps = con.prepareStatement("INSERT INTO donation(donationType,donationDate,donationTotal)VALUES(?,?,?)");
			ps.setString(1, donationType);
			ps.setString(2, donationDate);
			ps.setDouble(3, donationTotal);
			//execute query
			ps.executeUpdate();
			System.out.println("Successfully inserted");
			
			//close connection
			con.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//get all donations
	public static List<Donation> getAllDonations() {
		List<Donation> donations = new ArrayList<Donation>();
		
		try {
			//call getConnection() method
			con = ConnectionManager.getConnection();
			
			//create statement
			st = con.createStatement();
			String sql = "SELECT * FROM donation ORDER BY donationNo";
			
			//execute query
			rs = st.executeQuery(sql);
			
			//process result
			while(rs.next()) {
				Donation d = new Donation();
				d.setDonationNo(rs.getInt("donationNo"));
				d.setDonationType(rs.getString("donationType"));
				d.setDonationDate(rs.getString("donationDate"));
				d.setDonationTotal(rs.getDouble("donationTotal"));
				
				donations.add(d);
}
			
			//close connection
			con.close();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return donations;
	}
	
	//get donation by donationNo
	public static Donation getDonationById(int donationNo) {
		Donation d = new Donation();
		try {
			//call getConnection method
			con = ConnectionManager.getConnection();
			
			//create statement
			ps= con.prepareStatement("SELECT * FROM donation WHERE donationNo=?");
			ps.setInt(1, donationNo);
			
			//execute query
			rs = ps.executeQuery();
			if(rs.next()) {
				d.setDonationNo(rs.getInt("donationNo"));
				d.setDonationType(rs.getString("donationType"));
				d.setDonationDate(rs.getString("donationDate"));
				d.setDonationTotal(rs.getDouble("donationTotal"));
			}
			//close connection
			con.close();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return d;
	}
	
	//delete donation
	public void deleteDonation(int donationNo) {
		try {
			//call getConnection method
			con = ConnectionManager.getConnection();
			
			//create statement
			ps = con.prepareStatement("DELETE FROM donation WHERE donationNo=?");
			ps.setInt(1, donationNo);
			
			//execute query
			ps.executeUpdate();
			
			//close connection
			con.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//update donation
	public void updateDonation(Donation bean) {
		donationNo = bean.getDonationNo();
		donationType = bean.getDonationType();
		donationDate = bean.getDonationDate();
		donationTotal = bean.getDonationTotal();
		
		try {
			//call getConnection method
			con = ConnectionManager.getConnection();
			
			//create statement
			ps = con.prepareStatement("UPDATE donation SET donationType=?, donationDate=?, donationTotal=? WHERE donationNo=?");
			ps.setString(1, donationType);
			ps.setString(2, donationDate);
			ps.setDouble(3, donationTotal);
			ps.setInt(4, donationNo);
			
			//execute query
			ps.executeUpdate();
			
			System.out.println("Successfully updated");
			
			//close connection
			con.close();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}