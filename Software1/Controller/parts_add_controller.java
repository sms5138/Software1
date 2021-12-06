package Software1.Controller;

import java.io.IOException;

import Software1.Model.part_inhouse;
import Software1.Model.part_inventory;
import Software1.Model.part_outsource;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class parts_add_controller {
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



    @FXML
    private void initialize() throws IOException {
        // Create group for toggle buttons
        ToggleGroup group = new ToggleGroup();
        inhouseRadio.setToggleGroup(group);
        outsourceRadio.setSelected(true);
        outsourceRadio.setToggleGroup(group);

        int idCount = part_inventory.getInventoryItems().size() + 1;
        idFld.setText(String.valueOf(idCount));

    }

    public void handleCloseButtonAction(ActionEvent event) {
        Stage stage = (Stage) cancelBtn.getScene().getWindow();
        stage.close();
    }

    public void setMode(String mode){
        statusFld.setText(mode);
    }

    public void saveModifyData() throws IOException, InterruptedException{

            System.out.println("adding new part");

            int idCount = part_inventory.getNumberOfItems() + 1;


            if(inhouseRadio.isSelected()){
                System.out.println("inhouse part being added."); 
                part_inhouse PartToAdd = new part_inhouse(idCount, nameFld.getText(), Double.parseDouble(priceFld.getText()), Integer.parseInt(invFld.getText()), Integer.parseInt(minFld.getText()), Integer.parseInt(maxFld.getText()), 2);
                part_inventory.addPart(PartToAdd);
            }else{
                System.out.println("outsource part being added.");
                part_outsource PartToAdd = new part_outsource(idCount, nameFld.getText(), Double.valueOf(priceFld.getText()), Integer.parseInt(invFld.getText()), Integer.parseInt(minFld.getText()), Integer.parseInt(maxFld.getText()), nameFld.getText());
                part_inventory.addPart(PartToAdd);
            }
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../FXML/prompt.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            
            prompt_controller controller = fxmlLoader.<prompt_controller>getController();
            controller.setStatus("Part Added", "Your part has been added.");
            
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.initStyle(StageStyle.UNDECORATED);
            stage.setScene(new Scene(root1)); 
            stage.setResizable(false);   
            stage.show();

        
    }

    
}
