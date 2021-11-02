package Software1;

import java.io.FileWriter;
import java.io.IOException;

import Software1.Model.Model.part_inhouse;
import Software1.Model.Model.part_inventory;
import Software1.Model.Model.part_outsource;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Controller_main {

    public Button partsAdd;
    public Button partsModify;
    public Button productAdd;
    public Button productModify;
    public Button mainFormExit;
    public Label statusFld;

    @FXML
    private void initialize() throws IOException {
        part_inhouse test0 = new part_inhouse(1, "testInhousePart", 1.50, 100, 5, 10, 2);
        part_inventory.addInventoryItems(test0);
        
        part_outsource test1 = new part_outsource(2, "testOutsourcePart", 2.50, 50, 7, 14, "JDPart");
        part_inventory.addInventoryItems(test1);


    }

    public void addPartsClick() throws IOException{
        FileWriter myWriter = new FileWriter("./Software1/state");
        myWriter.write("Add");
        myWriter.close();

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Form_parts.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        // System.out.print(stage);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setTitle("Add Parts");
        stage.setScene(new Scene(root1));  
        stage.show();
    }

    public void modifyPartsClick() throws IOException{
        FileWriter myWriter = new FileWriter("./Software1/state");
        myWriter.write("Modify");
        myWriter.close();

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Form_parts.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        // System.out.print(stage);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setTitle("Add Parts");
        stage.setScene(new Scene(root1));  
        stage.show();
    }

    public void addProductsClick() throws IOException{
        FileWriter myWriter = new FileWriter("./Software1/state");
        myWriter.write("Add");
        myWriter.close();

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Form_products.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        // System.out.print(stage);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setTitle("Add Parts");
        stage.setScene(new Scene(root1));  
        stage.show();
    }

    public void modifyProductsClick() throws IOException{
        FileWriter myWriter = new FileWriter("./Software1/state");
        myWriter.write("Modify");
        myWriter.close();
        
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Form_products.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        // System.out.print(stage);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setTitle("Modify Parts");
        stage.setScene(new Scene(root1));  
        stage.show();
    }

    public void mainFormExit(){
        final Stage stage = (Stage) mainFormExit.getScene().getWindow();
        stage.close();
    }

}
