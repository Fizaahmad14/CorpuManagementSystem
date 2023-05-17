package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class InterestedPeoplePortalController {
	@FXML
    private Button LogOutButton;

    @FXML
    private Button SelectUnitButton;

    @FXML
    private Button UpdateScheduleButton;

    @FXML
    void SchedulePage(ActionEvent event) throws IOException {
    	Main m = new Main();
    	m.changeScene("UpdateSchedulePage.fxml");
    }

    @FXML
    void SelectUnitPage(ActionEvent event) throws IOException {
    	Main m = new Main();
    	m.changeScene("SelectUnitPage.fxml");
    }

    @FXML
    void toHomePage(ActionEvent event) throws IOException {
    	Main m = new Main();
    	m.changeScene("HomePage.fxml");
    }
}
