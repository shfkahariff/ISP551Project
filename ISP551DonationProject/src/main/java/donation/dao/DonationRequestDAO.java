package donation.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import donation.db.*;
import donation.model.*;

public class DonationRequestDAO {
	static Connection con = null;
	static ResultSet rs = null; 
	static PreparedStatement ps=null;
	static Statement stmt=null;
	int requestno;
	int beneficiaryic, managerid, donationno;
	String requestdate, requestapproval;
	double requestamount;
	
	//add DonationRequest
	public void createDonationRequest(DonationRequest bean) {
		requestdate = bean.getRequestdate();
		requestamount = bean.getRequestamount();
		requestapproval = bean.getRequestapproval();
		managerid = bean.getManagerID();
		beneficiaryic = bean.getBeneficiaryIC();
		donationno = bean.getDonationno();
		
		try {
			con = ConnectionManager.getConnection();
			ps=con.prepareStatement("insert into donationrequest(requestdate,requestamount,requestapproval,managerid,beneficiaryic,donationno)values(?,?,?,?,?,?,?)");
			ps.setString(1, requestdate);
			ps.setDouble(2, requestamount);
			ps.setString(3, requestapproval);
			ps.setInt(4, managerid);
			ps.setInt(5, beneficiaryic);
			ps.setInt(6, donationno);
			
			ps.executeUpdate();
			
			con.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//list donation request
	public static List<DonationRequest> getAllDonationRequest() {
		List <DonationRequest> donationrequests = new ArrayList<DonationRequest>();
		try {
			con = ConnectionManager.getConnection();
			
			stmt = con.createStatement();
			
			rs = stmt.executeQuery("select * from donationrequest order by requestno");
			
			while (rs.next()) {
				DonationRequest donreq = new DonationRequest();
				donreq.setRequestno(rs.getInt("requestno"));
				donreq.setRequestdate(rs.getString("requestdate"));
				donreq.setRequestamount(rs.getDouble("requestamount"));
				donreq.setRequestapproval(rs.getString("requestapproval"));
				donreq.setManagerID(rs.getInt("managerid"));
				donreq.setBeneficiaryIC(rs.getInt("beneficiaryic"));
				donreq.setDonationno(rs.getInt("donationno"));
				donationrequests.add(donreq);
				
				
			}
			con.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return donationrequests;
	}
	
	//get requestno by id
	public static DonationRequest getDonationRequestByNo(int requestno) {
		DonationRequest donreq = new DonationRequest();
		try {
			con = ConnectionManager.getConnection();
			ps=con.prepareStatement("select * from donationrequest where requestno=?");
			ps.setInt(1, requestno);
			rs = ps.executeQuery();
			
			if (rs.next()) {
			donreq.setRequestno(rs.getInt("requestno"));
			donreq.setRequestdate(rs.getString("requestdate"));
			donreq.setRequestamount(rs.getDouble("requestamount"));
			donreq.setRequestapproval(rs.getString("requestapproval"));
			donreq.setManagerID(rs.getInt("managerid"));
			donreq.setBeneficiaryIC(rs.getInt("beneficiaryic"));
			donreq.setDonationno(rs.getInt("donationno"));
		}
			con.close();
		
		} catch(Exception e) {
			e.printStackTrace();
		}
		return donreq;
	}
	
	//update donationrequest
	public void updateDonationRequest(DonationRequest bean) {
		requestno = bean.getRequestno();
		requestdate = bean.getRequestdate();
		requestamount = bean.getRequestamount();
		requestapproval = bean.getRequestapproval();
		managerid = bean.getManagerID();
		beneficiaryic = bean.getBeneficiaryIC();
		donationno = bean.getDonationno();
		
		String searchQuery = "UPDATE product SET requestdate= '" + requestdate + "', requestamount ='" + requestamount + "', requestapproval='" + requestapproval + "', managerid='" + managerid + "', beneficiaryic='" + beneficiaryic + "', donationno='" + donationno + "' WHERE requestno= '" + requestno+ "'";
		try {
			con = ConnectionManager.getConnection();
			stmt = con.createStatement();
			stmt.executeUpdate(searchQuery);
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//get donationrequest manager
	
}
