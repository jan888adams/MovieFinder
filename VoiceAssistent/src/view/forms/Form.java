package view.forms;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Window;

/**
 * VoiceAssistent
 *
 * @author Jan Adams
 * @version 01.12.2020
 */

public abstract class Form extends GridPane {

    protected void setUp() {

        this.setAlignment(Pos.CENTER);
        this.setPadding(new Insets(50, 50, 50, 50));
        this.setHgap(20);
        this.setVgap(20);
        this.setBackground(new Background(new BackgroundFill(Color.GHOSTWHITE, CornerRadii.EMPTY, Insets.EMPTY)));
        ColumnConstraints columnOneConstraints = new ColumnConstraints(100, 100, Double.MAX_VALUE);
        columnOneConstraints.setHalignment(HPos.RIGHT);
        ColumnConstraints columnTwoConstrains = new ColumnConstraints(200, 200, Double.MAX_VALUE);
        columnTwoConstrains.setHgrow(Priority.ALWAYS);
        this.getColumnConstraints().addAll(columnOneConstraints, columnTwoConstrains);
    }

    public void showAlert(Alert.AlertType alertType, Window owner, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.initOwner(owner);
        alert.show();
    }
}
