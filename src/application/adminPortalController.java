package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class adminPortalController {
	@FXML
    private Button InterestedPeopleButton;

    @FXML
    void InterestedPeoplePage(ActionEvent event) throws IOException {
    	Main m = new Main();
    	m.changeScene("ViewInterestedPeople.fxml");
    }
}
