package view.ueberweisung;
import controller.EPAController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;
import model.Patient;
import model.Ueberweisung;
import model.Untersuchungsbericht;
import view.FunctionView.ArztMainViewController;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * The type Ueberweisung create view controller.
 */
public class UeberweisungCreateViewController extends ScrollPane {

    @FXML
    private BorderPane MainPane1;

    @FXML
    private TextField Versicherungsnummer;

    @FXML
    private TextField ArztBezeich;

    @FXML
    private Button FortFahren;

    @FXML
    private Button toFunctionView;

    @FXML
    private Button CheckButton;

    @FXML
    private Text HiddenText;

    @FXML
    private TextArea Auftrag;

    @FXML
    private FlowPane Flow;

    @FXML
    private TitledPane Bericht1;

    @FXML
    private RadioButton ChooseButton;

    @FXML
    private Text Date;

    @FXML
    private Text Grund;

    @FXML
    private Text Symtome;

    @FXML
    private Text ICD;

    @FXML
    private TextFlow Behandlung;

    @FXML
    private TextFlow Medikamente;

    @FXML
    private TextFlow Notiz;

    @FXML
    private TitledPane Bericht11;

    @FXML
    private RadioButton ChooseButton1;

    @FXML
    private Text Date1;

    @FXML
    private Text Grund1;

    @FXML
    private Text Symtome1;

    @FXML
    private Text ICD1;

    @FXML
    private TextFlow Behandlung1;

    @FXML
    private TextFlow Medikamente1;

    @FXML
    private TextFlow Notiz1;

    @FXML
    private TitledPane Bericht12;

    @FXML
    private RadioButton ChooseButton2;

    @FXML
    private Text Date2;

    @FXML
    private Text Grund2;

    @FXML
    private Text Symtome2;

    @FXML
    private Text ICD2;

    @FXML
    private TextFlow Behandlung2;

    @FXML
    private TextFlow Medikamente2;

    @FXML
    private TextFlow Notiz2;
    private EPAController epaController;
    private Stage mainStage;
    private boolean versicherungsnummerValid=false;
    private String patientVersucherungnum="";
    private ArrayList<Untersuchungsbericht> BerichtListe=new ArrayList<Untersuchungsbericht>();

    /**
     * Instantiates a new Ueberweisung create view controller.
     *
     * @param primaryStage  the primary stage
     * @param epaController the epa controller
     */
    public UeberweisungCreateViewController(Stage primaryStage, EPAController epaController) {
        this.mainStage= primaryStage;// save primaryStage in main stage
        this.epaController=epaController;// save epa controller in epaController
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/ueberweisung/UeberweisungCreateView.fxml"));// load fxml data
        loader.setRoot(this);
        loader.setController(this);
        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Check versicherungsnum.
     */
    @FXML
    void checkVersicherungsnum(){
        if(Versicherungsnummer.getText().isEmpty()||!(epaController.getEPA().checkNumPatient(Versicherungsnummer.getText()))){// if versicherungnummer textfeld ist empty or there is no such versiucherungnummer in epa
            HiddenText.setText("Versicherungsnummer ist invalid"); // set hidden text in flow pane
            HiddenText.setVisible(true);
            Flow.getChildren().clear(); // clear flow pane
        }
        else{
            Flow.getChildren().clear(); // clear flow pane
            Patient p =epaController.getEPA().getPatient(Versicherungsnummer.getText()); // get patient
            ArrayList<Untersuchungsbericht> berichtliste= epaController.getEPA().getArzt(epaController.getCurrLoggedIn()).getUntersuchungsberichte(Versicherungsnummer.getText());// get untersuchungbericht that this arzt mde for that patient with versicherungnumber
            ArrayList<Ueberweisung> ueberweisungslist= p.getUeberweisungsList();//get ueberweisunglist from patient
            for(int i=0;i<ueberweisungslist.size();i++){// check every element in ueberweisunglist
                if(ueberweisungslist.get(i).getNeuarztnummer().equals(epaController.getCurrLoggedIn())&&ueberweisungslist.get(i).isDatenStimmZu()){// if neuarztnummer ==this arzt id
                    berichtliste.addAll(ueberweisungslist.get(i).getUntersuchungsbericht()); // add all untersuchungberichte of element to berichtliste
                }
            }
            for(int i= 0; i< berichtliste.size(); i++){
                UntersuchungBerichtWahlController uc= new UntersuchungBerichtWahlController(berichtliste.get(i));// create  UntersuchungBerichtWahlController with untersuchungbericht in berichtliste to show
                Flow.getChildren().add(uc); // add the UntersuchungBerichtWahlController to Flowpane
            }
            HiddenText.setText("Versicherungsnummer ist valid");// set hidden text
            HiddenText.setVisible(true);
            patientVersucherungnum=Versicherungsnummer.getText();// save Versicherungsnummer in patientVersucherungnum
            versicherungsnummerValid=true;
        }
    }

    /**
     * To main view.
     */
    @FXML
    void toMainView(){
        mainStage.setScene(new Scene(new ArztMainViewController(mainStage,epaController)));
    }

    /**
     * Ueberweisung review.
     */
    @FXML
    void UeberweisungReview(){
         if(versicherungsnummerValid&&patientVersucherungnum.equals(Versicherungsnummer.getText())){
             if(!(Versicherungsnummer.getText().isEmpty()||ArztBezeich.getText().isEmpty()||ArztBezeich.getText().equals(epaController.getCurrLoggedIn())||Auftrag.getText().isEmpty())){
                 if(!epaController.getEPA().checkNumArzt(ArztBezeich.getText())){
                     HiddenText.setText("Arztnummer nicht gultig");// set hidden text
                     HiddenText.setVisible(true);
                 }
                 else {
                     for(int i= 0; i < Flow.getChildren().size(); i++){
                         UntersuchungBerichtWahlController uc = (UntersuchungBerichtWahlController) Flow.getChildren().get(i);
                         if(uc.isChoosen()){
                             BerichtListe.add(uc.getUntersuchung());
                         }
                     }
                     String time=epaController.getTime();
                     mainStage.setScene(new Scene(new UeberweisungsViewController(Versicherungsnummer.getText(),ArztBezeich.getText(),Auftrag.getText(),BerichtListe,time,mainStage,epaController)));
                 }
             }
             else{
                 HiddenText.setText("Alle Felder mit * müssen eingegeben werden");// set hidden text
                 HiddenText.setVisible(true);
             }
         }
         else if(Versicherungsnummer.getText().isEmpty()){
             HiddenText.setText("Sie haben die Versicherungnummer noch nicht eingegeben");// set hidden text
             HiddenText.setVisible(true);
         }
    }


}

