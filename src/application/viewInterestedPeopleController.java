package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class viewInterestedPeopleController {
	@FXML
    private Button HireButton;
	
	@FXML
    private Button GoBackButton;

    @FXML
    private TableColumn<?, ?> peopleAppliedAvailability;

    @FXML
    private TableColumn<?, ?> peopleAppliedEmail;

    @FXML
    private TableColumn<?, ?> peopleAppliedID;

    @FXML
    private TableColumn<?, ?> peopleAppliedName;

    @FXML
    private TableColumn<?, ?> peopleAppliedQualification;

    //This is the hire button and will prompt that the selected user has been successfully hired
    @FXML
    void toHome(ActionEvent event) throws IOException {
    	Main m = new Main();
		m.changeScene("HomePage.fxml");
    }
    
    //this is the go back button that will take the user back to the amdin portal
    @FXML
    void goToHome(ActionEvent event) throws IOException {
    	Main m = new Main();
		m.changeScene("AdminPortal.fxml");
    }

}
