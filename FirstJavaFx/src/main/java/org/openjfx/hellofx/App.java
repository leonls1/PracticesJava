package org.openjfx.hellofx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {
    private static Scene scene; //creating a new scene
            
    @Override
    public void start(Stage stage) throws IOException{
        scene = new Scene(loadFXML("primary"), 700, 500);
        stage.setScene(scene); //loading the scene
        stage.show(); //showing everything
    }
    
    
    
    private static Parent loadFXML(String primary) throws IOException {
        
    }
    
    public static void main(String[] args) {
        launch();
    }

    
    

}