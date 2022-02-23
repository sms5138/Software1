package Software1.Controller;

import java.io.IOException;
import java.util.Date;

//import Software1.Main;
import Software1.Model.Part;
import Software1.Model.Product;
import Software1.Model.part_inhouse;
import Software1.Model.Inventory;
import Software1.Model.part_outsource;
import Software1.Model.product_inhouse;
import Software1.Model.product_inventory;
import Software1.Model.product_outsource;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
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
    public Button partSearchBtn;
    public Label statusFld;
    public TextField partSearchFld;
    public TextField prodSearchFld;
    public Button prodSearchBtn;

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
        int timeInt = (int) (new Date().getTime()/1000);
        String testDataName = "testInhousePart";
        int id_number = timeInt + testDataName.length();
        part_inhouse test0 = new part_inhouse(timeInt, "testInhousePart", 1.50, 100, 5, 10, 2);
        Inventory.addPart(test0);

        timeInt = (int) (new Date().getTime()/1000);
        testDataName = "testOutsourcePart";
        id_number = timeInt + testDataName.length();
        part_outsource test1 = new part_outsource(id_number, "testOutsourcePart", 2.50, 50, 7, 14, "3rdPartyPartName");
        Inventory.addPart(test1);

        partsTable.setItems(Inventory.getAllParts());

        partIDCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        partNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        partInventoryCol.setCellValueFactory(new PropertyValueFactory<>("stock"));
        partPriceCol.setCellValueFactory(new PropertyValueFactory<>("price"));

        timeInt = (int) (new Date().getTime()/1000);
        testDataName = "testInhouseProduct";
        id_number = timeInt + testDataName.length();
        product_inhouse test2 = new product_inhouse(id_number, "testInhouseProduct", 3.5, 150, 2, 20, 62);
        test2.addAssociatedParts();
        product_inventory.addInventoryItems(test2);

        timeInt = (int) (new Date().getTime()/1000);
        testDataName = "testOutsourceProduct";
        id_number = timeInt + testDataName.length();
        product_outsource test3 = new product_outsource(id_number, "testOutsourceProduct", 4.5, 200, 50, 100, "3rdPartyProductName");
        test2.addAssociatedParts();
        product_inventory.addInventoryItems(test3);

        productsTable.setItems(product_inventory.getAllParts());

        productIDCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        productNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        productInventoryCol.setCellValueFactory(new PropertyValueFactory<>("stock"));
        productPriceCol.setCellValueFactory(new PropertyValueFactory<>("price"));
    }

    public void addPartsClick() throws IOException{
        // Pass the click type to the `parts.fxml`
        String mode = "Add";

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../FXML/parts_add.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        parts_add_controller controller = fxmlLoader.<parts_add_controller>getController();
        controller.setMode(mode);
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setScene(new Scene(root1));
        stage.setResizable(false);  
        stage.show();
    }

    public void modifyPartsClick() throws IOException{

        String mode = "Modify";
        
        // Determine if there is a selected row, and return error if there is not.
        if (partsTable.getSelectionModel().getSelectedItem() != null) {
            
            // Pass the data
            Part selectedPart = partsTable.getSelectionModel().getSelectedItem();
            int selectedIndex = partsTable.getSelectionModel().getSelectedIndex();
            parts_controller.ReceiveIncomingData(selectedPart, selectedIndex);

            // Load Parts UI
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

        }else{
            System.out.println("you must select a part to modify...");

            Alert warn = new Alert(Alert.AlertType.WARNING);
            warn.setTitle("Please select an item to modify...");
            warn.setContentText("No item to has been selected to modify...");
            warn.showAndWait();

        }
    }

    public void addProductsClick() throws IOException{
        // Pass the click type to the `parts.fxml`
        String mode = "Add";

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../FXML/products_add.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        products_add_controller controller = fxmlLoader.<products_add_controller>getController();
        controller.setMode(mode);
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setScene(new Scene(root1));
        stage.setResizable(false);  
        stage.show();
    }

    public void modifyProductsClick() throws IOException{
        String mode = "Modify";
        
        // Determine if there is a selected row, and return error if there is not.
        if (productsTable.getSelectionModel().getSelectedItem() != null) {
            
            // Pass the data
            Product selectedPart = productsTable.getSelectionModel().getSelectedItem();
            int selectedIndex = productsTable.getSelectionModel().getSelectedIndex();
            // ObservableList<Part> PartsTableData = part_inventory.getAllParts();
            products_controller.ReceiveIncomingData(selectedPart, selectedIndex, Inventory.getAllParts());
            

            // Load Parts UI
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../FXML/products.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            products_controller controller = fxmlLoader.<products_controller>getController();
            controller.setMode(mode);
            
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.initStyle(StageStyle.UNDECORATED);
            stage.setScene(new Scene(root1));  
            stage.setResizable(false);  
            stage.show();

        }else{
            System.out.println("you must select a Product to modify...");

            Alert warn = new Alert(Alert.AlertType.WARNING);
            warn.setTitle("Please select an item to modify...");
            warn.setContentText("No item to has been selected to modify...");
            warn.showAndWait();

        }
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

    public void deleteProd(){
        if (productsTable.getSelectionModel().getSelectedItem() != null) {
            Product selectedPart = productsTable.getSelectionModel().getSelectedItem();
            productsTable.getItems().removeAll(selectedPart);
        }
    }


    private ObservableList<Part> searchByPartName(String partialName){
        ObservableList<Part> namedPart = FXCollections.observableArrayList();

        ObservableList<Part> allParts = Inventory.getAllParts();

        for(Part partToCheck : allParts){
            System.out.println("searching object " + partToCheck.getId() + "...");
            if(partToCheck.getName().contains(partialName)){
                namedPart.add(partToCheck);
            }
        }


        return namedPart;
    }


    private Part getPartById(int partID){
        ObservableList<Part> allParts = Inventory.getAllParts();

        // for(int i = 0; i < allParts.size(); i++){

        // }

        for(Part partToCheck : allParts){
            System.out.println("searching object " + partToCheck.getId() + "...");
            if(partToCheck.getId() == partID){
                return partToCheck;
            }
        }

        return null;
    }

    public void partSearch(ActionEvent actionEvent){
        String search = partSearchFld.getText();

        ObservableList<Part> partsSearch = searchByPartName(search);

        if(partsSearch.size() == 0){
            try{
                int part_id = Integer.parseInt(search);

                Part searchedByID = getPartById(part_id);
    
                if(searchedByID != null){
                    partsSearch.add(searchedByID);
                }
            }
            catch(NumberFormatException e){
                // ignore...
            }

        }

        partsTable.setItems(partsSearch);
        partSearchFld.setText("");

    }




    private ObservableList<Product> searchByProdName(String partialName){
        ObservableList<Product> namedPart = FXCollections.observableArrayList();

        ObservableList<Product> allParts = product_inventory.getAllParts();

        for(Product partToCheck : allParts){
            System.out.println("searching object " + partToCheck.getId() + "...");
            if(partToCheck.getName().contains(partialName)){
                namedPart.add(partToCheck);
            }
        }


        return namedPart;
    }

    private Product getProdById(int prodID){
        ObservableList<Product> allProds = product_inventory.getAllParts();

        // for(int i = 0; i < allParts.size(); i++){

        // }

        for(Product partToCheck : allProds){
            System.out.println("searching object " + partToCheck.getId() + "...");
            if(partToCheck.getId() == prodID){
                return partToCheck;
            }
        }

        return null;
    }

    public void prodSearch(ActionEvent actionEvent){
        String search = prodSearchFld.getText();

        ObservableList<Product> prodSearch = searchByProdName(search);

        if(prodSearch.size() == 0){
            try{
                int prod_id = Integer.parseInt(search);

                Product searchedByID = getProdById(prod_id);
    
                if(searchedByID != null){
                    prodSearch.add(searchedByID);
                }
            }
            catch(NumberFormatException e){
                // ignore...
            }

        }

        productsTable.setItems(prodSearch);
        prodSearchFld.setText("");

    }



}
