package donation.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import donation.db.ConnectionManager;
import donation.model.Beneficiary;

public class BeneficiaryDAO {

	static Connection con = null;
	static ResultSet rs = null; 
	static PreparedStatement ps=null;
	static Statement stmt=null;
	String beneficiaryic;
	static String userid;
	String address;
	String category;
	String occupation;
	String bankaccno;
	String banktype;
	String donationform;
	String status;
	int noofdependents;
	double monthlyincome;

	//list beneficiary
	public static List<Beneficiary> getAllBeneficiary() {
		List<Beneficiary> bens = new ArrayList<Beneficiary>();
		try {
			//call getConnection() method
			con = ConnectionManager.getConnection();
			//3. create statement  
			stmt = con.createStatement();
			//4. execute query
			rs = stmt.executeQuery("select * from beneficiary order by beneficiaryic");

			while (rs.next()) {
				Beneficiary ben = new Beneficiary();
				ben.setBeneficiaryIC(rs.getString("beneficiaryic"));
				ben.setAddress(rs.getString("address"));
				ben.setCategory(rs.getString("category"));
				ben.setOccupation(rs.getString("occupation"));
				ben.setMonthlyIncome(rs.getDouble("monthlyincome"));
				ben.setBankAccNo(rs.getString("bankaccno"));
				ben.setBankType(rs.getString("banktype"));
				ben.setNoOfDependents(rs.getInt("noofdependents"));				
				ben.setDonationForm(rs.getString("donationform"));
				ben.setStatus(rs.getString("status"));
				ben.setUserID(rs.getString("userid"));
				bens.add(ben);
			}
			//5. close connection
			con.close();
		}catch(Exception e) {
			e.printStackTrace();		
		}
		return bens;
	}


	//get beneficiary by beneficiaryIC
	public static Beneficiary getBeneficiaryById(String beneficiaryic) {
		Beneficiary ben = new Beneficiary();
		try {
			//call getConnection() method  
			con = ConnectionManager.getConnection();
			//3. create statement 
			ps=con.prepareStatement("select * from beneficiary where beneficiaryic=?");
			ps.setString(1, beneficiaryic);
			 //4. execute query
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {	            
				ben.setBeneficiaryIC(rs.getString("beneficiaryic"));
				ben.setAddress(rs.getString("address"));
				ben.setCategory(rs.getString("category"));
				ben.setOccupation(rs.getString("occupation"));
				ben.setMonthlyIncome(rs.getDouble("monthlyincome"));
				ben.setBankAccNo(rs.getString("bankaccno"));
				ben.setBankType(rs.getString("banktype"));
				ben.setNoOfDependents(rs.getInt("noofdependents"));				
				ben.setDonationForm(rs.getString("donationform"));
				ben.setStatus(rs.getString("status"));
				ben.setUserID(rs.getString("userid"));
			}
			//5. close connection
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		
		}

		return ben;
	}

	//get beneficiary by userID
	public static Beneficiary getBeneficiaryId(String beneficiaryic) {
		Beneficiary ben = new Beneficiary();
		try {
			//call getConnection() method  
			con = ConnectionManager.getConnection();
			//3. create statement  
			ps=con.prepareStatement("select * from beneficiary where userid=?");
			ps.setString(1, userid);
			//4. execute query
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {	            
				ben.setBeneficiaryIC(rs.getString("beneficiaryic"));
				ben.setAddress(rs.getString("address"));
				ben.setCategory(rs.getString("category"));
				ben.setOccupation(rs.getString("occupation"));
				ben.setMonthlyIncome(rs.getDouble("monthlyincome"));
				ben.setBankAccNo(rs.getString("bankaccno"));
				ben.setBankType(rs.getString("banktype"));
				ben.setNoOfDependents(rs.getInt("noofdependents"));				
				ben.setDonationForm(rs.getString("donationform"));
				ben.setStatus(rs.getString("status"));
				ben.setUserID(rs.getString("userid"));
			}
			//5. close connection
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		
		}

		return ben;
	}


	public static List<Beneficiary> getBeneficiaryId() {
		List<Beneficiary> bens = new ArrayList<Beneficiary>();
		try {
			//call getConnection() method  			
			con = ConnectionManager.getConnection();
			//3. create statement  
			stmt = con.createStatement();
			//4. execute query
			ResultSet rs = stmt.executeQuery("select beneficiaryic, userfullname  from beneficiary b INNER JOIN users u ON b.userid = u.userid");

			while (rs.next()) {
				Beneficiary ben = new Beneficiary();
				ben.setBeneficiaryIC(rs.getString("beneficiaryic"));
				ben.setUserFullName(UserDAO.getUser(rs.getString("userfullname")));
				bens.add(ben);

			}
			//5. close connection
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		
		}

		return bens;
	}

	//update beneficiary
	public void updateBeneficiary(Beneficiary bean) {

		beneficiaryic = bean.getBeneficiaryIC();
		address = bean.getAddress();
		category = bean.getCategory();
		occupation = bean.getOccupation();
		monthlyincome = bean.getMonthlyIncome();
		bankaccno = bean.getBankAccNo();
		banktype = bean.getBankType();
		noofdependents = bean.getNoOfDependents();
		donationform = bean.getDonationForm();
		status = bean.getStatus();

		try {
			//call getConnection() method  
			con = ConnectionManager.getConnection();
			//3. create statement  
			ps=con.prepareStatement("update beneficiary set address=?,category=?,occupation=?,monthlyincome=?,bankaccno=?,banktype=?,noofdependents=?,donationform=?, status=? WHERE beneficiaryic=?"); 		  
			ps.setString(1,address);//1 specifies the first parameter in the query i.e. name
			ps.setString(2,category);		
			ps.setString(3,occupation);
			ps.setDouble(4,monthlyincome);
			ps.setString(5,bankaccno);
			ps.setString(6,banktype);			
			ps.setInt(7,noofdependents);	
			ps.setString(8, donationform);
			ps.setString(9, status);
			ps.setString(10,beneficiaryic);
			//4. execute query
			ps.executeUpdate();

			//5. close connection
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		
		}
	}


	public void addBeneficiary(Beneficiary bean) {
		// TODO Auto-generated method stub
		beneficiaryic = bean.getBeneficiaryIC();
		address = bean.getAddress();
		category = bean.getCategory();
		occupation = bean.getOccupation();
		monthlyincome = bean.getMonthlyIncome();
		bankaccno = bean.getBankAccNo();
		banktype = bean.getBankType();
		noofdependents = bean.getNoOfDependents();
		status = bean.getStatus();
		
		try {
			//call getConnection() method  
			con = ConnectionManager.getConnection();
			//3. create statement  
			ps=con.prepareStatement("INSERT into beneficiary (beneficiaryic,address,category,occupation,monthlyincome,bankaccno,banktype,noofdependents,status) VALUES (?,?,?,?,?,?,?,?,?)"); 		  
			ps.setString(1, beneficiaryic);
			ps.setString(3,address);//1 specifies the first parameter in the query i.e. name
			ps.setString(3,category);		
			ps.setString(4,occupation);
			ps.setDouble(5,monthlyincome);
			ps.setString(6,bankaccno);
			ps.setString(7,banktype);			
			ps.setInt(8,noofdependents);	
			ps.setString(9, status);
			//4. execute query
			ps.executeUpdate();

			//5. close connection
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		
		}
	}

	
}

