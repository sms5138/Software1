package Software1.Model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class product_inventory {
    private static ObservableList<Product> the_inventory = FXCollections.observableArrayList();

    public static void addInventoryItems(Product products){
        the_inventory.add(products);
    }

    public static ObservableList<Product> getInventoryItems(){
        return the_inventory;
    }
}
