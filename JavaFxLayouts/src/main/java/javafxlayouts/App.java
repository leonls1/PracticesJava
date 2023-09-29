package javafxlayouts;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;


public class App extends Application {

    private static Scene scene;
    private static Button btn1 = new Button("Boton 1");
    private static Button btn2 = new Button("Boton 2");
    private static Button btn3 = new Button("Boton 3");
    private static Button btn4 = new Button("Boton 4");
    private static Button btn5 = new Button("Boton 5");
    private static BorderPane root = new BorderPane();

    @Override
    public void start(Stage stage) throws IOException {
        
        scene = new Scene(root, 640, 480);     
        //setziseButtons();
        
        //labels for my login
        Label lTitle = new Label("  Login");
        Label lUser = new Label("User");
        Label lPass = new Label("Password");
        
        //changing  label sizes
        lTitle.setFont(new Font(30));
        lUser.setFont(new Font(15));
        lPass.setFont(new Font(15));
        
        //textBox for the login
        TextField textUser = new TextField();
        PasswordField textPass = new PasswordField();
        
        //aaand the final button to logIn the current user
        Button btnLogIn = new Button("Enter");
        
        //creating a new container for the nods of logIn component
        VBox columnContainer = new VBox();
        columnContainer.getChildren().addAll(lTitle, lUser, textUser, lPass, textPass, btnLogIn);
        
        // setting in middle the container
        root.setCenter(columnContainer);
        
        
        
        stage.setScene(scene);
        stage.setTitle("Layout_borderLine");
        stage.show();
    }
    
    
    static void setziseButtons(){
        //setting buttons into my borderpane(main layout)
        root.setCenter(btn1); 
        btn1.setMaxWidth(Double.MAX_VALUE);
        btn1.setMaxHeight(Double.MAX_VALUE);
        //now btn1 will use all of the space available
        BorderPane.setMargin(btn1, new Insets(5, 5, 5, 5));
        //setting margin for the button 1
        
        
        
        root.setTop(btn2);
        btn2.setMaxWidth(Double.MAX_VALUE);
        btn2.setMaxHeight(Double.MAX_VALUE);
        BorderPane.setMargin(btn2, new Insets(0, 0, 0, 5));
        
        root.setBottom(btn3);
        btn3.setMaxWidth(Double.MAX_VALUE);
        btn3.setMaxHeight(Double.MAX_VALUE);
        BorderPane.setMargin(btn3, new Insets(5, 0, 0, 0));
        
        root.setLeft(btn4);
        btn4.setMaxWidth(Double.MAX_VALUE);
        btn4.setMaxHeight(Double.MAX_VALUE);
        BorderPane.setMargin(btn4, new Insets(5, 0, 5, 5));
        
        root.setRight(btn5);
        btn5.setMaxWidth(Double.MAX_VALUE);
        btn5.setMaxHeight(Double.MAX_VALUE);
        BorderPane.setMargin(btn5, new Insets(5, 5, 0, 5));
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