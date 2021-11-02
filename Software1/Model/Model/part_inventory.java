package Software1.Model.Model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class part_inventory {
    private static ObservableList<Part> the_inventory = FXCollections.observableArrayList();

    public static void addInventoryItems(Part parts){
        the_inventory.add(parts);
    }

    public static ObservableList<Part> getInventoryItems(){
        return the_inventory;
    }
}
