package Software1.Controller;

import java.io.IOException;

import Software1.Model.Part;
import Software1.Model.Product;
// import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
// import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class products_controller {
    public Button cancelBtn;
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

            ObservableList<Part> assocaitedParts = receivedProduct.getAllAssociatedParts();
            assocPartsTable.setItems(assocaitedParts);
            assocPartIDCol.setCellValueFactory(new PropertyValueFactory<>("id"));
            assocPartNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
            assocPartIventoryCol.setCellValueFactory(new PropertyValueFactory<>("stock"));
            assocPartPriceCol.setCellValueFactory(new PropertyValueFactory<>("price"));

    }
    
    public static void ReceiveIncomingData(Product passedProduct, int passedIndex, ObservableList<Part> passedParts){
        receivedProduct = passedProduct;
        receivedIndex = passedIndex;
        receivedParts = passedParts;
    }

    public void handleCloseButtonAction(ActionEvent event) {
        Stage stage = (Stage) cancelBtn.getScene().getWindow();
        stage.close();
    }

    public void setMode(String mode){
        statusFld.setText(mode);
    }

}