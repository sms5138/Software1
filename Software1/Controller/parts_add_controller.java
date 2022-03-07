package Software1.Controller;

import java.io.IOException;
import java.util.Date;

import Software1.Model.part_inhouse;
import Software1.Model.Inventory;
import Software1.Model.part_outsource;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

public class parts_add_controller {
    public Button cancelBtn;
    public Button saveBtn;
    public Label statusFld;
    public Label  inhouseOutsourceLbl;
    public TextField idFld;
    public TextField nameFld;
    public TextField invFld;
    public TextField priceFld;
    public TextField minFld;
    public TextField maxFld;
    public TextField machineIDFld;
    public RadioButton inhouseRadio;
    public RadioButton outsourceRadio;


    /**
     * This sets up the radio button groups and captures the time stamp. 
     * It converts the timestampt to an int which will be used as the id when the part is created.
     * @throws IOException
     */
    @FXML
    private void initialize() throws IOException {
        // Create group for toggle buttons
        ToggleGroup group = new ToggleGroup();
        inhouseRadio.setToggleGroup(group);
        inhouseRadio.setSelected(true);
        outsourceRadio.setToggleGroup(group);

        int idCount = (int) (new Date().getTime()/1000);
        idFld.setText(String.valueOf(idCount));

    }

    /**
     * This closes the Parts Add window.
     * @param event
     */
    public void handleCloseButtonAction(ActionEvent event) {
        Stage stage = (Stage) cancelBtn.getScene().getWindow();
        stage.close();
    }

    /**
     * This sets the mode of the GUI to Add, which would be planned for future development, and lets the user know what function they are currently working on.
     * @param mode
     */
    public void setMode(String mode){
        statusFld.setText(mode);
    }

    /**
     * This sets the machineIDFld UI element text to either 'Machine ID' or 'Company Name:' depending on if inhouse or outsource is used.
     */
    public void checkInhouseOutsource(){
        if(inhouseRadio.isSelected()){
            inhouseOutsourceLbl.setText("Machine ID:");
            inhouseOutsourceLbl.setLayoutX(162);
            machineIDFld.setPromptText("Machine ID");

        }else{
            inhouseOutsourceLbl.setText("Company Name:");
            inhouseOutsourceLbl.setLayoutX(130);
            machineIDFld.setPromptText("Company Name");
        }
    }

    /**
     * This saves the data once the information is completely filled out.
     * @param event
     * @throws IOException
     * @throws InterruptedException
     */
    public void saveModifyData(ActionEvent event) throws IOException, InterruptedException{

            System.out.println("adding new part");
            

            if(inhouseRadio.isSelected()){
                try{
                    System.out.println("inhouse part being added."); 
                    part_inhouse PartToAdd = new part_inhouse(Integer.parseInt(idFld.getText()), nameFld.getText(), Double.parseDouble(priceFld.getText()), Integer.parseInt(invFld.getText()), Integer.parseInt(minFld.getText()), Integer.parseInt(maxFld.getText()), Integer.parseInt(machineIDFld.getText()));
                    Inventory.addPart(PartToAdd);

                    Alert confirm = new Alert(Alert.AlertType.CONFIRMATION);
                    confirm.setTitle("New Part Created...");
                    confirm.setContentText("Your new Inhouse Part has been created...");
                    confirm.showAndWait();

                    Stage stage = (Stage) saveBtn.getScene().getWindow();
                    stage.close();
                }
                catch(NumberFormatException e){

                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("An Error has occured...");
                    alert.setContentText("Please enter a valid value for each text field...");
                    alert.showAndWait();
                    // Stage stage = (Stage) saveBtn.getScene().getWindow();
                    // stage.close();
                }

            }else{
                try{
                    System.out.println("outsource part being added.");
                    part_outsource PartToAdd = new part_outsource(Integer.parseInt(idFld.getText()), nameFld.getText(), Double.valueOf(priceFld.getText()), Integer.parseInt(invFld.getText()), Integer.parseInt(minFld.getText()), Integer.parseInt(maxFld.getText()), nameFld.getText());
                    Inventory.addPart(PartToAdd);
    
                    Alert confirm = new Alert(Alert.AlertType.CONFIRMATION);
                    confirm.setTitle("New Part Created...");
                    confirm.setContentText("Your new Outsourced Part has been created...");
                    confirm.showAndWait();
    
                    Stage stage = (Stage) saveBtn.getScene().getWindow();
                    stage.close();
                }
                catch(NumberFormatException e){

                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("An Error has occured...");
                    alert.setContentText("Please enter a valid value for " + e + " each text field...");
                    alert.showAndWait();
                    // Stage stage = (Stage) saveBtn.getScene().getWindow();
                    // stage.close();
                }

            }
    }
}
