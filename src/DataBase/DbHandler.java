package DataBase;
import java.sql.*;
import java.util.ArrayList;
import BusniessLogic.InterestedPeopl;
import BusniessLogic.SessionalStaff;
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

			String query = "SELECT * FROM ps_account";
			ResultSet rs = stm.executeQuery(query);
			while (rs.next()) {
				psAccount s = new psAccount(rs.getInt(1),rs.getString(2), rs.getString(3));
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
	
	//----------------------------------------------LOAD UNITS
		public ArrayList<String> readUnits() 
		{

			ArrayList<String> acc = new ArrayList<String>();
			Statement stm;
			try {
				stm = con.createStatement();

				String query = "SELECT name FROM Unit";
				ResultSet rs = stm.executeQuery(query);
				while (rs.next()) {
					String s = rs.getString(1);
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
		
		//----------------------------------------------LOAD AVAILABILITIES
		public ArrayList<String> readAvailabilities() 
		{

			ArrayList<String> acc = new ArrayList<String>();
			Statement stm;
			try {
				stm = con.createStatement();

				String query = "SELECT timeSlots FROM Availability";
				ResultSet rs = stm.executeQuery(query);
				while (rs.next()) {
					String s = rs.getString(1);
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
		
		
		//----------------------------------------------LOAD PREFERENCES
			public ArrayList<String> readPreferences() 
			{

				ArrayList<String> acc = new ArrayList<String>();
				Statement stm;
				try {
					stm = con.createStatement();

					String query = "SELECT name FROM preferences";
					ResultSet rs = stm.executeQuery(query);
					while (rs.next()) {
						String s = rs.getString(1);
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
	public ArrayList<InterestedPeopl> readUsersApplied(int id) {
	    ArrayList<InterestedPeopl> acc = new ArrayList<InterestedPeopl>();
	    try {
	        String query = "SELECT i.* FROM Interested i JOIN PermanentStaff p ON i.unitName = p.unitName WHERE p.id = ?";
	        PreparedStatement stm = con.prepareStatement(query);
	        stm.setInt(1, id);
	        ResultSet rs = stm.executeQuery();
	        while (rs.next()) {
	            InterestedPeopl s = new InterestedPeopl(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8));
	            acc.add(s);
	        }
	    } catch (SQLException e) {
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
		
		//---------------------------------------------SAVE CURRENT ADMIN
			public void saveCurrentAdmin(int id) {
			    try {
			    	String query = "INSERT INTO currentAdmin (ps_id) VALUES (?)";
			        PreparedStatement stm = con.prepareStatement(query);
			        stm.setInt(1, id);
			        stm.executeUpdate();
			        System.out.println("Current Admin Successfully inserted");
			    } catch (SQLException e) {
			        System.out.println("Error in Current Admin insertion");
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
		
		//---------------------------------------------read

		public int readCurrentAdmin() 
		{
			int id = 0;
			Statement stm;
			try {
				stm = con.createStatement();
				String query = "SELECT ps_id FROM CurrentAdmin";
				ResultSet rs = stm.executeQuery(query);
				while(rs.next()) {
				id = rs.getInt(1);
				System.out.println("rs.getInt(1) : "+rs.getInt(1));
				}
			}
			catch (SQLException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return id;
		}
		
		//---------------------------------------------LOGOUT

		public void logout(int id) 
		{
			try {
		    	String query = "DELETE FROM currentAdmin WHERE ps_id = ?";
		        PreparedStatement stm = con.prepareStatement(query);
		        stm.setInt(1, id);
		        stm.executeUpdate();
		        System.out.println("Logged out Successfully");
		    } catch (SQLException e) {
		        System.out.println("Error in logging out");
		        e.printStackTrace();
		    }
		}
		
		
	
	
}