package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class applicationFormController {
	@FXML
    private TextField EmailField;

    @FXML
    private TextField NameField;

    @FXML
    private TextField QualificationField;

    @FXML
    private Button applyButton;

    @FXML
    void BackToHome(ActionEvent event) throws IOException {
    	Main m = new Main();
    	m.changeScene("HomePage.fxml");
    }

}
