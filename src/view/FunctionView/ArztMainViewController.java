package view.FunctionView;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import view.StartView.LoginViewController;

import java.io.IOException;

public class ArztMainViewController extends AnchorPane {

    @FXML
    private Text aVorname;

    @FXML
    private Text aNachname;

    @FXML
    private Text aFach;

    @FXML
    private Text aNum;

    @FXML
    private Text aTel;

    @FXML
    private Button aZumZusammenfassung;

    @FXML
    private Button aBerichtErstellen;

    @FXML
    private Button aUeberweisungErstellen;

    @FXML
    private Button aZumRevisionen;

    @FXML
    private Button aLogout;
    private Stage mainStage;
    private String aID;
    public ArztMainViewController(Stage primaryStage, String ID) {
        aID= ID;
        mainStage= primaryStage;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/FunctionView/ArztMainView.fxml"));
        loader.setRoot(this);
        loader.setController(this);
        try {
            loader.load();
        } catch (IOException e) {

            e.printStackTrace();
        }
    }
    @FXML
    void zumLoginView(){
        mainStage.setScene(new Scene(new LoginViewController(mainStage)));
    }

}
