
package internetpaketi;

import java.io.IOException;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.SplitPane;
import javafx.stage.Stage;


public class FXMain extends Application {
    
  
    private Stage stage;
    private SplitPane layout;
    
    
    @Override
    public void start(Stage stage) throws Exception {
       
       this.stage = stage;
       this.stage.setTitle("Prodaja internet paketa");
       showView();
       }
       
    private void showView() throws IOException{
    FXMLLoader loader = new FXMLLoader();
    loader.setLocation(FXMain.class.getResource("view/FXMLDocument.fxml"));
    layout= loader.load();
    Scene scene = new Scene(layout); 
    scene.getStylesheets().add("internetpaketi/view/css.css");
    stage.setScene(scene);
    stage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
    
}

