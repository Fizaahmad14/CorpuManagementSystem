package application;
import DataBase.DbHandler;

import java.io.IOException;
import java.util.ArrayList;
import BusniessLogic.PermanentStaff;
import BusniessLogic.psAccount;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class adminLoginController{
	
	PermanentStaff ps = new PermanentStaff();
	DbHandler db = new DbHandler();
	
	@FXML
    private TextField adminEmail;

    @FXML
    private PasswordField adminPassword;

    @FXML
    private Label invalidDetails;

    @FXML
    private Button loginButton;

    @FXML
    void AdminPortal(ActionEvent event) throws IOException {
    	ArrayList<psAccount> psList = new ArrayList<psAccount>();
    	psList = db.readAdminAccounts();
		Boolean checkUsername = false;
    	for(int i=0; i<psList.size(); i++)
    		{
    			
				if(psList.get(i).getEmail().equals(adminEmail.getText()) && psList.get(i).getPass().equals(adminPassword.getText()))
				{
					checkUsername = true;
					int id = psList.get(i).getId();
					db.saveCurrentAdmin(id);
				}
    		}
    	if(checkUsername == false)
    		invalidDetails.setText("Wrong username/password");
    	else
    	{
			Main m = new Main();
    		m.changeScene("AdminPortal.fxml");
    	}
    }
}
