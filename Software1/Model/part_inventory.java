package Software1.Model;

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

    public static ObservableList<Part> getCurrentItem(int index){
        the_inventory.get(index);
        return the_inventory;
    }
}
