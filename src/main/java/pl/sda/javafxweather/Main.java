package pl.sda.javafxweather;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch();
	// write your code here
    }

    //definiujemy stage, plik FXML uprzednio wrzucacmy do resources
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(
                getClass()
                        .getResource("/root.fxml"));
        primaryStage.setScene(new Scene(root,600,350));
        primaryStage.show();
    }
    //ile plkow fxml - tyle kontrolerow




}
