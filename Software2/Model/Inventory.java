package Software2.Model;

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
     * Adds a product to the inventory.
     * @param productToAdd
     */
    public static void addProduct(Product productToAdd){
        AllProducts.add(productToAdd);
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
     * This is used to take the ID of a product and search the inventory for it.
     * @param prodID
     * @return
     */
    public Product lookupProduct(int prodID){
        ObservableList<Product> allProds = Inventory.getAllProducts();

        for(Product partToCheck : allProds){
            System.out.println("searching object " + partToCheck.getId() + "...");
            if(partToCheck.getId() == prodID){
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
     * This takes the name of the product and searches the current list of products for its existence.
     * @param partialName
     * @return
     */
    public ObservableList<Product> lookupProduct(String partialName){
        ObservableList<Product> namedPart = FXCollections.observableArrayList();

        ObservableList<Product> allParts = Inventory.getAllProducts();

        for(Product partToCheck : allParts){
            System.out.println("searching object " + partToCheck.getId() + "...");
            if(partToCheck.getName().contains(partialName)){
                namedPart.add(partToCheck);
            }
        }


        return namedPart;
    }

    /**
     * This updates the parts
     * @param index
     * @param partToRemove
     * @return
     */
    public static void updateParts(int index, Part partToRemove){
        AllParts.set(index, partToRemove);
    }

    /**
     * Updates a product
     * @param index
     * @param partToRemove
     */
    public static void updateProduct(int index, Product partToRemove){
        AllProducts.set(index, partToRemove);
    }

    /**
     * This removes the part from the inventory.
     * @param partToRemove
     * @return
     */
    public static boolean deleteParts(Part partToRemove){
        return AllParts.remove(partToRemove);
    }


    /**
     * This removes the product from the inventory.
     * @param partToRemove
     * @return
     */
    public static boolean deleteProduct(Product productToRemove){
        return AllProducts.remove(productToRemove);
    }

    /**
     * This provides all the parts in the inventory.
     * @return
     */
    public static ObservableList<Part> getAllParts(){
        return AllParts;
    }

    /**
     * returns all products in the inventory.
     * @return
     */
    public static ObservableList<Product> getAllProducts(){
        return AllProducts;
    }

    // Addtional/Not Used

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
     * Returns the number of items in the parts inventory.
     * @return
     */
    public static int getNumberOfItems(){
        Object[] inventory_array = AllParts.toArray();
        return inventory_array.length;

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
