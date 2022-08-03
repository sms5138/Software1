package Software2.Controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.scene.control.Button;

public class prompt_controller {
    public Label statusFld;
    public Label detailFld;
    public Button OkBtn;

    @FXML
    private void initialize() throws IOException {
        // may need to use later
    }

    public void setStatus(String status, String details){
        statusFld.setText(status);
        detailFld.setText(details);
    }
    
    public void handleCloseButtonAction(ActionEvent event) {
        Stage stage = (Stage) OkBtn.getScene().getWindow();
        stage.close();
    }
}
