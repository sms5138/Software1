package Software1.Model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class product_inventory {
    private static ObservableList<Product> AllParts = FXCollections.observableArrayList();

    public static void addInventoryItems(Product products){
        AllParts.add(products);
    }

    public static ObservableList<Product> getAllParts(){
        return AllParts;
    }

    public static ObservableList<Product> getCurrentItem(int index){
        AllParts.get(index);
        return AllParts;
    }
}
