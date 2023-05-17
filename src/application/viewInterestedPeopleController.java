package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class viewInterestedPeopleController {
	@FXML
    private Button HireButton;

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

    @FXML
    void toHome(ActionEvent event) throws IOException {
    	Main m = new Main();
		m.changeScene("RestaurantPage.fxml");
    }

}
