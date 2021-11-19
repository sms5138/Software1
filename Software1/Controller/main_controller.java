package Software1.Controller;

import java.io.IOException;

import Software1.Model.Part;
import Software1.Model.Product;
import Software1.Model.part_inhouse;
import Software1.Model.part_inventory;
import Software1.Model.part_outsource;
import Software1.Model.product_inhouse;
import Software1.Model.product_inventory;
import Software1.Model.product_outsource;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class main_controller {

    public Button partsAdd;
    public Button partsModify;
    public Button partsDelete;
    public Button productAdd;
    public Button productModify;
    public Button mainFormExit;
    public Button TestButton;
    public Label statusFld;

    @FXML
    private TableView<Part> partsTable;
    
    @FXML
    private TableColumn<Part, Integer> partIDCol;

    @FXML
    private TableColumn<Part, String> partNameCol;

    @FXML
    private TableColumn<Part, Double> partInventoryCol;

    @FXML
    private TableColumn<Part, Integer> partPriceCol;

    @FXML
    private TableView<Product> productsTable;

    @FXML
    private TableColumn<Product, Integer> productIDCol;

    @FXML
    private TableColumn<Product, String> productNameCol;

    @FXML
    private TableColumn<Product, Integer> productInventoryCol;

    @FXML
    private TableColumn<Product, Double> productPriceCol;

    @FXML
    private void initialize() throws IOException {
        part_inhouse test0 = new part_inhouse(1, "testInhousePart", 1.50, 100, 5, 10, 2);
        part_inventory.addInventoryItems(test0);
        
        part_outsource test1 = new part_outsource(2, "testOutsourcePart", 2.50, 50, 7, 14, "3rdPartyPartName");
        part_inventory.addInventoryItems(test1);

        partsTable.setItems(part_inventory.getInventoryItems());

        partIDCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        partNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        partInventoryCol.setCellValueFactory(new PropertyValueFactory<>("stock"));
        partPriceCol.setCellValueFactory(new PropertyValueFactory<>("price"));

        product_inhouse test2 = new product_inhouse(1, "testInhouseProduct", 3.5, 150, 2, 20, 62);
        product_inventory.addInventoryItems(test2);

        product_outsource test3 = new product_outsource(2, "testOutsourceProduct", 4.5, 200, 50, 100, "3rdPartyProductName");
        product_inventory.addInventoryItems(test3);

        productsTable.setItems(product_inventory.getInventoryItems());

        productIDCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        productNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        productInventoryCol.setCellValueFactory(new PropertyValueFactory<>("stock"));
        productPriceCol.setCellValueFactory(new PropertyValueFactory<>("price"));
    }

    public void addPartsClick() throws IOException{
        // Pass the click type to the `parts.fxml`
        String mode = "Add";

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../FXML/parts.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        parts_controller controller = fxmlLoader.<parts_controller>getController();
        controller.setMode(mode);
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setScene(new Scene(root1));
        stage.setResizable(false);  
        stage.show();
    }

    public void modifyPartsClick() throws IOException{

        // passing object test
        
        // // Define the manipulation mode for the Parts UI when it's loaded
        String mode = "Modify";
        
        // // Determine if there is a selected row, and return error if there is not.
        if (partsTable.getSelectionModel().getSelectedItem() != null) {
            
            // Pass the data
            Part selectedPart = partsTable.getSelectionModel().getSelectedItem();
            parts_controller.ReceiveIncomingData(selectedPart);

            // Load Parts UI
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../FXML/parts.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            parts_controller controller = fxmlLoader.<parts_controller>getController();
            controller.setMode(mode);
            
            // Integer modID = selectedPart.getId();
            // String modName = selectedPart.getName();
            // Integer modInv = selectedPart.getStock();
            // Double modPrice = selectedPart.getPrice();
            // Integer modMin = selectedPart.getMin();
            // Integer modMax = selectedPart.getMax();

            //controller.setModifyData(modID, modName, modInv, modPrice, modMin, modMax);
            
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.initStyle(StageStyle.UNDECORATED);
            stage.setScene(new Scene(root1));  
            stage.setResizable(false);  
            stage.show();

        }else{
            System.out.println("you must select a part to modify...");

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../FXML/prompt.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            
            prompt_controller controller = fxmlLoader.<prompt_controller>getController();
            controller.setStatus("No Part Selected", "You must select a part that you want to modify...");
            
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.initStyle(StageStyle.UNDECORATED);
            stage.setScene(new Scene(root1)); 
            stage.setResizable(false);   
            stage.show();

        }
    }

    public void addProductsClick() throws IOException{
        String mode = "Add";

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../FXML/products.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        products_controller controller = fxmlLoader.<products_controller>getController();
        controller.setMode(mode);
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setTitle("Add Parts");
        stage.setScene(new Scene(root1));  
        stage.setResizable(false);  
        stage.show();
    }

    public void modifyProductsClick() throws IOException{
        String mode = "Modify";
        
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../FXML/products.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        
        // Populate elements of new UI before `show`
        products_controller controller = fxmlLoader.<products_controller>getController();
        controller.setMode(mode);
        
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setTitle("Modify Parts");
        stage.setScene(new Scene(root1));
        stage.setResizable(false);    
        stage.show();
    }

    public void mainFormExit(){
        final Stage stage = (Stage) mainFormExit.getScene().getWindow();
        stage.close();
    }

    public void deletePart(){
        if (partsTable.getSelectionModel().getSelectedItem() != null) {
            Part selectedPart = partsTable.getSelectionModel().getSelectedItem();
            partsTable.getItems().removeAll(selectedPart);
        }
    }

    public void TestFunctionality(){
        System.out.println("reload table...");
        productsTable.setItems(product_inventory.getInventoryItems());

        productIDCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        productNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        productInventoryCol.setCellValueFactory(new PropertyValueFactory<>("stock"));
        productPriceCol.setCellValueFactory(new PropertyValueFactory<>("price"));
    }

}
