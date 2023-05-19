package application;
import DataBase.DbHandler;
import java.io.IOException;
import java.util.ArrayList;
import BusniessLogic.PermanentStaff;
import BusniessLogic.psAccount;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class adminLoginController {
	
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
    	ArrayList<psAccount> ps = new ArrayList<psAccount>();
        ps = db.readAdminAccounts();
		Boolean checkUsername = false;
    	for(int i=0; i<ps.size(); i++)
    		{
    			
				if(ps.get(i).getEmail().equals(adminEmail.getText()) && ps.get(i).getPass().equals(adminPassword.getText()))
				{
					checkUsername = true;
					int id = ps.get(i).getId();
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
