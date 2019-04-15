
package Airport;

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
 * @author paulbonenfant
 */
public final class GateAssigner extends Stage{
    
    
    public GateAssigner() {
        
        // here is the gate assigner stage when user in the create flight stage 
        // click gate assign button will bump out this stage
        
        VBox root = new VBox(10);
        
        Label lblGateAssign = new Label("Gate Assign");
        
        
        
        root.setAlignment(Pos.CENTER);
        root.getChildren().addAll(lblGateAssign);
        
        setScene(new Scene(root));
        
        setTitle("Enter New Title Info");
    }

    
}
