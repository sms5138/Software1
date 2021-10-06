package Software1;

import javafx.scene.control.Button;

public class Controller {
    public Button partsAdd;

    public void addPartsClick(){
        System.out.println("add parts clicked...");
        partsAdd.setText("Adding");
    }
}
