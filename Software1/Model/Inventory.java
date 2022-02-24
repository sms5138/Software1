package Software1.Model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Inventory {

    /**
     * This contains all the parts in the application.
     */
    private static ObservableList<Part> AllParts = FXCollections.observableArrayList();
    
    /**
     * This contains all the products in the application.
     */
    private static ObservableList<Product> AllProducts = FXCollections.observableArrayList();

    /**
     * add a part to the inventory.
     * @param parts
     */
    public static void addPart(Part parts){
        AllParts.add(parts);
    }

    /**
     * This provides all the parts in the inventory.
     * @return
     */
    public static ObservableList<Part> getAllParts(){
        return AllParts;
    }

    /**
     * This returns the part based on its index.
     * @param index
     * @return
     */
    public static ObservableList<Part> getCurrentItem(int index){
        AllParts.get(index);
        return AllParts;
    }

    /**
     * This removes the part from the inventory.
     * @param partToRemove
     * @return
     */
    public static ObservableList<Part> removeParts(Part partToRemove){
        AllParts.remove(partToRemove);
        return AllParts;
    }

    /**
     * This updates the parts
     * @param index
     * @param partToRemove
     * @return
     */
    public static ObservableList<Part> updateParts(int index, Part partToRemove){
        AllParts.set(index, partToRemove);
        return AllParts;
    }

    /**
     * Returns the number of items in the parts inventory.
     * @return
     */
    public static int getNumberOfItems(){
        Object[] inventory_array = AllParts.toArray();
        return inventory_array.length;

    }

    /**
     * Looks up a part by ID
     * @param partID
     * @return
     */
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

    /**
     * Looks up a part by its name.
     * @param partialName
     * @return
     */
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

    /**
     * Adds a product to the inventory.
     * @param productToAdd
     */
    public static void addProduct(Product productToAdd){
        AllProducts.add(productToAdd);
    }

    /**
     * returns all products in the inventory.
     * @return
     */
    public static ObservableList<Product> getAllProducts(){
        return AllProducts;
    }

    /**
     * This returns the currently selected product based on its index.
     * @param index
     * @return
     */
    public static ObservableList<Product> getCurrentProduct(int index){
        AllProducts.get(index);
        return AllProducts;
    }
}
