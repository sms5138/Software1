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

    public static Part lookupPart(int partID){
        ObservableList<Part> allParts = Inventory.getAllParts();

        for(Part partToCheck : allParts){
            System.out.println("searching object " + partToCheck.getId() + "...");
            if(partToCheck.getId() == partID){
                return partToCheck;
            }
        }

        return null;

    }

    public static ObservableList<Part> lookupPart(String partialName){
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

    public static void addProduct(Product productToAdd){
        AllProducts.add(productToAdd);
    }

    public static ObservableList<Product> getAllProducts(){
        return AllProducts;
    }

    public static ObservableList<Product> getCurrentProduct(int index){
        AllProducts.get(index);
        return AllProducts;
    }
}
