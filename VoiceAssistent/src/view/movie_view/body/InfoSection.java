package view.movie_view.body;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;



/**
 * VoiceAssistent
 *
 * @author Jan Adams
 * @version 01.12.2020
 */

public class InfoSection extends GridPane {
    private Label titleLabel;
    private Label directorLabel;
    private Label plotLabel;
    private Text title;
    private Text director;
    private Text plot;
    private final Button saveButton;
    private final Button closeButton;

    public InfoSection() {
        saveButton = new Button("save");
        closeButton = new Button("close");
        setLabels();
        setUp();
    }

    private void setUp() {
        this.setAlignment(Pos.CENTER_LEFT);
        this.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
        titleLabel.setFont(Font.font("Arial", FontWeight.BOLD, 12));
        this.add(titleLabel,0,0);
        directorLabel.setFont(Font.font("Arial", FontWeight.BOLD, 12));
        this.add(directorLabel, 0, 3);
        plotLabel.setFont(Font.font("Arial", FontWeight.BOLD, 12));
        this.add(plotLabel,0,5);
        saveButton.setDefaultButton(true);
        saveButton.setMinWidth(200);
        GridPane.setMargin(saveButton, new Insets(50, 0,50,0));
        this.add(saveButton,0,7);
        closeButton.setCancelButton(true);
        closeButton.setMinWidth(200);
        GridPane.setMargin(saveButton, new Insets(50, 0,50,0));
        this.add(closeButton,2,8);

    }

    public Button getSaveButton() {
        return saveButton;
    }

    public void setPlot(String plot) {
        this.plot = new Text(plot);
        this.add(this.plot, 0, 6);
    }

    public void setLabels() {
        titleLabel = new Label("Title:");
        directorLabel = new Label("Regisseur:");
        plotLabel = new Label("Plot");
    }


    public void setTitle(String title) {
        this.title = new Text(title);
        this.add(this.title, 0, 1);
    }

    public void setDirector(String director) {
        this.director = new Text(director);
        this.add(this.director, 0, 4);
    }

    public Button getCloseButton() {
        return closeButton;
    }
}
