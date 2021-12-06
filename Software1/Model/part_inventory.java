package Software1.Model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class part_inventory {
    private static ObservableList<Part> the_inventory = FXCollections.observableArrayList();
    private static int inventory_index;

    public static void addPart(Part parts){
        the_inventory.add(parts);

        
    }

    public static int getInventoryIndex(){
        return inventory_index;
    }

    public static ObservableList<Part> getInventoryItems(){
        return the_inventory;
    }

    public static ObservableList<Part> getCurrentItem(int index){
        the_inventory.get(index);
        return the_inventory;
    }

    public static ObservableList<Part> removeParts(Part partToRemove){
        the_inventory.remove(partToRemove);
        return the_inventory;
    }

    public static ObservableList<Part> updateParts(int index, Part partToRemove){
        the_inventory.set(index, partToRemove);
        return the_inventory;
    }

    public static int getNumberOfItems(){
        Object[] inventory_array = the_inventory.toArray();
        return inventory_array.length;

    }
}
