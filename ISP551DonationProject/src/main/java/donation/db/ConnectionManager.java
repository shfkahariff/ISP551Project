package donation.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
	static Connection con;
	private static final String DB_DRIVER="org.postgresql.Driver";
	private static final String DB_CONNECTION="jdbc:postgres://ec2-44-196-174-238.compute-1.amazonaws.com:5432/d3t8dfkls27nvs";
	private static final String DB_USER="hlrbheqbczvkck";
	private static final String DB_PASSWORD="fb1bb3afb74dce1181912d32f2115b7380b1eee6081e20073d4de3d522f6e8de";
	
	public static Connection getConnection() {
		try {
			//load the driver
			Class.forName(DB_DRIVER);
			
			try {
				con = DriverManager.getConnection(DB_CONNECTION,DB_USER,DB_PASSWORD);
				System.out.println("Connected");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch(ClassNotFoundException e ) {
			e.printStackTrace();
		}
		return con;
	}
}
