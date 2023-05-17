package DataBase;
import java.sql.*;
import java.util.ArrayList;
import BusniessLogic.PermanentStaff;
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
}