package Airport;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * a completely different Stage that we use to get info from
 *
 * @author paulbonenfant
 */
public final class GateAssigner extends Stage {

    public GateAssigner() {

        // here is the gate assigner stage when user in the create flight stage 
        // click gate assign button will bump out this stage
        VBox root = new VBox(10);

        Label lblGateAssign = new Label("Gate Assign");

        HBox hboxFlightInfo = new HBox(3);
        Label lblFlightInfo = new Label("Flight Info");
        ComboBox<String> cmbFlight = new ComboBox<>();
        ObservableList flightList = FXCollections.observableArrayList(ArrFlightInfo());
        cmbFlight.setItems(flightList);

        Button btnSearchFlight = new Button("Search");
        hboxFlightInfo.getChildren().addAll(lblFlightInfo, cmbFlight, btnSearchFlight);
        hboxFlightInfo.setAlignment(Pos.CENTER);

        root.setAlignment(Pos.CENTER);
        root.getChildren().addAll(lblGateAssign, hboxFlightInfo);

        setScene(new Scene(root, 550, 400));

        setTitle("Enter New Title Info");
    }

    private String[] ArrFlightInfo() {

        File file = new File("Flight Information.txt");
        String[] part = new String[100];
        String[] outputPart = new String[20];
        int i = 0;
        char charFlight;
        char charFlightName;
        StringBuilder builderFlightInfo = new StringBuilder();

//        String[] xs = new String[]{"a", "b", "c", "d"};
//        return xs;
        try {
            Scanner fileFlight = new Scanner(file);
            while (fileFlight.hasNextLine()) {
                part = fileFlight.nextLine().split(",");
//                String flightAssign = part[0].trim();
//                String flight = part[0] + "," + part[1] + "," + part[2];

                //we need to put in the combox only need for the three character of the flight type
                for (int j = 0; j < 3; j++) {
                    String flightType = part[0].trim();
                    charFlight = flightType.charAt(j);
                    builderFlightInfo.append(charFlight);
                }
                for (int j = 0; j < 3; j++) {
                    if (j == 0) {
                        String flightType = part[1].trim();
                        charFlight = Character.toUpperCase(flightType.charAt(j));
                        builderFlightInfo.append(charFlight);
                    } else {
                        String flightType = part[1].trim();
                        charFlight = flightType.charAt(j);
                        builderFlightInfo.append(charFlight);
                    }
                }
                builderFlightInfo.append(part[2].trim());
                outputPart[i] = builderFlightInfo.toString();
                i++;
                builderFlightInfo.setLength(0);

            }

        } catch (FileNotFoundException ex) {
            System.out.println(ex.toString());
        }
        return outputPart;

    }

    private void CreateRandomAccessFileAndAssignTime() {
        // create the april 30 days array (we only use the april)
        Integer[] intArrayDate = new Integer[30];
        for (int i = 0; i < intArrayDate.length; i++) {
            intArrayDate[i] = i + 1;
        }
        String[] strArrayDate = new String[30];
        for (int i = 0; i < strArrayDate.length; i++) {
            if (intArrayDate[i] < 10) {
                strArrayDate[i] = "0" + String.valueOf(intArrayDate[i]);
            } else {
                strArrayDate[i] = String.valueOf(intArrayDate[i]);
            }
        }
        int[] clock = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        
        

    }
}
