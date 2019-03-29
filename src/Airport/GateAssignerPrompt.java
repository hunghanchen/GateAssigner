package Airport;

import Airport.Flight.DateOfFlight;
import Airport.Flight.Domestic;
import Airport.Flight.Flight;
import Airport.Flight.International;
import Airport.Flight.Others;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
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
public class GateAssignerPrompt extends Application {

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
        gridInfoPrompt.add(dateOfArrival, 1, 2, 2, 1);

        Label lblTimeOfDeparture = new Label("Scheduled Time of Departure");
        gridInfoPrompt.add(lblTimeOfDeparture, 0, 3);

        dateOfDeparture = new DatePicker();
        gridInfoPrompt.add(dateOfDeparture, 1, 3, 2, 1);

        // can't not show in javafx timepicker
//        TimePicker time = new TimePicker();
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

        Scene scene = new Scene(layOut, 400, 400);

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
