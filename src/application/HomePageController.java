package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class HomePageController {
	@FXML
    private Button adminButton;

    @FXML
    private Button applyButton;

    @FXML
    void ApplyPage(ActionEvent event) throws IOException {
    	Main m = new Main();
    	m.changeScene("ApplicationForm.fxml");
    }

    @FXML
    void adminLoginPage(ActionEvent event) throws IOException {
    	Main m = new Main();
    	m.changeScene("AdminLogin.fxml");
    }

}
