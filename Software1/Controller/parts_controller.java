package Software1.Controller;

import java.io.IOException;

import Software1.Model.Part;
import Software1.Model.part_inventory;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

public class parts_controller {
    public Button cancelBtn;
    public Button saveBtn;
    public Label statusFld;
    public TextField idFld;
    public TextField nameFld;
    public TextField invFld;
    public TextField priceFld;
    public TextField minFld;
    public TextField maxFld;
    public TextField machineIDFld;
    public RadioButton inhouseRadio;
    public RadioButton outsourceRadio;

    public static Part receivedPart = null;

    public static int receivedIndex;

    public static void ReceiveIncomingData(Part passedPart, int passedIndex){
        receivedPart = passedPart;
        receivedIndex = passedIndex;
    }

    @FXML
    private void initialize() throws IOException {
        // Create group for toggle buttons
        ToggleGroup group = new ToggleGroup();
        inhouseRadio.setToggleGroup(group);
        outsourceRadio.setSelected(true);
        outsourceRadio.setToggleGroup(group);

        
        if(statusFld.getText() == "Add"){
            int idCount = part_inventory.getInventoryItems().size() + 1;
            idFld.setText(String.valueOf(idCount));
        }else{
            nameFld.setText(receivedPart.getName());
            invFld.setText(String.valueOf(receivedPart.getStock()));
            minFld.setText(String.valueOf(receivedPart.getMin()));
            maxFld.setText(String.valueOf(receivedPart.getMax()));
            priceFld.setText(String.valueOf(receivedPart.getPrice()));
            idFld.setText(String.valueOf(receivedPart.getId()));
        }
    }

    public void handleCloseButtonAction(ActionEvent event) {
        Stage stage = (Stage) cancelBtn.getScene().getWindow();
        stage.close();
    }

    public void setMode(String mode){
        statusFld.setText(mode);
    }

    public void saveModifyData() throws IOException, InterruptedException{
            System.out.println("modifying data...");

        try{
            // set updated values to the object
            receivedPart.setStock(Integer.parseInt(invFld.getText()));
            receivedPart.setName(nameFld.getText());
            receivedPart.setMax(Integer.parseInt(maxFld.getText()));
            receivedPart.setMin(Integer.parseInt(minFld.getText()));
            receivedPart.setPrice(Double.parseDouble(priceFld.getText()));

            Alert confirm = new Alert(Alert.AlertType.CONFIRMATION);
            confirm.setTitle("New Part Created...");
            confirm.setContentText("Your part has been updated...");
            confirm.showAndWait();

            // update selected object
            part_inventory.updateParts(receivedIndex, receivedPart);
        }
        catch(NumberFormatException e){

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("An Error has occured...");
            alert.setContentText(e + " is not an acceptable value for the text field. Please update the value and try again.");
            alert.showAndWait();
        }


    }

    
}
