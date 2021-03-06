package view.UntersuchungberichtEinstellen;
import controller.EPAController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.Patient;
import model.Untersuchungsbericht;
import view.FunctionView.PatientMainViewController;
import view.ueberweisung.UntersuchungBerichtWahlController;
import view.ueberweisung.UntersuchungsWahlController;

import java.io.IOException;
import java.util.ArrayList;

public class UntersuchungberichtEinstellenViewController extends AnchorPane {

    @FXML
    private Text hausArzt;
    @FXML
    private Text HiddenText;
    @FXML
    private Button hausArztFinden;

    @FXML
    private FlowPane berichtListeView;

    @FXML
    private Button zuUntersuchungberichtFinden;

    @FXML
    private Button zuMainView;
    private Stage mainStage;
    private EPAController epaController;
    private boolean notempty;
    public UntersuchungberichtEinstellenViewController(Stage mainStage, EPAController epaController){
        this.mainStage=mainStage;
        this.epaController=epaController;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/UntersuchungberichtEinstellen/UntersuchungberichtEinstellen.fxml"));
        loader.setRoot(this);
        loader.setController(this);
        try {
            loader.load();
            init();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void init(){
        Patient patient= epaController.getEPA().getPatient(epaController.getCurrLoggedIn());
        ArrayList<Untersuchungsbericht> untersuchungsberichtsList= patient.getUntersuchungList();
        if(untersuchungsberichtsList.size()!=0){berichtListeView.getChildren().clear();notempty=true;}
        for(int i=0; i< untersuchungsberichtsList.size(); i++){
            UntersuchungBerichtWahlController untersuchungWahl = new UntersuchungBerichtWahlController(untersuchungsberichtsList.get(i));
            untersuchungWahl.setPrefHeight(422.0);
            untersuchungWahl.setPrefWidth(338.0);
            berichtListeView.getChildren().add(untersuchungWahl);
        }
        if(patient.getBehandelnderArzt()!=null){
            hausArzt.setText(patient.getBehandelnderArzt().getName());
        }
    }
    @FXML
    void zuMainView(ActionEvent event) {
        Patient patient= epaController.getEPA().getPatient(epaController.getCurrLoggedIn());
        ArrayList<Untersuchungsbericht> untersuchungsberichtsList= patient.getUntersuchungList();
        if(notempty){
            for(int i=0;i<berichtListeView.getChildren().size();i++){
                UntersuchungBerichtWahlController uc= (UntersuchungBerichtWahlController)berichtListeView.getChildren().get(i);
                if(uc.isChoosen()){untersuchungsberichtsList.get(i).setWeiterSchicken(true);}
            }
        }
        mainStage.setScene(new Scene(new PatientMainViewController(mainStage,epaController)));
    }

    @FXML
    void zuUntersuchungberichtFinden(ActionEvent event) {
        mainStage.setScene(new Scene(new UntersuchungberichtFindenViewController(mainStage,epaController)));
    }

    @FXML
    void zumHausArztFinden(ActionEvent event) {
        mainStage.setScene(new Scene(new ArztTabViewController(mainStage,epaController)));
    }
}
