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
    private ArrayList<Boolean> untersuchungberichtInfoSave=new ArrayList<Boolean>();
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
            if(untersuchungsberichtsList.get(i).isWeiterSchicken()){untersuchungWahl.setButtonChoosen();untersuchungberichtInfoSave.add(true);}
            else{untersuchungberichtInfoSave.add(false);}
            untersuchungWahl.setPrefHeight(422.0);
            untersuchungWahl.setPrefWidth(338.0);
            berichtListeView.getChildren().add(untersuchungWahl);
        }
        if(patient.getBehandelnderArzt()!=null){
            hausArzt.setText(patient.getBehandelnderArzt().getName());
        }
    }
    @FXML
    void zuMainView(ActionEvent event) throws IOException {
        updateuntersuchungbericht();
        epaController.getEPA().getPatient(epaController.getCurrLoggedIn()).setNeuUntersuchung(false);
        mainStage.setScene(new Scene(new PatientMainViewController(mainStage,epaController)));
    }

    @FXML
    void zuUntersuchungberichtFinden(ActionEvent event) throws IOException {
        updateuntersuchungbericht();
        mainStage.setScene(new Scene(new UntersuchungberichtFindenViewController(mainStage,epaController)));
    }

    @FXML
    void zumHausArztFinden(ActionEvent event) throws IOException {
        updateuntersuchungbericht();
        mainStage.setScene(new Scene(new ArztTabViewController(mainStage,epaController)));
    }
    private void updateuntersuchungbericht() throws IOException {
        Patient patient= epaController.getEPA().getPatient(epaController.getCurrLoggedIn());
        ArrayList<Untersuchungsbericht> untersuchungsberichtsList= patient.getUntersuchungList();
        boolean changed=false;
        if(notempty){
            for(int i=0;i<berichtListeView.getChildren().size();i++){
                UntersuchungBerichtWahlController uc= (UntersuchungBerichtWahlController)berichtListeView.getChildren().get(i);
                if(uc.isChoosen()){
                    if(untersuchungberichtInfoSave.get(i)==false){changed = true;}
                    untersuchungsberichtsList.get(i).setWeiterSchicken(true);
                }
                else{
                    if(untersuchungberichtInfoSave.get(i)==true){changed = true;}
                    untersuchungsberichtsList.get(i).setWeiterSchicken(false);
                }
            }
        }
        if(changed==true){epaController.getEPA().getPatient(epaController.getCurrLoggedIn()).addToRevision(epaController.getTime()+" Sie haben Veranderungen zu ihrer Untersuchungberichtliste gemacht");}
        patient.setNeuUntersuchung(false);
        epaController.getIO().save();
    }
}
