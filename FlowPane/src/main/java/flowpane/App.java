package flowpane;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import javafx.geometry.Orientation;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        Button btn1 = new Button("Buttton #1");
        Button btn2 = new Button("Buttton #2");
        Button btn3 = new Button("Buttton #3");
        Button btn4 = new Button("Buttton #4");
        Button btn5 = new Button("Buttton #5");
        
        FlowPane root = new FlowPane();
        
        root.setHgap(10);
        root.setVgap(12);
        
        root.getChildren().addAll(btn1, btn2, btn3, btn4, btn5);
        root.setOrientation(Orientation.VERTICAL);
        
        scene = new Scene(root, 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}