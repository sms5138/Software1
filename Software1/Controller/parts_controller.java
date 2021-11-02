package Software1.Controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class parts_controller {
    public Button cancelBtn;
    public Label statusFld;

    @FXML
    private void initialize() throws IOException {
        var brTest = new BufferedReader(new FileReader("./Software1/state"));
        var text = brTest .readLine();
        statusFld.setText(text);
        brTest.close();
    }

    public void handleCloseButtonAction(ActionEvent event) {
        Stage stage = (Stage) cancelBtn.getScene().getWindow();
        stage.close();
    }
}
