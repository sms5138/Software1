package Software1.Controller;

import java.io.IOException;

import Software1.Model.Product;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class products_controller {
    public Button cancelBtn;
    public Label statusFld;
    public TextField idFld;
    public TextField nameFld;
    public TextField invFld;
    public TextField priceFld;
    public TextField minFld;
    public TextField maxFld;
    public TextField machineIDFld;
    public static Product receivedPart = null;

    public static int receivedIndex;

    @FXML
    private void initialize() throws IOException {

        if(statusFld.getText() == "Add"){
        }else{
            nameFld.setText(receivedPart.getName());
            invFld.setText(String.valueOf(receivedPart.getStock()));
            minFld.setText(String.valueOf(receivedPart.getMin()));
            maxFld.setText(String.valueOf(receivedPart.getMax()));
            priceFld.setText(String.valueOf(receivedPart.getPrice()));
            idFld.setText(String.valueOf(receivedPart.getId()));
        }
    }
    
    public static void ReceiveIncomingData(Product passedPart, int passedIndex){
        receivedPart = passedPart;
        receivedIndex = passedIndex;
    }

    public void handleCloseButtonAction(ActionEvent event) {
        Stage stage = (Stage) cancelBtn.getScene().getWindow();
        stage.close();
    }

    public void setMode(String mode){
        statusFld.setText(mode);
    }
}