package application;

import java.io.IOException;

import BusniessLogic.PermanentStaff;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class adminPortalController {
	PermanentStaff ps = new PermanentStaff(); 
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
}
