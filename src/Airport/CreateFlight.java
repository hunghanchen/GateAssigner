package Airport;

import Airport.Flight.Domestic;
import Airport.Flight.Flight;
import Airport.Flight.International;
import Airport.Flight.Others;
import Airport.time.TimeOfFlight;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventTarget.*;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
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
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 *
 * @author Nancy Chen
 */
public class CreateFlight extends Application {

    public static void main(String[] args) {
        launch(args);

    }

    private ArrayList<Flight> infoOfFlight = new ArrayList<>();
    private RadioButton radInternational;
    private RadioButton radDomestic;
    private RadioButton radOthers;
    private TextField txtAirline;
    private TextField txtFlightNo;
    private DatePicker dateOfArrival;
    private DatePicker dateOfDeparture;
    private TextField txtComesFrom;
    private TextField txtGoesTo;
    private ComboBox<String> cmbClockOfArrival;
    private ComboBox<String> cmbMinutesOfArrival;
    private ComboBox<String> cmbClockOfDeparture;
    private ComboBox<String> cmbMinutesOfDeparture;
    private TimeOfFlight timeOfArrival;
    private TimeOfFlight timeOfDepature;
    private Alert myAlert;
    private Stage primaryStage;
    private StringBuilder builderFlightInfo;

    @Override
    public void start(Stage primaryStage) throws Exception {

        this.primaryStage = primaryStage;

        VBox layOut = new VBox(10);
        HBox flightStyle = new HBox(3);
        GridPane gridInfoPrompt = new GridPane();
        gridInfoPrompt.setAlignment(Pos.CENTER);

        Label lblGateAssigner = new Label("Create Flight");
        lblGateAssigner.setFont((Font.font("Verdana", 20)));

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

        cmbClockOfArrival = new ComboBox<>();
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
        cmbMinutesOfArrival = new ComboBox<>();
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

        cmbClockOfDeparture = new ComboBox<>();

        clockList = FXCollections.observableArrayList(clock);
        cmbClockOfDeparture.setItems(clockList);
        cmbClockOfDeparture.getSelectionModel().select("");

        // This two array is use for loop to create 0~59 minutes
        //because integer cant not show 00 01 02 03 04
        //so I need to change to Sting to show these numbers
        cmbMinutesOfDeparture = new ComboBox<>();

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

        Button btnCreateFlight = new Button("Create Flight");
        btnCreateFlight.setOnAction(event -> createFlight());
        gridInfoPrompt.add(btnCreateFlight, 2, 6);
        GridPane.setHalignment(btnCreateFlight, HPos.RIGHT);

        Button btnAssignGate = new Button("Assign Gate");
        btnAssignGate.setPrefWidth(100.0);
        btnAssignGate.setPrefHeight(80.0);
        btnAssignGate.setTextAlignment(TextAlignment.CENTER);
        gridInfoPrompt.add(btnAssignGate, 0, 7);
        gridInfoPrompt.setVgap(5);
        gridInfoPrompt.setHgap(5);

        btnAssignGate.setOnAction(event -> AssignGate());

//        Button btnNewOne = new Button("New One");
//        btnAssignGate.setOnAction(event -> NewOne());
        flightStyle.getChildren()
                .addAll(radInternational, radDomestic, radOthers);
        flightStyle.setAlignment(Pos.CENTER);
        flightStyle.setSpacing(25);
        layOut.getChildren().addAll(lblGateAssigner, flightStyle, gridInfoPrompt);
        layOut.setAlignment(Pos.CENTER);
        layOut.setSpacing(30);

        Scene scene = new Scene(layOut, 650, 500, Color.AQUAMARINE);

        primaryStage.setTitle("Create Flight and Assign Gate");
        primaryStage.setScene(scene);

        primaryStage.show();

    }

    private void createFlight() {

        timeOfArrival = new TimeOfFlight(cmbClockOfArrival.getValue(),
                cmbMinutesOfArrival.getValue());

        timeOfDepature = new TimeOfFlight(
                cmbClockOfDeparture.getValue(), cmbMinutesOfDeparture.getValue());

        //show confirmation diologe first if the input is correct
        //it will save to arraylist
        myAlert = new Alert(AlertType.CONFIRMATION, "", ButtonType.YES, ButtonType.NO);
        myAlert.setTitle("Confirm Create Flight");
        myAlert.setHeaderText("Confirm the infomation going to create");
        myAlert.setContentText("Airline: " + txtAirline.getText()
                + "\nFlight no.: " + txtFlightNo.getText() + "\nScheduled Arrival Time: " + dateOfArrival.getValue()
                + "    " + timeOfArrival + "\nScheduled Departure Time: " + dateOfDeparture.getValue()
                + "    " + timeOfDepature + "\nComes From: " + txtComesFrom.getText()
                + "\nGoes To: " + txtGoesTo.getText());

        Optional<ButtonType> result = myAlert.showAndWait();

        if (result.isPresent() && result.get() == ButtonType.YES) {

            AssignFlightInfo();       

        } else {
            return;
        }

        CleanAllField();

    }

    private void AssignGate() {

        //write arraylist data to the file
        builderFlightInfo = new StringBuilder();

        for (Flight f : infoOfFlight) {
            builderFlightInfo.append(f).append("\n");
        }

        System.out.println(builderFlightInfo);

        File file = new File("Flight Information.txt");

        try {
            file.createNewFile();
        } catch (IOException ex) {
            System.out.println(ex.toString());
        }

        try (FileWriter fileWriter = new FileWriter(file, true);
                PrintWriter writer = new PrintWriter(fileWriter)) {
            writer.print(builderFlightInfo);
        } catch (FileNotFoundException ex) {
            System.out.println(ex.toString());
        } catch (IOException ex) {
            System.out.println(ex.toString());
        }

        GateAssigner getGateAssigner = new GateAssigner();

        primaryStage.setScene(getGateAssigner.getScene());

    }

    private ArrayList<Flight> AssignFlightInfo() {

        if (radInternational.isSelected()) {
            infoOfFlight.add(new International(txtAirline.getText(),
                    txtFlightNo.getText(), txtComesFrom.getText(), txtGoesTo.getText(),
                    dateOfArrival.getValue(), dateOfDeparture.getValue(),
                    timeOfArrival, timeOfDepature));

        } else if (radDomestic.isSelected()) {
            infoOfFlight.add(new Domestic(txtAirline.getText(),
                    txtFlightNo.getText(), txtComesFrom.getText(), txtGoesTo.getText(),
                    dateOfArrival.getValue(), dateOfDeparture.getValue(),
                    timeOfArrival, timeOfDepature));

        } else if (radOthers.isSelected()) {
            infoOfFlight.add(new Others(txtAirline.getText(),
                    txtFlightNo.getText(), txtComesFrom.getText(), txtGoesTo.getText(),
                    dateOfArrival.getValue(), dateOfDeparture.getValue(),
                    timeOfArrival, timeOfDepature));

        }

        return infoOfFlight;
    }

    private void CleanAllField() {
        radOthers.setSelected(false);
        radInternational.setSelected(false);
        radDomestic.setSelected(false);
        txtAirline.clear();
        txtFlightNo.clear();
        txtComesFrom.clear();
        txtGoesTo.clear();
        dateOfArrival.getEditor().clear();
        dateOfDeparture.getEditor().clear();
        cmbClockOfDeparture.getSelectionModel().select("");
        cmbMinutesOfDeparture.getSelectionModel().select("");
        cmbClockOfArrival.getSelectionModel().select("");
        cmbMinutesOfArrival.getSelectionModel().select("");

    }

}
