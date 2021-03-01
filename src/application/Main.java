package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import view.StartView.LoginViewController;

public class Main extends Application {

    /**
 	 *
 	 * TODO: create JavaDoc. 
 	 * @param primaryStage
 	 */
    @Override
    public void start(Stage primaryStage) {
        try {
            LoginViewController loginViewController = new LoginViewController();
            Scene scene = new Scene(loginViewController, 400, 200);
            scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
 	 *
 	 * TODO: create JavaDoc. 
 	 * @param args
 	 */
    public static void main(String[] args) {
        launch(args);
    }
}
