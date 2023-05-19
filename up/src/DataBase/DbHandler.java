package DataBase;
import java.sql.*;
import java.util.ArrayList;

import BusniessLogic.InterestedPeopl;
import BusniessLogic.PermanentStaff;
import BusniessLogic.SessionalStaff;
import BusniessLogic.User;
import BusniessLogic.psAccount;

public class DbHandler {

	private String username = "root";
	private String password = "2287";
	//connection object
	Connection con;
	public DbHandler() {
		// TODO Auto-generated constructor stub
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/corpu",username,password);
			System.out.println("Connection Successfull\n");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Connection Failed\n");
			e.printStackTrace();
		}
	}
	//----------------------------------------------ADMIN ACCOUNT
	public ArrayList<psAccount> readAdminAccounts() 
	{

		ArrayList<psAccount> acc = new ArrayList<psAccount>();
		Statement stm;
		try {
			stm = con.createStatement();

			String query = "SELECT * FROM Admin_account";
			ResultSet rs = stm.executeQuery(query);
			while (rs.next()) {
				psAccount s = new psAccount(rs.getString(2), rs.getString(3));
				acc.add(s);
			}
		}
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return acc;
	}
	
	//---------------------------------------------Application Form
	public void writeInterestedData(InterestedPeopl rest) {
	    try {
	        String query = "INSERT INTO Interested (name, email, qualification, timeslot, unitName, preference) VALUES (?, ?, ?, ?, ?, ?)";
	        PreparedStatement stm = con.prepareStatement(query);

	        stm.setString(1, rest.getName());
	        stm.setString(2, rest.getEmail());
	        stm.setString(3, rest.getQualifications());
	        stm.setString(4, rest.getAvailablilityList());
	        stm.setString(5, rest.getUnit().getName());
	        stm.setString(6, rest.getPreference());

	        stm.executeUpdate();
	        System.out.println("Interested Person Successfully inserted");
	    } catch (SQLException e) {
	        System.out.println("Error in Interested Person insertion");
	        e.printStackTrace();
	    }
	}
	public ArrayList<InterestedPeopl> readUsersApplied() 
	{

		ArrayList<InterestedPeopl> acc = new ArrayList<InterestedPeopl>();
		Statement stm;
		try {
			stm = con.createStatement();

			String query = "SELECT * FROM Interested";
			ResultSet rs = stm.executeQuery(query);
			while (rs.next()) {
				InterestedPeopl s = new InterestedPeopl(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7));
				acc.add(s);
			}
		}
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return acc;
	}	
	
	//---------------------------------------------Application Form
		public void writeSessionalData(SessionalStaff rest) {
		    try {
		    	String query = "INSERT INTO SessionalStaff (name, email, qualification, timeslot, unitName, preference) VALUES (?, ?, ?, ?, ?, ?)";
		        PreparedStatement stm = con.prepareStatement(query);

		        stm.setString(1, rest.getName());
		        stm.setString(2, rest.getEmail());
		        stm.setString(3, rest.getQualifications());
		        stm.setString(4, rest.getAvailablilityList());
		        stm.setString(5, rest.getUnit().getName());
		        stm.setString(6, rest.getPreference());


		        stm.executeUpdate();
		        System.out.println("Sessional Person Successfully inserted");
		    } catch (SQLException e) {
		        System.out.println("Error in Sessional Person insertion");
		        e.printStackTrace();
		    }
		}
		
		public void deleteInterested(int id) {
		    try {
		    	String query = "DELETE FROM Interested WHERE id = ?";
		        PreparedStatement stm = con.prepareStatement(query);
		        stm.setInt(1, id);
		        stm.executeUpdate();
		        System.out.println("Dropped from Interested Successfully");
		    } catch (SQLException e) {
		        System.out.println("Error in dropping interested member");
		        e.printStackTrace();
		    }
		}
	
	
}