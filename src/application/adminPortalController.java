package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import BusniessLogic.PermanentStaff;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class adminPortalController implements Initializable{
	PermanentStaff ps = new PermanentStaff();
	
	 @FXML
	 private Label name;
	
	@FXML
    private Button InterestedPeopleButton;

    @FXML
    private Button LogOutButton;

    @FXML
    void toHomePage(ActionEvent event) throws IOException {
    	int id = ps.currentAdmin();
    	ps.logout(id);
    	Main m = new Main();
    	m.changeScene("HomePage.fxml");
    }
    @FXML
    void InterestedPeoplePage(ActionEvent event) throws IOException {
    	Main m = new Main();
    	m.changeScene("ViewInterestedPeople.fxml");
    }
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		name.setText(ps.currentAdminName());
		
	}
}
