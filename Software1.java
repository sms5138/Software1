import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
// import javafx.scene.layout.Pane;
// import javafx.scene.control.TextField;

public class Software1 extends Application {
      public static void main(String[] args){
         launch(args);
      }

      @Override
      public void start(Stage primaryStage) throws Exception{
         Parent root = FXMLLoader.load(getClass().getResource("main_form.fxml"));
         primaryStage.setTitle("main page");
         primaryStage.setScene(new Scene(root, 640, 400));
         primaryStage.show();
      }
}