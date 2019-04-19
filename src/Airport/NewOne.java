//package Airport;
//
//import java.io.File;
//import java.io.FileNotFoundException;
//import java.io.IOException;
//import java.io.RandomAccessFile;
//import java.util.Scanner;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//import javafx.collections.FXCollections;
//import javafx.collections.ObservableList;
//import javafx.geometry.HPos;
//import javafx.geometry.Insets;
//import javafx.geometry.Pos;
//import javafx.scene.Scene;
//import javafx.scene.control.Button;
//import javafx.scene.control.ComboBox;
//import javafx.scene.control.DatePicker;
//import javafx.scene.control.Label;
//import javafx.scene.control.RadioButton;
//import javafx.scene.control.TextField;
//import javafx.scene.control.ToggleGroup;
//import javafx.scene.layout.GridPane;
//import javafx.scene.layout.HBox;
//import javafx.scene.layout.VBox;
//import javafx.scene.text.Font;
//import javafx.scene.text.TextAlignment;
//import javafx.stage.Modality;
//import javafx.stage.Stage;
//
///**
// * a completely different Stage that we use to get info from
// *
// * @author paulbonenfant
// */
//public final class GateAssigner extends Stage {
//
//    private ComboBox<String> cmbFlight;
//    private File file;
//    private StringBuilder allFileContent;
//    private Label lblFlightShowInfo;
//    private Label lblGateNum;
//    private static Stage primaryStage;
//
//    private static final int GATE_SIZE = 5;
//    private static final int DATE_SIZE = 2;
//    private static final int CLOCK_SIZE = 4;
//
//    private static final int RECORD_SIZE = (GATE_SIZE * 2) + (DATE_SIZE * 2 * 30) + (CLOCK_SIZE * 24 * 30);
//
//    public GateAssigner() {
//        CreateRandomAccessFileAndAssignTime();
//
//        // here is the gate assigner stage when user in the create flight stage 
//        // click gate assign button will bump out this stage
//        VBox root = new VBox(10);
//
//        Label lblGateAssign = new Label("Gate Assign");
//
//        HBox hboxFlightInfo = new HBox(3);
//        Label lblFlightInfo = new Label("Flight Info");
//        cmbFlight = new ComboBox<>();
//        ObservableList flightList = FXCollections.observableArrayList(ArrFlightInfo());
//        cmbFlight.setItems(flightList);
//
//        Button btnSearchFlight = new Button("Search");
//        btnSearchFlight.setOnAction(event -> showInfo_AssignGate());
//
//        lblFlightShowInfo = new Label();
//
//        lblGateNum = new Label();
//
//        Button btnBackHome = new Button("Back");
//        btnBackHome.setOnAction(event -> BackHomePage());
//
//        hboxFlightInfo.getChildren().addAll(lblFlightInfo, cmbFlight, btnSearchFlight);
//        hboxFlightInfo.setAlignment(Pos.CENTER);
//
//        root.setAlignment(Pos.CENTER);
//        root.getChildren().addAll(lblGateAssign, hboxFlightInfo, lblFlightShowInfo, lblGateNum, btnBackHome);
//
//        setScene(new Scene(root, 550, 400));
//
//        setTitle("Enter New Title Info");
//    }
//
//    private void showInfo_AssignGate() {
//        int itemSelectNumIndex = cmbFlight.getSelectionModel().getSelectedIndex();//know which index of item they select and grab from file
//
//        file = new File("Flight Information.txt");
//
//        try (RandomAccessFile raf = new RandomAccessFile("AprilSecduleDate.dat", "r")) {
//            allFileContent = new StringBuilder();
//            Scanner fileContent = new Scanner(file);
//            while (fileContent.hasNextLine()) {
//                allFileContent.append(fileContent.nextLine()).append("\n");
//            }
//            String partContentBeforSplit = String.valueOf(allFileContent);
//            String[] partContentAfterSplit = partContentBeforSplit.split("\n");
//            lblFlightShowInfo.setText(partContentAfterSplit[itemSelectNumIndex]);
//            System.out.println("partContentAfterSplit[itemSelectNumIndex]" + partContentAfterSplit[itemSelectNumIndex]);
//            String[] strFlightAllInfo = partContentAfterSplit[itemSelectNumIndex].split(",");
//            System.out.println(strFlightAllInfo[4].trim().substring(0, 2));
//
//            int convertDateStringToInt = Integer.valueOf(strFlightAllInfo[3].trim().substring(8));
//            int convertClockStringToInt = Integer.valueOf(strFlightAllInfo[4].trim().substring(0, 2));
//            int convertFlightNoStringToInt = Integer.valueOf(strFlightAllInfo[2].trim());
//            System.out.println("convertDateStringToInt" + convertDateStringToInt);
//            System.out.println("convertClockStringToInt" + convertClockStringToInt);
//
//            raf.seek(0);
//            raf.skipBytes((GATE_SIZE * 2)
//                    + ((DATE_SIZE * 2 + CLOCK_SIZE * 24) * (convertDateStringToInt - 1))
//                    + (DATE_SIZE * 2) + (convertClockStringToInt * CLOCK_SIZE));
//            if (raf.readInt() == convertFlightNoStringToInt) {
////                raf.seek(0);
////                raf.skipBytes((GATE_SIZE * 2)
////                        + ((DATE_SIZE * 2 + CLOCK_SIZE * 24) * (convertDateStringToInt - 1))
////                        + (DATE_SIZE * 2) + (convertClockStringToInt * CLOCK_SIZE));
//
//                lblGateNum.setText("Go to Gate 1");
//
////                raf.writeInt(intArrConvertStrNumberToInt[i]);
//            } else {
//                raf.seek(RECORD_SIZE);
//                raf.skipBytes((GATE_SIZE * 2)
//                        + ((DATE_SIZE * 2 + CLOCK_SIZE * 24) * (convertDateStringToInt - 1))
//                        + (DATE_SIZE * 2) + (convertClockStringToInt * CLOCK_SIZE));
//                lblGateNum.setText("Go to Gate 2");
//            }
//
//        } catch (FileNotFoundException ex) {
//            System.out.println(ex.toString());
//        } catch (IOException ex) {
//            System.out.println(ex.toString());
//        }
//
//    }
//
//    //this is going to show on the list
//    private String[] ArrFlightInfo() {
//
//        file = new File("Flight Information.txt");
//        String[] part = new String[9];
//        String[] outputPart = new String[20];
//        int i = 0;
//        char charFlight;
//        StringBuilder builderFlightInfo = new StringBuilder();
//
//        try {
//            Scanner fileFlight = new Scanner(file);
//            while (fileFlight.hasNextLine()) {
//                part = fileFlight.nextLine().split(",");
//                for (int j = 0; j < 3; j++) {
//                    String flightType = part[0].trim();
//                    charFlight = flightType.charAt(j);
//                    builderFlightInfo.append(charFlight);
//                }
//                for (int j = 0; j < 3; j++) {
//                    if (j == 0) {
//                        String flightType = part[1].trim();
//                        charFlight = Character.toUpperCase(flightType.charAt(j));
//                        builderFlightInfo.append(charFlight);
//                    } else {
//                        String flightType = part[1].trim();
//                        charFlight = flightType.charAt(j);
//                        builderFlightInfo.append(charFlight);
//                    }
//                }
//                builderFlightInfo.append(part[2].trim());
//                outputPart[i] = builderFlightInfo.toString();
//                i++;
//                builderFlightInfo.setLength(0);
//
//            }
//
//        } catch (FileNotFoundException ex) {
//            System.out.println(ex.toString());
//        }
//        return outputPart;
//
//    }
//
//    private void CreateRandomAccessFileAndAssignTime() {
//        // create the april 30 days array (we only use the april)
//        String[] arrFlightInfoPart = new String[9];
//        String[] gate = {"Gate1", "Gate2"};
//        Integer[] intArrayDate = new Integer[30];
//        for (int i = 0; i < intArrayDate.length; i++) {
//            intArrayDate[i] = i + 1;
//        }
//        String[] strArrayDate = new String[30];
//        for (int i = 0; i < strArrayDate.length; i++) {
//            if (intArrayDate[i] < 10) {
//                strArrayDate[i] = "0" + String.valueOf(intArrayDate[i]);
//            } else {
//                strArrayDate[i] = String.valueOf(intArrayDate[i]);
//            }
//        }
//        int[] clock = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
//
//        try (RandomAccessFile raf = new RandomAccessFile("AprilSecduleDate.dat", "rw")) {
//
//            for (int k = 0; k < gate.length; k++) {
//                raf.writeChars(gate[k]);
//                for (int i = 0; i < strArrayDate.length; i++) {
//                    raf.writeChars(strArrayDate[i]);
//                    for (int j = 0; j < clock.length; j++) {
//                        raf.writeInt(clock[j]);
//                    }
//                }
//            }
//            raf.seek(0);
//            StringBuilder builder = new StringBuilder();
//            for (int i = 0; i < GATE_SIZE; i++) {
//                builder.append(raf.readChar());
//            }
//            System.out.println(builder);
//            //------------------------------------------(above is create the standard)
//            //----------------------------------(below start to read every date write into the raf)
//            File file = new File("Flight Information.txt");
//
//            try {
//                Scanner fileFlight = new Scanner(file);
//                int i = 0;
//                while (fileFlight.hasNextLine()) {
//                    arrFlightInfoPart = fileFlight.nextLine().split(",");
//                    String[] strArrFlightAssignArrivalDate = new String[]{arrFlightInfoPart[3].trim()};//2019-04-08
//                    strArrFlightAssignArrivalDate[i] = strArrFlightAssignArrivalDate[i].substring(8);//catch 08
//                    int[] intArrConvertStrDepDateToInt = new int[]{Integer.valueOf(strArrFlightAssignArrivalDate[i])};//String 08 convert to integer 6
//                    String[] strArrFlightAssignArrivalTime = new String[]{arrFlightInfoPart[4].trim()};//01 : 02
//                    int[] intArrFlightAssignArrivalTime = new int[]{Integer.valueOf(strArrFlightAssignArrivalTime[i].substring(0, 2))};//String 01 to integer to 1
//
//                    String[] strArrFlightAssignDepartDate = new String[]{arrFlightInfoPart[5].trim()};//2019-04-08
//                    strArrFlightAssignDepartDate[i] = strArrFlightAssignDepartDate[i].substring(8);
//                    int[] intArrConvertStrArrDateToInt = new int[]{Integer.valueOf(strArrFlightAssignDepartDate[i])};
//                    String[] strArrFlightAssignDepartTime = new String[]{arrFlightInfoPart[6].trim()};//01 : 02
//                    int[] intArrFlightAssignDepartTime = new int[]{Integer.valueOf(strArrFlightAssignDepartTime[i].substring(0, 2))};
//
//                    //here to convert fligt no. string into integer
//                    String[] strArrFlightNo = new String[]{arrFlightInfoPart[2].trim()};//String flight no. "6384" into integer 6384
//                    int[] intArrConvertStrNumberToInt = new int[]{Integer.valueOf(strArrFlightNo[i])};
//                    System.out.println(intArrConvertStrNumberToInt[0]);
//
////                    
//                    //write flight number to the clock if not zero will sent to the gate2 to raf
//                    //1 arrival time assign
//                    raf.seek(0);
//                    raf.skipBytes((GATE_SIZE * 2)
//                            + ((DATE_SIZE * 2 + CLOCK_SIZE * 24) * (intArrConvertStrArrDateToInt[i] - 1))
//                            + (DATE_SIZE * 2) + (intArrFlightAssignArrivalTime[i] * CLOCK_SIZE));
//                    if (raf.readInt() == 0) {
//                        raf.seek(0);
//                        raf.skipBytes((GATE_SIZE * 2)
//                                + ((DATE_SIZE * 2 + CLOCK_SIZE * 24) * (intArrConvertStrDepDateToInt[i] - 1))
//                                + (DATE_SIZE * 2) + (intArrFlightAssignArrivalTime[i] * CLOCK_SIZE));
//                        raf.writeInt(intArrConvertStrNumberToInt[i]);
//                    } else {
//                        raf.seek(RECORD_SIZE);
//                        raf.skipBytes((GATE_SIZE * 2)
//                                + ((DATE_SIZE * 2 + CLOCK_SIZE * 24) * (intArrConvertStrDepDateToInt[i] - 1))
//                                + (DATE_SIZE * 2) + (intArrFlightAssignArrivalTime[i] * CLOCK_SIZE));
//                        raf.writeInt(intArrConvertStrNumberToInt[i]);
//                    }
//                    //2.departure time 
//                    raf.seek(0);
//                    raf.skipBytes((GATE_SIZE * 2)
//                            + ((DATE_SIZE * 2 + CLOCK_SIZE * 24) * (intArrConvertStrDepDateToInt[i] - 1))
//                            + (DATE_SIZE * 2) + (intArrFlightAssignDepartTime[i] * CLOCK_SIZE));
//                    if (raf.readInt() == 0) {
//                        raf.seek(0);
//                        raf.skipBytes((GATE_SIZE * 2)
//                                + ((DATE_SIZE * 2 + CLOCK_SIZE * 24) * (intArrConvertStrDepDateToInt[i] - 1))
//                                + (DATE_SIZE * 2) + (intArrFlightAssignDepartTime[i] * CLOCK_SIZE));
//                        raf.writeInt(intArrConvertStrNumberToInt[i]);
//                    } else {
//                        raf.seek(RECORD_SIZE);
//                        raf.skipBytes((GATE_SIZE * 2)
//                                + ((DATE_SIZE * 2 + CLOCK_SIZE * 24) * (intArrConvertStrDepDateToInt[i] - 1))
//                                + (DATE_SIZE * 2) + (intArrFlightAssignDepartTime[i] * CLOCK_SIZE));
//                        raf.writeInt(intArrConvertStrNumberToInt[i]);
//                    }
//
////                    //for test only ingnore later
////                    raf.seek(0);
////
////                    raf.skipBytes((GATE_SIZE * 2)
////                            + ((DATE_SIZE * 2 + CLOCK_SIZE * 24) * (intArrConvertStrDepDateToInt[i] - 1))
////                            + (DATE_SIZE * 2) + (intArrFlightAssignArrivalTime[i] * CLOCK_SIZE));
////                    System.out.println("This is raf" + raf.readInt());
////
////                    raf.seek(RECORD_SIZE);
////
////                    raf.skipBytes((GATE_SIZE * 2)
////                            + ((DATE_SIZE * 2 + CLOCK_SIZE * 24) * (intArrConvertStrDepDateToInt[i] - 1))
////                            + (DATE_SIZE * 2) + (intArrFlightAssignArrivalTime[i] * CLOCK_SIZE));
////                    System.out.println("This is raf" + raf.readInt());
//                }
//            } catch (FileNotFoundException ex) {
//                System.out.println(ex.toString());
//            }
//
//        } catch (IOException ex) {
//            System.out.println(ex.toString());
//        }
//
//    }
//
//    private void  BackHomePage() {
//
//        
//    }
//}
