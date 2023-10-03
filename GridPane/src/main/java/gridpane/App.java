package gridpane;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        Button btn1 = new Button("Button # 1");
        Button btn2 = new Button("Button # 2");
        Button btn3 = new Button("Button # 3");
        Button btn4 = new Button("Button # 4");
        Button btn5 = new Button("Button # 5");
        Button btn6 = new Button("Button # 6");
        
        GridPane.setConstraints(btn1, 0, 0);
        GridPane.setConstraints(btn2, 0, 1);
        GridPane.setConstraints(btn3, 0, 2);
        
        GridPane.setConstraints(btn4, 1, 0);
        GridPane.setConstraints(btn5, 1, 1);
        GridPane.setConstraints(btn6, 1, 2);
        
        GridPane root = new GridPane();
        
        root.getChildren().addAll(btn1, btn3, btn2, btn4, btn5, btn6);
        
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