package donation.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import donation.db.ConnectionManager;
import donation.model.Staff;

public class StaffDAO {

	static Connection con = null;
	static ResultSet rs = null; 
	static PreparedStatement ps=null;
	static Statement stmt=null;
	String role;
	static String managerid; 	

	//list staff
	public static List<Staff> getAllStaff() {
		List<Staff> staff = new ArrayList<Staff>();
		try {
			//call getConnection() method 
			con = ConnectionManager.getConnection();
			//3. create statement 
			stmt = con.createStatement();
			//4. execute query
			rs = stmt.executeQuery("select managerid, userfullname, role, userid from staff s INNER JOIN users u ON s.userid = u.userid order by managerid");

			while (rs.next()) {
				Staff st = new Staff();
				st.setManagerID(rs.getString("managerid"));
				st.setUserFullName(UserDAO.getUser(rs.getString("userfullname")));
				st.setRole(rs.getString("role"));
				st.setUserID(rs.getString("userid"));
				staff.add(st);

			}
			//5. close connection
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		
		}

		return staff;
	}


	//get staff by managerid
	public static Staff getStaffById(String managerid) {
		Staff st = new Staff();
		try {
			//call getConnection() method 
			con = ConnectionManager.getConnection();
			//3. create statement 
			ps=con.prepareStatement("select managerid, userfullname, role, userid from staff s INNER JOIN users u ON s.userid = u.userid where managerid=?");
			ps.setString(1, managerid);
			//4. execute query
			rs = ps.executeQuery();
			if (rs.next()) {	            
				st.setManagerID(rs.getString("managerid"));
				st.setUserFullName(UserDAO.getUser(rs.getString("userfullname")));
				st.setRole(rs.getString("role"));
				st.setUserID(rs.getString("userid"));
				}
			//5. close connection
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		
		}

		return st;
	}

	//get staff by userid
	public static Staff getStaffId(String userid) {
		
		Staff st = new Staff();
		try {
			//call getConnection() method 
			con = ConnectionManager.getConnection();
			//3. create statement 
			ps=con.prepareStatement("select managerid, userfullname, role, userid from staff s INNER JOIN users u ON s.userid = u.userid where userid=?");
			ps.setString(1, userid);
			//4. execute query
			rs = ps.executeQuery();

			if (rs.next()) {	            
				st.setManagerID(rs.getString("managerid"));
				st.setUserFullName(UserDAO.getUser(rs.getString("userfullname")));
				st.setRole(rs.getString("role"));
				st.setUserID(rs.getString("userid"));
			}
			//5. close connection
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		
		}

		return st;
	}


	public static List<Staff> getStaffId() {
		List<Staff> staff = new ArrayList<Staff>();
		try {
			//call getConnection() method 
			con = ConnectionManager.getConnection();
			//3. create statement 
			stmt = con.createStatement();
			//4. execute query
			rs = stmt.executeQuery("select managerid, userfullname  from staff s INNER JOIN users u ON s.userid = u.userid");
			while (rs.next()) {
				Staff st = new Staff();
				st.setManagerID(rs.getString("managerid"));
				st.setUserFullName(UserDAO.getUser(rs.getString("userfullname")));
				
				staff.add(st);

			}
			//5. close connection
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		
		}

		return staff;
	}

	//update staff
	public void updateStaff(Staff bean) {

		managerid = bean.getManagerID();
		role = bean.getRole();	

		try {
			//call getConnection() method
			con = ConnectionManager.getConnection();
			//3. create statement 
			ps=con.prepareStatement("update staff set role=? WHERE managerid=?"); 		  
			ps.setString(1,role); //1 specifies the first parameter in the query i.e. name			
			ps.setString(2,managerid);
			//4. execute query
			ps.executeUpdate();
			//5. close connection
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		
		}
	}

	
}

