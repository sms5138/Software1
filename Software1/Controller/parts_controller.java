package Software1.Controller;

import java.io.IOException;

import Software1.Model.Part;
import Software1.Model.part_inhouse;
import Software1.Model.part_outsource;
import Software1.Model.Inventory;
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

    /**
     * This receives parts information being passed from the main UI
     * @param passedPart
     * @param passedIndex
     */
    public static void ReceiveIncomingData(Part passedPart, int passedIndex){
        receivedPart = passedPart;
        receivedIndex = passedIndex;
    }

    /**
     * This sets up the UI for the user so they can modify the data.
     * @throws IOException
     */
    @FXML
    private void initialize() throws IOException {

        // determine if the part is an inhouse or outsourced part by getting class name as string
        String className = receivedPart.getClass().getSimpleName();
        System.out.println("receivedPart_className = " + className);
        
        // set string to be compared with as 'part_outsource', and create comparisonResult that will return 'true' or 'false'
        String compareClass = "part_outsource";

        boolean comparisonResult = className.equals(compareClass);
        System.out.println("comparisonResult = " + comparisonResult);

        // Create group for toggle buttons
        ToggleGroup group = new ToggleGroup();
        inhouseRadio.setToggleGroup(group);
        outsourceRadio.setToggleGroup(group);


        if(receivedPart instanceof part_outsource){
            
            String company_name = ((part_outsource)receivedPart).getComapnyName();
            System.out.println("company name: " + company_name);
            machineIDFld.setText(company_name);
        }else{
            int machine_id = ((part_inhouse)receivedPart).getMachineID();
            System.out.println("company name: " + String.valueOf(machine_id));
            machineIDFld.setText(String.valueOf(machine_id));

        }

        // compare the comparisonResult to 'true', and determine inhouse vs. outsource based on this comparison.
        // Then get the correct data, and update the RadioButton to match the type of part.
        if(comparisonResult == true){
            System.out.println("UI will be set to Outsourced, and the receivedPart_className = " + className);
            outsourceRadio.setSelected(true);
            // machineIDFld.setText(String.valueOf(receivedPart.getCompanyname()));
        }else{
            System.out.println("UI will be set to Inhouse, and the receivedPart_className = " + className);
            inhouseRadio.setSelected(true);
            // machineIDFld.setText(String.valueOf(receivedPart.getMachineID()));
        }


        nameFld.setText(receivedPart.getName());
        invFld.setText(String.valueOf(receivedPart.getStock()));
        minFld.setText(String.valueOf(receivedPart.getMin()));
        maxFld.setText(String.valueOf(receivedPart.getMax()));
        priceFld.setText(String.valueOf(receivedPart.getPrice()));
        idFld.setText(String.valueOf(receivedPart.getId()));
    }

    /**
     * This closes the UI and goes back to the main UI.
     * @param event
     */
    public void handleCloseButtonAction(ActionEvent event) {
        Stage stage = (Stage) cancelBtn.getScene().getWindow();
        stage.close();
    }

    /**
     * This closes the Parts modify window.
     * @param mode
     */
    public void setMode(String mode){
        statusFld.setText(mode);
    }

    /**
     * This saves the modified data.
     * @throws IOException
     * @throws InterruptedException
     */
    public void saveModifyData() throws IOException, InterruptedException{
            System.out.println("modifying data...");

        try{
            // set updated values to the object
            receivedPart.setStock(Integer.parseInt(invFld.getText()));
            receivedPart.setName(nameFld.getText());
            receivedPart.setMax(Integer.parseInt(maxFld.getText()));
            receivedPart.setMin(Integer.parseInt(minFld.getText()));
            receivedPart.setPrice(Double.parseDouble(priceFld.getText()));

            // determine if the part is an inhouse or outsourced part by getting class name as string
            String className = receivedPart.getClass().getSimpleName();
            System.out.println("receivedPart_className = " + className);
            
            // set string to be compared with as 'part_outsource', and create comparisonResult
            String compareClass = "part_outsource";

            boolean comparisonResult = className.equals(compareClass);
            System.out.println("comparisonResult = " + comparisonResult);


            if(receivedPart instanceof part_outsource){
                ((part_outsource)receivedPart).setCompanyName(machineIDFld.getText());
            }else{
                ((part_inhouse)receivedPart).setMachineID(Integer.parseInt(machineIDFld.getText()));
            }
    

            Alert confirm = new Alert(Alert.AlertType.CONFIRMATION);
            confirm.setTitle("New Part Created...");
            confirm.setContentText("Your part has been updated...");
            confirm.showAndWait();

            // update selected object
            Inventory.updateParts(receivedIndex, receivedPart);

            Stage stage = (Stage) saveBtn.getScene().getWindow();
            stage.close();
        }
        catch(NumberFormatException e){

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("An Error has occured...");
            alert.setContentText(e + " is not an acceptable value for the text field. Please update the value and try again.");
            alert.showAndWait();
            // Stage stage = (Stage) saveBtn.getScene().getWindow();
            // stage.close();
        }
    }
}