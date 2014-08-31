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
	
	/**
	 * Retrieves ResultSet of all defects
	 * @return ResultSet of all defects 
	 */
	public ResultSet getAllDefects()
	{
		Connection con = getConnection();
		try{
			Statement statement = con.createStatement();
			ResultSet rows;
			String sql = "SELECT * FROM DEFECT ORDER BY DEFECT_ID";
			rows = statement.executeQuery(sql);
			return rows;
		}
		catch(Exception e){
			//Something
		}
		return null;
	}
	
	/**
	 * Converts ResultSet to Defect
	 * @param defects - ResultSet of defects to be converted
	 * @return defect
	 */
	public Defect getDefect(ResultSet defects){
		try
		{				
			String appName = defects.getString("APPLICATION");
			int defectID = defects.getInt("DEFECT_ID");
			String defectStatus = defects.getString("STATUS");
			Date dateCreated = defects.getDate("DATE_CREATED");
			String defectSummary = defects.getString("SUMMARY");
			String defectDesc = defects.getString("DESCRIPTION");
			String assignee = defects.getString("ASSIGNEE");
			int priority = defects.getInt("PRIORITY");
			String finalResolution = defects.getString("FINAL_RESOLUTION");
			Date resolutionDate = defects.getDate("RESOLUTION_DATE");
			
			Defect newDefect = new Defect (appName, defectStatus, dateCreated,
					defectSummary, defectDesc, assignee, priority, finalResolution,
					resolutionDate);
			newDefect.setDefectID(defectID);
			
			return newDefect;
		}
		catch(Exception e){
			//something
		}
		return null;
	}
	
	/**
	 * Inserts a new row in defectdb in MySQL
	 * @param defect - defect to be added
	 */
	public void addDefect(Defect defect){
		
		Connection con = getConnection();
		
		try{
			
			String sql = "INSERT INTO DEFECT(APPLICATION, STATUS, DATE_CREATED,"
					+ "SUMMARY, DESCRIPTION, ASSIGNEE, PRIORITY, FINAL_RESOLUTION, RESOLUTION_DATE)"
					+ "VALUES (?,?,?,?,?,?,?,?,?)";
			
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1,  defect.getAppName());
			ps.setString(2, defect.getDefectStatus());
			ps.setDate(3, (Date)defect.getDateCreated());
			ps.setString(4, defect.getDefectSummary());
			ps.setString(5, defect.getDefectDesc());
			ps.setString(6, defect.getAssignee());
			ps.setInt(7, defect.getPriority());
			ps.setString(8, defect.getFinalResolution());
			ps.setDate(9, (Date)defect.getResolutionDate());
			ps.executeUpdate();
			
		}catch (SQLException e){
			System.out.println("SQL Error: " + e.getMessage());
		}
	}
	
	/**
	 * Updates a row in defectdb in MySQL
	 * @param defect - defect to be updated
	 */
	public void updateDefect(Defect defect){
		Connection con = getConnection();
		try{
			
			String sql = "UPDATE DEFECT SET APPLICATION=?, STATUS=?, DATE_CREATED=?,"
					+ "SUMMARY=?, DESCRIPTION=?, ASSIGNEE=?, PRIORITY=?, FINAL_RESOLUTION=?, RESOLUTION_DATE=?"
					+ "WHERE DEFECT_ID=?";
					
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1,  defect.getAppName());
			ps.setString(3, defect.getDefectStatus());
			ps.setDate(4, (Date)defect.getDateCreated());
			ps.setString(5, defect.getDefectSummary());
			ps.setString(6, defect.getDefectDesc());
			ps.setString(7, defect.getAssignee());
			ps.setInt(8, defect.getPriority());
			ps.setString(9, defect.getFinalResolution());
			ps.setDate(10, (Date)defect.getResolutionDate());
			ps.executeUpdate();
		}
		catch(Exception e){
			//something
		}
	}
}
	
	
	
