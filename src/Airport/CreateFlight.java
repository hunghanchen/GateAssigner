package Airport;

import Airport.time.DateOfFlight;
import Airport.Flight.Domestic;
import Airport.Flight.Flight;
import Airport.Flight.International;
import Airport.Flight.Others;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventTarget.*;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author Nancy Chen
 */
public class CreateFlight extends Application {

    public static void main(String[] args) {
        launch(args);

    }

    ArrayList<Flight> infoOfFlight = new ArrayList<>();
    private RadioButton radInternational;
    private RadioButton radDomestic;
    private RadioButton radOthers;
    private TextField txtAirline;
    private TextField txtFlightNo;
    private DatePicker dateOfArrival;
    private DatePicker dateOfDeparture;
    private TextField txtComesFrom;
    private TextField txtGoesTo;

    @Override
    public void start(Stage primaryStage) throws Exception {

        VBox layOut = new VBox(10);
        HBox flightStyle = new HBox(3);
        GridPane gridInfoPrompt = new GridPane();
        gridInfoPrompt.setAlignment(Pos.CENTER);

        Label lblGateAssigner = new Label("Create Flight");

        radInternational = new RadioButton("International");
        radDomestic = new RadioButton("Domestic");
        radOthers = new RadioButton("Others");

        ToggleGroup grpFlightStyle = new ToggleGroup();
        radInternational.setToggleGroup(grpFlightStyle);
        radDomestic.setToggleGroup(grpFlightStyle);
        radOthers.setToggleGroup(grpFlightStyle);

        Label lblAirline = new Label("Airline");
        gridInfoPrompt.add(lblAirline, 0, 0);

        txtAirline = new TextField();

        gridInfoPrompt.add(txtAirline, 1, 0, 2, 1);

        Label lblFlightNo = new Label("Flight Number");
        gridInfoPrompt.add(lblFlightNo, 0, 1);

        txtFlightNo = new TextField();
        gridInfoPrompt.add(txtFlightNo, 1, 1, 2, 1);

        Label lblTimeOfArrival = new Label("Scheduled Time of Arrival");
        gridInfoPrompt.add(lblTimeOfArrival, 0, 2);

        dateOfArrival = new DatePicker();
        gridInfoPrompt.add(dateOfArrival, 1, 2, 1, 1);

        ComboBox<String> cmbClockOfArrival = new ComboBox<>();
        String[] clock = {"00", "01", "02", "03", "04", "05", "06", "07", "08", "09",
            "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21",
            "22", "23"};
        ObservableList clockList = FXCollections.observableArrayList(clock);
        cmbClockOfArrival.setItems(clockList);
        cmbClockOfArrival.getSelectionModel().select("");

        // This two array is use for loop to create 0~59 minutes
        //because integer cant not show 00 01 02 03 04
        //so I need to change to Sting to show these numbers
        Integer[] intArrayMinutes = new Integer[60];
        for (int i = 0; i < intArrayMinutes.length; i++) {
            intArrayMinutes[i] = i;
        }
        ComboBox<String> cmbMinutesOfArrival = new ComboBox<>();
        String[] strArrayMinutes = new String[60];
        for (int i = 0; i < strArrayMinutes.length; i++) {
            if (intArrayMinutes[i] < 10) {
                strArrayMinutes[i] = "0" + String.valueOf(intArrayMinutes[i]);
            } else {
                strArrayMinutes[i] = String.valueOf(intArrayMinutes[i]);
            }
        }

        ObservableList minutesList = FXCollections.observableArrayList(strArrayMinutes);
        cmbMinutesOfArrival.setItems(minutesList);
        cmbMinutesOfArrival.getSelectionModel().select("");

        HBox hBoxTimeOfArrival = new HBox(2);
        hBoxTimeOfArrival.getChildren().addAll(cmbClockOfArrival, cmbMinutesOfArrival);
        gridInfoPrompt.add(hBoxTimeOfArrival, 2, 2, 3, 1);

        Label lblTimeOfDeparture = new Label("Scheduled Time of Departure");
        gridInfoPrompt.add(lblTimeOfDeparture, 0, 3);

        dateOfDeparture = new DatePicker();
        gridInfoPrompt.add(dateOfDeparture, 1, 3, 2, 1);

        ComboBox<String> cmbClockOfDeparture = new ComboBox<>();
//        String[] clock = {"00", "01", "02", "03", "04", "05", "06", "07", "08", "09",
//            "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21",
//            "22", "23"};
        clockList = FXCollections.observableArrayList(clock);
        cmbClockOfDeparture.setItems(clockList);
        cmbClockOfDeparture.getSelectionModel().select("");

        // This two array is use for loop to create 0~59 minutes
        //because integer cant not show 00 01 02 03 04
        //so I need to change to Sting to show these numbers
        ComboBox<String> cmbMinutesOfDeparture = new ComboBox<>();
//        String[] strArrayMinutes = new String[60];
//        for (int i = 0; i < strArrayMinutes.length; i++) {
//            if (intArrayMinutes[i] < 10) {
//                strArrayMinutes[i] = "0" + String.valueOf(intArrayMinutes[i]);
//            } else {
//                strArrayMinutes[i] = String.valueOf(intArrayMinutes[i]);
//            }
//        }

        minutesList = FXCollections.observableArrayList(strArrayMinutes);
        cmbMinutesOfDeparture.setItems(minutesList);
        cmbMinutesOfDeparture.getSelectionModel().select("");

        HBox hBoxTimeOfDeparture = new HBox(2);
        hBoxTimeOfDeparture.getChildren().addAll(cmbClockOfDeparture, cmbMinutesOfDeparture);
        gridInfoPrompt.add(hBoxTimeOfDeparture, 2, 3, 3, 1);

        // can't not show in javafx timepicker
        Label lblComesFrom = new Label("Comes From");
        gridInfoPrompt.add(lblComesFrom, 0, 4);

        txtComesFrom = new TextField();
        gridInfoPrompt.add(txtComesFrom, 1, 4, 2, 1);

        Label lblGoesTo = new Label("Goes To");
        gridInfoPrompt.add(lblGoesTo, 0, 5);

        txtGoesTo = new TextField();
        gridInfoPrompt.add(txtGoesTo, 1, 5, 2, 1);

        Button btnTestDate = new Button("Create Flight");
        btnTestDate.setOnAction(event -> createFlight());
        gridInfoPrompt.add(btnTestDate, 2, 6);
        GridPane.setHalignment(btnTestDate, HPos.RIGHT);

        flightStyle.getChildren()
                .addAll(radInternational, radDomestic, radOthers);
        flightStyle.setAlignment(Pos.CENTER);
        layOut.getChildren().addAll(lblGateAssigner, flightStyle, gridInfoPrompt);
        layOut.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layOut, 550, 400);

        primaryStage.setTitle("Create Flight");
        primaryStage.setScene(scene);

        primaryStage.show();

    }
//    public void createFlight(){
//        
//        while(true){
//            promptFlightInfo();
//        }
//    
//    }

    public void createFlight() {

        if (radInternational.isSelected()) {
            infoOfFlight.add(new International("ProceedeXXX", txtAirline.getText(),
                    txtFlightNo.getText(), txtComesFrom.getText(), txtGoesTo.getText(),
                    dateOfArrival.getValue(), dateOfDeparture.getValue()));
            System.out.println(infoOfFlight.get(0).toString());
        } else if (radDomestic.isSelected()) {
            infoOfFlight.add(new Domestic(txtAirline.getText(),
                    txtFlightNo.getText(), txtComesFrom.getText(), txtGoesTo.getText(),
                    dateOfArrival.getValue(), dateOfDeparture.getValue()));
            System.out.println(infoOfFlight.get(1).toString());
        } else if (radOthers.isSelected()) {
            infoOfFlight.add(new Others(txtAirline.getText(),
                    txtFlightNo.getText(), txtComesFrom.getText(), txtGoesTo.getText(),
                    dateOfArrival.getValue(), dateOfDeparture.getValue()));
            System.out.println(infoOfFlight.get(2).toString());
        }

        radInternational.setSelected(false);
        radDomestic.setSelected(false);
        radOthers.setSelected(false);
        txtAirline.clear();
        txtFlightNo.clear();
        txtComesFrom.clear();
        txtGoesTo.clear();
        dateOfArrival.getEditor().clear();
        dateOfDeparture.getEditor().clear();

    }
}
