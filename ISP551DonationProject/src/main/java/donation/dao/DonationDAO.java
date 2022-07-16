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
	private int donationno;
	private String donationdate, donationtype;
	private double donationtotal;
	
	//create/add new donation
	public void createDonation(Donation bean) {
		donationtype = bean.getDonationtype();
		donationdate = bean.getDonationdate();
		donationtotal = bean.getDonationtotal();
		
		try {
			//call getConnection() method
			con = ConnectionManager.getConnection();
			
			//create statement
			ps = con.prepareStatement("INSERT INTO donation(donationtype,donationdate,donationtotal)VALUES(?,?,?)");
			ps.setString(1, donationtype);
			ps.setString(2, donationdate);
			ps.setDouble(3, donationtotal);
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
			String sql = "SELECT * FROM donation ORDER BY donationno";
			
			//execute query
			rs = st.executeQuery(sql);
			
			//process result
			while(rs.next()) {
				Donation d = new Donation();
				d.setDonationno(rs.getInt("donationno"));
				d.setDonationtype(rs.getString("donationtype"));
				d.setDonationdate(rs.getString("donationdate"));
				d.setDonationtotal(rs.getDouble("donationtotal"));
				
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
	public static Donation getDonationById(int donationno) {
		Donation d = new Donation();
		try {
			//call getConnection method
			con = ConnectionManager.getConnection();
			
			//create statement
			ps= con.prepareStatement("SELECT * FROM donation WHERE donationno=?");
			ps.setInt(1, donationno);
			
			//execute query
			rs = ps.executeQuery();
			if(rs.next()) {
				d.setDonationno(rs.getInt("donationno"));
				d.setDonationtype(rs.getString("donationtype"));
				d.setDonationdate(rs.getString("donationdate"));
				d.setDonationtotal(rs.getDouble("donationtotal"));
			}
			//close connection
			con.close();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return d;
	}
	
	//delete donation
	public void deleteDonation(int donationno) {
		try {
			//call getConnection method
			con = ConnectionManager.getConnection();
			
			//create statement
			ps = con.prepareStatement("DELETE FROM donation WHERE donationno=?");
			ps.setInt(1, donationno);
			
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
		donationno = bean.getDonationno();
		donationtype = bean.getDonationtype();
		donationdate = bean.getDonationdate();
		donationtotal = bean.getDonationtotal();
		
		try {
			//call getConnection method
			con = ConnectionManager.getConnection();
			
			//create statement
			ps = con.prepareStatement("UPDATE donation SET donationtype=?, donationdate=?, donationtotal=? WHERE donationno=?");
			ps.setString(1, donationtype);
			ps.setString(2, donationdate);
			ps.setDouble(3, donationtotal);
			ps.setInt(4, donationno);
			
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