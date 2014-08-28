package edu.uci.java2;
import java.sql.*;

/**
 * X460.11/1 - Java Programming II - Team B
 * DatabaseHelper.java
 * Purpose: Provides access to MySQL database
 * 
 * @author Shaun Adriano, Dennis Hom, Levi Hsiao, Susan Marosek
 * @version 1.0 8/27/2014
 */

public class DatabaseHelper {	
	
	/**
	 * Default constructor
	 */
	public DatabaseHelper(){
		
	}
	
	/**
	 * Connect to defectdb in MySQL
	 * @return returns connection object
	 */
	public Connection getConnection(){
		Connection connection = null;	
		try{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/defectdb", "root", "");
		}
		catch(Exception e){
			//something
		}
		return connection;
	}
	
	/**
	 * Validates user login
	 * @param email user email
	 * @param password user password
	 * @return 
	 */
	public Boolean checkLogin(String email, String password)
	{
		Connection con = getConnection();
		try{
			PreparedStatement ps = con.prepareStatement("SELECT * FROM USER WHERE EMAIL=? AND PASSWORD=?");
			ps.setString(1,  email);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()){
				return true;
			}
			else{
				return false;
			}
		}
		catch(Exception e){
			System.out.println("Error while");
			return false;
		}
	}		
}
	
	
	
