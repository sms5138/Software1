package Software1.Controller;

import java.io.IOException;

// import Software1.Model.Part;
import Software1.Model.part_inventory;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
// import javafx.scene.control.ListView;
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



    @FXML
    private void initialize() throws IOException {
        ToggleGroup group = new ToggleGroup();
        inhouseRadio.setToggleGroup(group);
        outsourceRadio.setSelected(true);
        outsourceRadio.setToggleGroup(group);
    }

    public void handleCloseButtonAction(ActionEvent event) {
        Stage stage = (Stage) cancelBtn.getScene().getWindow();
        stage.close();
    }

    public void setMode(String mode){
        statusFld.setText(mode);
    }

    public void setModifyData(Integer id, String name, Integer inv, Double price, Integer min, Integer max){
        idFld.setText(String.valueOf(id));
        nameFld.setText(name);
        invFld.setText(String.valueOf(inv));
        priceFld.setText(String.valueOf(price));
        minFld.setText(String.valueOf(min));
        maxFld.setText(String.valueOf(max));
    }

    public void saveModifyData(){
        System.out.println(part_inventory.getCurrentItem(0));
        if(statusFld.getText() == "Add"){
            System.out.println("adding new part");
            if(inhouseRadio.isSelected()){
                System.out.println("inhouse part being added.");
            }else{
                System.out.println("outsource part being added.");
            }
        }else{
            System.out.println("modifying existing part");

        } 
    }
}
