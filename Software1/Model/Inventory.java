package Software1.Model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Inventory {
    private static ObservableList<Part> AllParts = FXCollections.observableArrayList();
    private static int AllPartsIndex;

    private static ObservableList<Product> AllProducts = FXCollections.observableArrayList();

    public static void addPart(Part parts){
        AllParts.add(parts);
    }

    public static void addProduct(Product productToAdd){
        AllProducts.add(productToAdd);
    }

    public static int getInventoryIndex(){
        return AllPartsIndex;
    }

    public static ObservableList<Part> getAllParts(){
        return AllParts;
    }

    public static ObservableList<Part> getCurrentItem(int index){
        AllParts.get(index);
        return AllParts;
    }

    public static ObservableList<Part> removeParts(Part partToRemove){
        AllParts.remove(partToRemove);
        return AllParts;
    }

    public static ObservableList<Part> updateParts(int index, Part partToRemove){
        AllParts.set(index, partToRemove);
        return AllParts;
    }

    public static int getNumberOfItems(){
        Object[] inventory_array = AllParts.toArray();
        return inventory_array.length;

    }
}
