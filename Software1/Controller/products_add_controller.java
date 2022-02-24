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
// import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

public class products_add_controller {
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



    @FXML
    private void initialize() throws IOException {

        int idCount = (int) (new Date().getTime()/1000);
        idFld.setText(String.valueOf(idCount));

    }

    public void handleCloseButtonAction(ActionEvent event) {
        Stage stage = (Stage) cancelBtn.getScene().getWindow();
        stage.close();
    }

    public void setMode(String mode){
        statusFld.setText(mode);
    }


    // public void checkInhouseOutsource(){
    //     if(inhouseRadio.isSelected()){
    //         inhouseOutsourceLbl.setText("Machine ID:");
    //         inhouseOutsourceLbl.setLayoutX(162);
    //         machineIDFld.setPromptText("Machine ID");

    //     }else{
    //         inhouseOutsourceLbl.setText("Company Name:");
    //         inhouseOutsourceLbl.setLayoutX(130);
    //         machineIDFld.setPromptText("Company Name");
    //     }
    // }

    public void saveModifyData(ActionEvent event) throws IOException, InterruptedException{

            System.out.println("adding new part");
            

            if(inhouseRadio.isSelected()){
                try{
                    System.out.println("inhouse part being added."); 
                    part_inhouse PartToAdd = new part_inhouse(Integer.parseInt(idFld.getText()), nameFld.getText(), Double.parseDouble(priceFld.getText()), Integer.parseInt(invFld.getText()), Integer.parseInt(minFld.getText()), Integer.parseInt(maxFld.getText()), 2);
                    Inventory.addPart(PartToAdd);

                    Alert confirm = new Alert(Alert.AlertType.CONFIRMATION);
                    confirm.setTitle("New Part Created...");
                    confirm.setContentText("Your new Inhouse Part has been created...");
                    confirm.showAndWait();

                    int idCount = (int) (new Date().getTime()/1000);
                    idFld.setText(String.valueOf(idCount));
                }
                catch(NumberFormatException e){

                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("An Error has occured...");
                    alert.setContentText("Please enter a valid value for each text field...");
                    alert.showAndWait();
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
    
                    int idCount = (int) (new Date().getTime()/1000);
                    idFld.setText(String.valueOf(idCount));
                }
                catch(NumberFormatException e){

                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("An Error has occured...");
                    alert.setContentText("Please enter a valid value for " + e + " each text field...");
                    alert.showAndWait();
                }

            }
            // FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../FXML/prompt.fxml"));
            // Parent root1 = (Parent) fxmlLoader.load();
            
            // prompt_controller controller = fxmlLoader.<prompt_controller>getController();
            // controller.setStatus("Part Added", "Your part has been added.");
            
            // Stage stage = new Stage();
            // stage.initModality(Modality.APPLICATION_MODAL);
            // stage.initStyle(StageStyle.UNDECORATED);
            // stage.setScene(new Scene(root1)); 
            // stage.setResizable(false);   
            // stage.show();
            
            // int idCount = (int) (new Date().getTime()/1000);
            // idFld.setText(String.valueOf(idCount));

            // Stage stageCurrent = (Stage) saveBtn.getScene().getWindow();
            // stageCurrent.close();
        
    }

    
}
