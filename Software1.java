import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.control.TextField;

public class Software1 extends Application {
   @Override
   public void start(Stage applicationStage) {
      int hourlyWage;
      int yearlySalary;
      Scene scene = null;                  // Scene contains all content
      Pane pane = null;                    // Positions components within scene
      TextField outputField = null;        // Displays output salary
      
      pane = new Pane();                   // Create an empty pane     
      scene = new Scene(pane);             // Create a scene containing the pane
            
      // Calculate yearly salary
      hourlyWage = 20;
      yearlySalary = hourlyWage * 40 * 50;
              
      // Create text field and display program output using the text field
      outputField = new TextField();
      outputField.setText("An hourly wage of $" + hourlyWage + "/hr " +
                          "yields $" + yearlySalary + "/yr.");
      outputField.setEditable(false);      // Prevent user from editing text
      outputField.setPrefColumnCount(22);  
      
      pane.getChildren().add(outputField); // Add text field to pane
      
      applicationStage.setScene(scene);    // Set window's scene  
      applicationStage.setTitle("Salary"); // Set window's title
      applicationStage.show();             // Display window
   }
   
   public static void main(String [] args) {
      launch(args); // Launch application
   }
}