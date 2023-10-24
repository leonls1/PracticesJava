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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import java.io.InputStream;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;
    private static Label lUser, lTitle, lPass;
    private static Button btnLogIn;
    private static VBox logIn, containerLeft;
    private static HBox main;
    private static TextField txtUser;
    private static PasswordField txtPass;
    private static InputStream input;
    private static Image img;
    private static ImageView imgLogo;
    

    @Override
    public void start(Stage stage) throws IOException {
        BorderPane root = new BorderPane();        
        
        logIn = new VBox();
        loadVBox();
        
        containerLeft = new VBox();
        loadImg("C:\\Users\\leonl\\Documents\\NetBeansProjects\\LogInFX\\src\\main\\java\\images\\47131hd.jpg"); //loading the img into the container
        
        main = new HBox();
        main.getChildren().addAll(logIn, containerLeft);
        
        root.getChildren().add(main);
        
        scene = new Scene(root, 854, 503);
        
        stage.setScene(scene);
        stage.setTitle("Log-in app");
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
    
    private void loadVBox(){        
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
        txtUser.setMinWidth(150);
        txtPass.setMinWidth(150);
        btnLogIn.setMinWidth(150);
        
         lTitle.setMinWidth(150);
        lUser.setMinWidth(150);
        lPass.setMinWidth(150);
        
        txtUser.prefWidth(150);
        txtPass.prefWidth(150);
        btnLogIn.prefWidth(150);
        
        //to change the current cursor when it's over the button
        btnLogIn.setCursor(Cursor.OPEN_HAND); 
        
        txtUser.setPromptText("Enter your username");
        txtPass.setPromptText("Enter your Password");
        
        logIn.getChildren().addAll(lTitle, lUser, txtUser, lPass, txtPass, btnLogIn);
    }
    
    private  void loadImg(String url){
        try {
          input = getClass().getResourceAsStream(url);
        img = new Image(input);
        imgLogo = new ImageView(img);
        containerLeft.getChildren().add(imgLogo);  
        } catch (Exception e) {
            System.out.println("No se ha podido cargar la imagen");
        }
        
    }

}