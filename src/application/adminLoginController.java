package application;
import DataBase.DbHandler;

import java.io.IOException;
import java.util.ArrayList;
import BusniessLogic.Controller;
import BusniessLogic.psAccount;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class adminLoginController {
	
	
	Controller contr = new Controller();
	DbHandler db = new DbHandler();
	
	@FXML
    private TextField adminEmail;

    @FXML
    private TextField adminPassword;

    @FXML
    private Label invalidDetails;

    @FXML
    private Button loginButton;

    @FXML
    void AdminPortal(ActionEvent event) throws IOException {
    	ArrayList<psAccount> ps = new ArrayList<psAccount>();
        ps = db.readAdminAccounts();
		Boolean checkUsername = false;
    	for(int i=0; i<ps.size(); i++)
    		{
    			
	    		System.out.println("labels email = "+adminEmail.getText()+" pass = "+ adminPassword.getText());
				System.out.println("db     email = "+ps.get(i).getEmail()+" p = "+ ps.get(i).getPass());
				if(ps.get(i).getEmail().equals(adminEmail.getText()) && ps.get(i).getPass().equals(adminPassword.getText()))
				{
					checkUsername = true;
				}
    		}
    	if(checkUsername == false)
    		invalidDetails.setText("Wrong username/password");
//    	if(adminEmail.getText().isEmpty() || adminPassword.getText().isEmpty())
//    	{
//    		invalidDetails.setText("Invalid Details. Kindly enter all fields or check the username and password again.");
//    	}
    	else
    	{
			Main m = new Main();
    		m.changeScene("HomePage.fxml");
    	}
//    	else {
//    		ArrayList<PermanentStaff> perStaffList = contr.getRestaurants();
//    		
//    		PermanentStaff currRest = new PermanentStaff(); 
//    		
//    		for (PermanentStaff obj : perStaffList)
//    		{
//    			if (obj.getUserAccount().getUserName().equals(usernameRestaurant.getText()) && obj.getUserAccount().getPassword().equals(passowrdLoginRestaurant.getText()))
//    			{
//    				currRest = obj;
//    				contr.setCurrentRestaurant(obj);
//    				
//    				//Foodlist
//    				ArrayList<FoodItem> restFoodList = contr.getFoodItems();
//    				obj.getMenuObj().setFoodList(restFoodList);
//    				contr.setCurrentRestaurant(obj);
//    				
//    				//Orders
//    				ArrayList<Order> restOrders = contr.getOrders();
//    				obj.setOrderList(restOrders);
//    				contr.setCurrentRestaurant(obj);
//    				
//    				Main m = new Main();
//    	    		m.changeScene("RestaurantPage.fxml");
//    	    		break;
//    			}
//    		}
//    		invalidDetails.setText("Invalid Details");
//    		
//    		
//    	}
    }
}
