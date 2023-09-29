package org.openjfx.hellofx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;

/**
 * JavaFX App
 */
public class App extends Application {
    private static Scene scene; //creating a new scene

    public App() {
        System.out.println("LLamando al constructor");
    }
    
    
    
    @Override
    public void init(){
        System.out.println("Se inicia init() apenas instancias la clase App");
    }
            
    @Override
    public void start(Stage stage) throws IOException{
        scene = new Scene(loadFXML("primary"), 700, 500);
        BorderPane root  = new BorderPane();
        Label label = new Label("Hola mundo");
        Button btn = new Button();  
        btn.setText("Un boton");
        
        root.getChildren().add(label);
        root.getChildren().add(btn);

        stage.setTitle("My first javaFx");
        stage.setScene(scene); //loading the scene
        stage.show(); //showing everything       
    }
    
    @Override
    public void stop(){
        System.out.println("La app ha finalizado");
    }
   
    
    
    
    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fXMLLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        
        return fXMLLoader.load();
    }
    
    static void setRoot(String fxml) throws IOException{
        scene.setRoot(loadFXML(fxml));
    }
    
    public static void main(String[] args) {
        launch();
    }
  

}