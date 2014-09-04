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

public class DefectDAO {	
	
	/**
	 * Default constructor
	 */
	public DefectDAO(){
		
	}
	
	/**
	 * Create a Connection object to database in MySQL
	 * @return return the Connection object
	 */
	public Connection getConnection(){
		
		Connection connection = null;	
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			String data = "jdbc:mysql://db4free.net:3306/defectdb";
			connection = DriverManager.getConnection(data , "uciteamb", "admin11");
		}
		catch(ClassNotFoundException e){
			System.out.println(e.getMessage());
		}
		catch(SQLException e){
			System.out.println("SQL Error: " + e.getMessage());
		}
		return connection;
	}
	
	/**
	 * Validate user login based on user email and password
	 * @param email the user email
	 * @param password the user password
	 * @return true if user email and password exist and match in database
	 */
	public Boolean checkLogin(String email, String password){
		
		Connection con = getConnection();
		
		try{
			String sql = "SELECT * FROM staff WHERE EMAIL=? AND PASSWORD=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, email);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()){
				return true;
			}
			else{
				return false;
			}
		}
		catch(SQLException e){
			System.out.println("SQL Error: " + e.getMessage());
			return false;
		}
		catch(Exception e){
			System.out.println(e.getMessage());
			return false;
		}
	}	
	
	/**
	 * Retrieve ResultSet of all defects ordered by defect ID
	 * @return ResultSet of all defects 
	 */
	public ResultSet getAllDefects(){
		
		Connection con = getConnection();
		
		try{
			Statement statement = con.createStatement();
			ResultSet rows;
			String sql = "SELECT * FROM defect ORDER BY DEFECT_ID";
			rows = statement.executeQuery(sql);
			return rows;
		}
		catch(SQLException e){
			System.out.println("SQL Error: " + e.getMessage());
		}
		return null;
	}
	
	/**
	 * Return ResultSet of all defects from an application
	 * @param appName the application name
	 * @return ResultSet of defects based on application name
	 */
	public ResultSet getDefectsByApp(String appName){
		
		Connection con = getConnection();
		
		try{
			String sql = "SELECT * FROM defect WHERE APPLICATION=? ORDER BY DEFECT_ID";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, appName);
			ResultSet rows = ps.executeQuery();
			return rows;
		}
		catch(SQLException e){
			System.out.println("SQL Error: " + e.getMessage());
		}
		return null;
	}
	
	
	/**
	 * Retrieve ResultSet of defect ID and summary values from an application
	 * @param appName the application name
	 * @return ResultSet of defect ID and summary values
	 */
	public ResultSet getListPanel(String appName){
		
		Connection con = getConnection();
		
		try{
			String sql = "SELECT DEFECT_ID, SUMMARY FROM defect "
					+ "WHERE APPLICATION=? ORDER BY DEFECT_ID";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, appName);
			ResultSet rows = ps.executeQuery();
			return rows;
		}
		catch(SQLException e){
			System.out.println("SQL Error: " + e.getMessage());
		}
		return null;
	}
	
	
	/**
	 * Extract ResultSet values to new Defect object
	 * @param rs ResultSet of defects to be extracted
	 * @return new defect object
	 */
	public Defect getDefect(ResultSet rs){
		try
		{				
			String appName = rs.getString("APPLICATION");
			int defectID = rs.getInt("DEFECT_ID");
			String defectStatus = rs.getString("STATUS");
			Date dateCreated = rs.getDate("DATE_CREATED");
			String defectSummary = rs.getString("SUMMARY");
			String defectDesc = rs.getString("DESCRIPTION");
			String assignee = rs.getString("ASSIGNEE");
			int priority = rs.getInt("PRIORITY");
			String finalResolution = rs.getString("FINAL_RESOLUTION");
			Date resolutionDate = rs.getDate("RESOLUTION_DATE");
			
			Defect newDefect = new Defect (appName, defectStatus, dateCreated,
					defectSummary, defectDesc, assignee, priority, finalResolution,
					resolutionDate);
			newDefect.setDefectID(defectID);
			
			return newDefect;
		}
		catch(SQLException e){
			System.out.println("SQL Error: " + e.getMessage());
		}
		return null;
	}
	
	/**
	 * Insert a new row in the DEFECT table in database
	 * @param d the defect to be added
	 */
	public void addDefect(Defect d){
		
		Connection con = getConnection();
		
		try{
			
			String sql = "INSERT INTO defect"
					+ "(APPLICATION, STATUS, DATE_CREATED,"
					+ "SUMMARY, DESCRIPTION, ASSIGNEE, PRIORITY,"
					+ "FINAL_RESOLUTION, RESOLUTION_DATE)"
					+ "VALUES (?,?,?,?,?,?,?,?,?)";
			
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, d.getAppName());
			ps.setString(2, d.getDefectStatus());
			ps.setDate(3, (Date)d.getDateCreated());
			ps.setString(4, d.getDefectSummary());
			ps.setString(5, d.getDefectDesc());
			ps.setString(6, d.getAssignee());
			ps.setInt(7, d.getPriority());
			ps.setString(8, d.getFinalResolution());
			ps.setDate(9, (Date)d.getResolutionDate());
			ps.executeUpdate();
			
		}catch (SQLException e){
			System.out.println("SQL Error: " + e.getMessage());
		}
	}
	
	/**
	 * Update a row in DEFECT table in database
	 * @param d the defect to be updated
	 */
	public void updateDefect(Defect d){
		
		Connection con = getConnection();
		
		try{
			
			String sql = "UPDATE defect "
					+ "SET APPLICATION=?, STATUS=?, DATE_CREATED=?,"
					+ "SUMMARY=?, DESCRIPTION=?, ASSIGNEE=?, PRIORITY=?,"
					+ "FINAL_RESOLUTION=?, RESOLUTION_DATE=?"
					+ "WHERE DEFECT_ID=?";
					
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, d.getAppName());
			ps.setString(2, d.getDefectStatus());
			ps.setDate(3, (Date)d.getDateCreated());
			ps.setString(4, d.getDefectSummary());
			ps.setString(5, d.getDefectDesc());
			ps.setString(6, d.getAssignee());
			ps.setInt(7, d.getPriority());
			ps.setString(8, d.getFinalResolution());
			ps.setDate(9, (Date)d.getResolutionDate());
			ps.setInt(10, d.getDefectID());
			
			ps.executeUpdate();
		}
		catch(SQLException e){
			System.out.println("SQL Error: " + e.getMessage());
		}
	}
}
	
	
	
