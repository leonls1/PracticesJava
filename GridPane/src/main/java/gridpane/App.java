package gridpane;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;

public class App extends Application {

    private static Scene scene;
    private static StackPane root;
    private static GridPane gPane;

    @Override
    public void start(Stage stage) throws IOException {

        root = new StackPane();
        calculatorLoad();

        scene = new Scene(root, 300, 250);
        stage.setScene(scene);
        stage.setTitle("Simple Calculator");
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
        gPane = new GridPane();
        
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
        
        Button btn_igual = new Button("=");
        Button btn_c = new Button("C");
        
        GridPane.setConstraints(txt, 0, 0, 4, 1);
        //Row #1
        GridPane.setConstraints(btn7, 0, 1);
        GridPane.setConstraints(btn8, 1, 1);
        GridPane.setConstraints(btn9, 2, 1);
        GridPane.setConstraints(btn_plus, 3, 1);
        
        //Row #2
        GridPane.setConstraints(btn4, 0, 2);
        GridPane.setConstraints(btn5, 1, 2);
        GridPane.setConstraints(btn6, 2, 2);
        GridPane.setConstraints(btn_less, 3, 2);
        
        //Row #3
        GridPane.setConstraints(btn1, 0, 3);
        GridPane.setConstraints(btn2, 1, 3);
        GridPane.setConstraints(btn3, 2, 3);
        GridPane.setConstraints(btn_multiplication, 3, 3);
        
        //Row #4
        GridPane.setConstraints(btn_c, 0, 4);
        GridPane.setConstraints(btn0, 1, 4);
        GridPane.setConstraints(btn_igual, 2, 4);
        GridPane.setConstraints(btn_division, 3, 4);
        
        //setting sizes
        txt.setMaxHeight(Double.MAX_VALUE);
        txt.setMaxWidth(Double.MAX_VALUE);
        txt.setPrefHeight(35);
        
        setMaxSizeButton(btn0);
        setMaxSizeButton(btn1);
        setMaxSizeButton(btn2);
        setMaxSizeButton(btn3);
        setMaxSizeButton(btn4);
        setMaxSizeButton(btn5);
        setMaxSizeButton(btn6);
        setMaxSizeButton(btn7);
        setMaxSizeButton(btn8);
        setMaxSizeButton(btn9);
        setMaxSizeButton(btn_c);
        setMaxSizeButton(btn_division);
        setMaxSizeButton(btn_igual);
        setMaxSizeButton(btn_less);
        setMaxSizeButton(btn_multiplication);
        setMaxSizeButton(btn_plus);
        
        
        //just changing this values the rest of them will adapt
        GridPane.setVgrow(txt, Priority.ALWAYS);
        GridPane.setVgrow(btn7, Priority.ALWAYS);
        GridPane.setVgrow(btn4, Priority.ALWAYS);
        GridPane.setVgrow(btn1, Priority.ALWAYS);
        GridPane.setVgrow(btn_c, Priority.ALWAYS);
        
        GridPane.setHgrow(btn7, Priority.ALWAYS);
        GridPane.setHgrow(btn8, Priority.ALWAYS);
        GridPane.setHgrow(btn9, Priority.ALWAYS);
        GridPane.setHgrow(btn_plus, Priority.ALWAYS);
        
        
        
 
        
        
        gPane.getChildren().addAll(txt, btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8,
                btn9, btn_c, btn_division, btn_igual, btn_less, btn_multiplication, btn_plus);
        gPane.setAlignment(Pos.CENTER);
        gPane.setHgap(5);
        gPane.setVgap(5);
        
        StackPane.setMargin(gPane, new Insets(10));
        
        root.getChildren().add(gPane);
  
        
        
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }
    
    //to save some code lines
    private void setMaxSizeButton(Button btn){
        btn.setMaxWidth(Double.MAX_VALUE);
        btn.setMaxHeight(Double.MAX_VALUE);
    }
    
    private void setPrefSizeButton(Button btn, double witdth, double height){
        btn.setPrefHeight(height);
        btn.setPrefWidth(witdth);
    }

    public static void main(String[] args) {
        launch();
    }

}