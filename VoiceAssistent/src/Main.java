import controller.ViewController;
import javafx.application.Application;
import javafx.stage.Stage;

import java.net.ConnectException;


/**
 * VoiceAssistent
 *
 * @author Jan Adams
 * @version 01.12.2020
 */

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        try {
            new ViewController(primaryStage);
        } catch (ConnectException e) {
            System.exit(1);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }

}
