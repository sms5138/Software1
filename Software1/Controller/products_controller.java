package Software1.Controller;

import java.io.IOException;

import Software1.Model.Inventory;
import Software1.Model.Part;
import Software1.Model.Product;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class products_controller {
    public Button cancelBtn;
    public Button removeAssocPartBtn;
    public Button addAssocPartBtn;
    public Label statusFld;
    public TextField idFld;
    public TextField nameFld;
    public TextField invFld;
    public TextField priceFld;
    public TextField minFld;
    public TextField maxFld;
    public TextField machineIDFld;
    public static Product receivedProduct = null;
    public static ObservableList<Part> receivedParts;
    ObservableList<Part> assocaitedParts = FXCollections.observableArrayList();

    public static int receivedIndex;

    @FXML
    private TableColumn<Part, Integer> partIDCol;

    @FXML
    private TableColumn<Part, String> partNameCol;

    @FXML
    private TableColumn<Part, Double> partInventoryCol;

    @FXML
    private TableColumn<Part, Integer> partPriceCol;

    @FXML
    private TableView<Part> listOfPartsTable;

    @FXML
    private TableColumn<Part, Integer> assocPartIDCol;

    @FXML
    private TableColumn<Part, String> assocPartNameCol;

    @FXML
    private TableColumn<Part, Double> assocPartIventoryCol;

    @FXML
    private TableColumn<Part, Integer> assocPartPriceCol;

    @FXML
    private TableView<Part> assocPartsTable;

    /**
     * This sets up the UI for the user to modify a product.
     * @throws IOException
     */
    @FXML
    private void initialize() throws IOException {


            nameFld.setText(receivedProduct.getName());
            invFld.setText(String.valueOf(receivedProduct.getStock()));
            minFld.setText(String.valueOf(receivedProduct.getMin()));
            maxFld.setText(String.valueOf(receivedProduct.getMax()));
            priceFld.setText(String.valueOf(receivedProduct.getPrice()));
            idFld.setText(String.valueOf(receivedProduct.getId()));

            

            ObservableList<Part> allParts = receivedParts;

            listOfPartsTable.setItems(allParts);
            partIDCol.setCellValueFactory(new PropertyValueFactory<>("id"));
            partNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
            partInventoryCol.setCellValueFactory(new PropertyValueFactory<>("stock"));
            partPriceCol.setCellValueFactory(new PropertyValueFactory<>("price"));

            
            assocaitedParts.addAll(receivedProduct.getAllAssociatedParts());

            assocPartsTable.setItems(assocaitedParts);
            assocPartIDCol.setCellValueFactory(new PropertyValueFactory<>("id"));
            assocPartNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
            assocPartIventoryCol.setCellValueFactory(new PropertyValueFactory<>("stock"));
            assocPartPriceCol.setCellValueFactory(new PropertyValueFactory<>("price"));

    }
    
    /**
     * This receives incoming part and product information.
     * @param passedProduct
     * @param passedIndex
     * @param passedParts
     */
    public static void ReceiveIncomingData(Product passedProduct, int passedIndex, ObservableList<Part> passedParts){
        receivedProduct = passedProduct;
        receivedIndex = passedIndex;
        receivedParts = passedParts;
    }

    /**
     * This closes the window and takes the user back to the main UI.
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
     * Adds the part to the product that is being modified.
     */
    public void addAssocPart(){

        if (listOfPartsTable.getSelectionModel().getSelectedItem() != null) {
            Part selectedPart = listOfPartsTable.getSelectionModel().getSelectedItem();
            assocaitedParts.add(selectedPart);
        }
    }

    /**
     * Removes the selected part from the product.
     */
    public void removeAssociatedPart(){
        if (assocPartsTable.getSelectionModel().getSelectedItem() != null) {
            Part selectedPart = assocPartsTable.getSelectionModel().getSelectedItem();
            assocaitedParts.remove(selectedPart);
        }
    }

    /**
     * This will allow the modified data to be saved.
     * @throws IOException
     * @throws InterruptedException
     */
    public void saveModifyData() throws IOException, InterruptedException{
        System.out.println("modifying data...");

    try{
        // set updated values to the object
        receivedProduct.setStock(Integer.parseInt(invFld.getText()));
        receivedProduct.setName(nameFld.getText());
        receivedProduct.setMax(Integer.parseInt(maxFld.getText()));
        receivedProduct.setMin(Integer.parseInt(minFld.getText()));
        receivedProduct.setPrice(Double.parseDouble(priceFld.getText()));
        receivedProduct.getAllAssociatedParts().setAll(assocaitedParts);


        Alert confirm = new Alert(Alert.AlertType.CONFIRMATION);
        confirm.setTitle("New Part Created...");
        confirm.setContentText("Your part has been updated...");
        confirm.showAndWait();

        // update selected object
        Inventory.updateProduct(receivedIndex, receivedProduct);
    }
    catch(NumberFormatException e){

        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("An Error has occured...");
        alert.setContentText(e + " is not an acceptable value for the text field. Please update the value and try again.");
        alert.showAndWait();
    }
}
}