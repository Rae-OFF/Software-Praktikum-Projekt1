package view.zusammenfassungderBehandlungsschritt;

import controller.EPAController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.EPA;
import model.Patient;
import view.FunctionView.ArztMainViewController;
import view.StartView.LoginViewController;

import java.io.IOException;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import view.ueberweisung.UeberweisungCreateViewController;

//hi
public class EingabeSeiteController extends AnchorPane {
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    void toMain(ActionEvent event) {

    }

    @FXML
    void initialize() {

    }

    @FXML
    private TextField pVersicherungsnummer;

    @FXML
    private TextField pICDCode;

    private Stage mainStage;
    private EPAController EPAControll;

    public EingabeSeiteController(Stage primaryStage, EPAController EPAControll) {
        this.EPAControll= EPAControll;
        mainStage = primaryStage;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/zusammenfassungderBehandlungsschritt/EingabeSeite.fxml"));
        loader.setRoot(this);
        loader.setController(this);
        try {
            loader.load();
        } catch (IOException e) {

            e.printStackTrace();
        }
    }


/*
    @FXML
    void zumArztMainView(ActionEvent e){
        mainStage.setScene(new Scene(new ArztMainViewController(mainStage, EPAControll)));
    }*/

    @FXML
    void zumArztMainView(ActionEvent event){
       mainStage.setScene(new Scene(new ArztMainViewController(mainStage, EPAControll)));
    }

    @FXML
     void zumZusammenfassung(ActionEvent event){
        //String pVersicherungsnum= pVersicherungsnummer.getText();
        //String pICD =pICDCode.getText();
       // if (pVersicherungsnum != null ) {
            mainStage.setScene(new Scene(new zusammenfassungsController(mainStage, EPAControll)));
       //}
    }

    /*
    @FXML
    void zumZusammenfassung(ActionEvent event){
        String pVS= pVersicherungsnummer.getText();
        String pICD =pICDCode.getText();
        if (pVS != null ) {
            EPA epa= EPAControll.getEPA();
            if(epa.checkNumPatient(pVS)){
                //EPAControl.getUntersuchungsberichtcontroller();
                //mainStage.setScene(new Scene(???));
            }
        }
    }*/


}
