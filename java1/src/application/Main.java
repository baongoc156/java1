/*
 *  Lop khoi chay ung dung
 */
package application;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import view.View;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        try {
            View view = new View();
            view.start(primaryStage);
        } catch (Exception e) {
        }
    }

    public static void main(String[] args) {
        launch(args);
    }

    public void handle(WindowEvent event) {
        System.exit(0);
    }
}
