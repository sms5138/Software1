package Software1;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class Main extends Application {
      public static void main(String[] args){
         launch(args);
      }

      /**
       * This initializes the application.
       * 
       * RUNTIME ERROR: I ran into an error where the associatedParts observable list kept failing to let the program compile stating that 'this.assocaiatedParts is null'. After digging in I realized that the I forgot to initialize it. Once initialized it worked as expected.
       * 
       * FUTURE ENHANCEMENT: Were I to extend the functionality I would incorperate a database as this would allow the data to live in a manner that extended past the time the application is running.
       */
      @Override
      public void start(Stage primaryStage) throws Exception{
         Parent root = FXMLLoader.load(getClass().getResource("FXML/main.fxml"));
         primaryStage.setTitle("main page");
         primaryStage.setScene(new Scene(root, 800, 450));
         primaryStage.setResizable(false);
         primaryStage.show();
      }

}