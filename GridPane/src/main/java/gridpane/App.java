package gridpane;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class App extends Application {

    private static Scene scene;
    private static GridPane root;

    @Override
    public void start(Stage stage) throws IOException {

        root = new GridPane();

        scene = new Scene(root, 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }
    
    private void simpleLoad(){
        Button btn1 = new Button("Button # 1");
        Button btn2 = new Button("Button # 2");
        Button btn3 = new Button("Button # 3");
        Button btn4 = new Button("Button # 4");
        Button btn5 = new Button("Button # 5");
        Button btn6 = new Button("Button # 6");
        
        GridPane.setConstraints(btn1, 0, 0, 1,2);
        btn1.setMaxHeight(Double.MAX_VALUE);
        btn1.setMaxWidth(Double.MAX_VALUE);
        
        
        GridPane.setConstraints(btn3, 0, 2);
        
        GridPane.setConstraints(btn4, 1, 0);
        GridPane.setConstraints(btn5, 1, 1);
        GridPane.setConstraints(btn6, 1, 2);
        root.getChildren().addAll(btn1, btn3,  btn4, btn5, btn6);
    }
    
    private void calculatorLoad(){
       
        TextField txt = new TextField();
        Button btn1 = new Button(" 1");
        Button btn2 = new Button(" 2");
        Button btn3 = new Button("3");
        Button btn4 = new Button("4");
        Button btn5 = new Button("5");
        Button btn6 = new Button("6");
        Button btn7 = new Button("7");
        Button btn8 = new Button("8");
        Button btn9 = new Button("9");
        Button btn0 = new Button("0");
        
        Button btn_plus = new Button("+");
        Button btn_less = new Button("-");
        Button btn_multiplication = new Button("x");
        Button btn_division = new Button("/");
        
  
        
        
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}