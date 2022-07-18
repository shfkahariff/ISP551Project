package donation.dao;

import java.security.*;
import java.sql.*;
import java.util.*;
import donation.db.ConnectionManager;
import donation.model.User;

public class UserDAO {

	static Connection con = null;
	static ResultSet rs = null; 
	static PreparedStatement ps=null;
	static Statement stmt=null;
	static String useremail, userpassword, username, usercontactno, userfullname;
	static String userid;

	//method for login
	@SuppressWarnings("hiding")
	public static <User> User login(User bean) throws NoSuchAlgorithmException{
		//get email and password
		useremail = ((donation.model.User) bean).getUserEmail();
		userpassword = ((donation.model.User) bean).getUserPassword();

		//convert the password to MD5
		MessageDigest md = MessageDigest.getInstance("MD5");
		md.update(userpassword.getBytes());

		byte byteData[] = md.digest();

		//convert the byte to hex format
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < byteData.length; i++) {
			sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
		}

		String query = "select * from users where useremail='" + useremail + "'AND userpassword='" + sb.toString() + "'";

		try {
			//call getConnection() method //3. create statement  //4. execute query
			con = ConnectionManager.getConnection();
			//3. create statement
			stmt = con.createStatement();
		    //4. execute query
			rs = stmt.executeQuery(query);
			boolean more = rs.next();

			// if user exists set the isValid variable to true
			if (more) {
				String userid = rs.getString("userid");
				String useremail = rs.getString("useremail");
				String username = rs.getString("username");
				((donation.model.User) bean).setUserID(userid);
				((donation.model.User) bean).setUserEmail(useremail);
				((donation.model.User) bean).setUsername(username);

				System.out.println(username);
				((donation.model.User) bean).setValid(true);
			}
			// if user does not exist set the isValid variable to false
			else if (!more) {
				((donation.model.User) bean).setValid(false);
			}

			//5. close connection
			con.close();
		}catch(Exception e) {
			e.printStackTrace();		
		}

		return bean;
	}

	//add new user (register)
	public void add(User bean) throws NoSuchAlgorithmException{
		//get email,name and password
		username = bean.getUsername();
		userfullname = bean.getUserFullName();
		usercontactno = bean.getUserContactNo();
		useremail = bean.getUserEmail();
		userpassword = bean.getUserPassword();
		MessageDigest md = MessageDigest.getInstance("MD5");
		md.update(userpassword.getBytes());

		byte byteData[] = md.digest();

		//convert the byte to hex format
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < byteData.length; i++) {
			sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
		}
		String pass = sb.toString();

		try {
			//call getConnection() method 
			con = ConnectionManager.getConnection();
			//3. create statement  
			ps=con.prepareStatement("insert into users(username,userfullname,usercontactno,useremail,userpassword)values(?,?,?,?,?)");
			ps.setString(1,username);
			ps.setString(2,userfullname);
			ps.setString(3, usercontactno);
			ps.setString(4, useremail);
			ps.setString(5, pass);

			//4. execute query
			ps.executeUpdate();			
			
			//5. close connection
			con.close();
		}catch(Exception e) {
			e.printStackTrace();		
		}

	}
	
	//method to get user
	public static User getUser(User bean)  {   
		//get email
		useremail = bean.getUserEmail();
		String searchQuery = "select * from users where useremail='" + useremail + "'";
		try {
			//call getConnection() method 
			con = ConnectionManager.getConnection();
			//3. create statement  
			stmt = con.createStatement();
			//execute statement
			rs = stmt.executeQuery(searchQuery);

			boolean more = rs.next();

			// if user exists set the isValid variable to true
			if (more) {
				String useremail = rs.getString("useremail");
				bean.setUserEmail(useremail);
				bean.setValid(true);
			}
			// if user does not exist set the isValid variable to false
			else if (!more) {
				bean.setValid(false);
			}
			//5. close connection
			con.close();	
		}catch(Exception e) {
			e.printStackTrace();		
		}
		return bean;
	}

	//get user by email
	public static User getUserByEmail(String useremail) {
		User us = new User();
		try {
			//call getConnection() method 
			con = ConnectionManager.getConnection();
			//3. create statement  
			ps=con.prepareStatement("select * from users where useremail=?");
			ps.setString(1, useremail);
			//4. execute query
			rs = ps.executeQuery();

			if (rs.next()) {	            
				us.setUserID(rs.getString("userid"));
				us.setUserEmail(rs.getString("useremail"));				
				us.setUserPassword(rs.getString("userpassword"));

			}
			//5. close connection
			con.close();
		}catch(Exception e) {
			e.printStackTrace();		
		}

		return us;
	}

	//get user by id
	public static User getUserById(int userid) {
		User us = new User();
		try {
			//call getConnection() method 
			con = ConnectionManager.getConnection();
			//3. create statement  
			ps=con.prepareStatement("select * from users where userid=?");
			ps.setInt(1, userid);
			//4. execute query
			rs = ps.executeQuery();

			if (rs.next()) {
				us.setUserID(rs.getString("userid"));
				us.setUserEmail(rs.getString("useremail"));
				us.setUserPassword(rs.getString("userpassword"));

			}
			//5. close connection
			con.close();
		}catch(Exception e) {
			e.printStackTrace();		
		}

		return us;
	}
	

	public static List<User> getUserId() {
		List<User> users = new ArrayList<User>();
		try {
			//call getConnection() method 
			con = ConnectionManager.getConnection();
			//3. create statement  
			stmt = con.createStatement();
			//4. execute query
			rs = stmt.executeQuery("select userid, useremail from users");

			while (rs.next()) {
				User us = new User();
				us.setUserID(rs.getString("userid"));
				us.setUserEmail(rs.getString("useremail"));
				users.add(us);

			}
			//5. close connection
			con.close();
		}catch(Exception e) {
			e.printStackTrace();		
		}

		return users;
	}
	
	public static List<User> getUserBeneficiary() {
		List<User> users = new ArrayList<User>();
		try {
			//call getConnection() method 
			con = ConnectionManager.getConnection();
			//3. create statement  
			stmt = con.createStatement();
			//4. execute query
			rs = stmt.executeQuery("SELECT * FROM users u INNER JOIN beneficiary b ON u.userid = b.userid");

			while (rs.next()) {
				User us = new User();
				us.setUserID(rs.getString("userid"));
				us.setUserEmail(rs.getString("useremail"));
				us.setBeneficiary(BeneficiaryDAO.getBeneficiaryId(rs.getString("userid")));
				users.add(us);

			}
			//5. close connection
			con.close();
		}catch(Exception e) {
			e.printStackTrace();		
		}

		return users;
	}
	
	public static List<User> getUserStaff() {
		List<User> users = new ArrayList<User>();
		try {
			//call getConnection() method 
			con = ConnectionManager.getConnection();
			//3. create statement  
			stmt = con.createStatement();
			//4. execute query
			ResultSet rs = stmt.executeQuery("SELECT * FROM users u INNER JOIN staff s ON u.userid = s.userid");

			while (rs.next()) {
				User us = new User();
				us.setUserID(rs.getString("userid"));
				us.setUserEmail(rs.getString("useremail"));
				us.setStaff(StaffDAO.getStaffId(rs.getString("userid")));
				users.add(us);

			}
			//5. close connection
			con.close();
		}catch(Exception e) {
			e.printStackTrace();		
		}

		return users;
	}
		
	//delete staff and beneficiary from table users
	public void deleteUser(String userid) {
		try {
			//call getConnection() method 
			con = ConnectionManager.getConnection();
			//3. create statement  
			ps=con.prepareStatement("delete from users where userid=?");
			ps.setString(1, userid);
			//4. execute query
			ps.executeUpdate();

			//5. close connection
			con.close();
		}catch(Exception e) {
			e.printStackTrace();		
		}
	}

	public static Object getUser(String string) {
		// TODO Auto-generated method stub
		return null;
	}

}
