package loginfx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;
    private static Label lUser, lTitle, lPass;
    private static Button btnLogIn;
    private static VBox logIn;
    private static HBox main;
    private static TextField txtUser;
    private static PasswordField txtPass;

    @Override
    public void start(Stage stage) throws IOException {
        BorderPane root = new BorderPane();        
        
        logIn = new VBox();
        loadVBox();
        main = new HBox();
        
        scene = new Scene(root, 854, 503);
        root.setCenter(logIn);
        
        stage.setScene(scene);
        stage.setTitle("Log in app");
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
    
    private static void loadVBox(){        
       lTitle =  new Label("Log In");
       lUser =  new Label("User");
       lPass = new Label("Passwrod");
       txtUser = new TextField();
       txtPass = new PasswordField();
       btnLogIn =new Button("Enter");
       
        //changing  label sizes
        lTitle.setFont(new Font(30));
        lUser.setFont(new Font(15));
        lPass.setFont(new Font(15));
        
        //setting a static size for all components/nods
        txtUser.setMaxWidth(150);
        txtPass.setMaxWidth(150);
        btnLogIn.setMaxWidth(150);
        
        //to change the current cursor when it's over the button
        btnLogIn.setCursor(Cursor.OPEN_HAND); 
        
        txtUser.setPromptText("Enter your username");
        txtPass.setPromptText("Enter your Password");
        
        logIn.getChildren().addAll(lTitle, lUser, txtUser, lPass, txtPass, btnLogIn);
    }
    

}