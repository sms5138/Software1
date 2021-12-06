package Software1;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
// import javafx.scene.layout.Pane;
// import javafx.scene.control.TextField;

public class Main extends Application {
      public static void main(String[] args){
         launch(args);
      }

      @Override
      public void start(Stage primaryStage) throws Exception{
         Parent root = FXMLLoader.load(getClass().getResource("FXML/main.fxml"));
         primaryStage.setTitle("main page");
         primaryStage.setScene(new Scene(root, 800, 450));
         primaryStage.setResizable(false);
         primaryStage.show();
      }

      public static int index = 0;
}