package view.movie_view.header;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

/**
 * VoiceAssistent
 *
 * @author Jan Adams
 * @version 01.12.2020
 */

public class MovieSearchBar extends GridPane {
    private final Label headerLabel;
    private final TextField searchField;
    private final Button submitButton;

    public MovieSearchBar() {
        headerLabel = new Label("look for you favorite movies");
        searchField = new TextField();
        submitButton = new Button("search");
        setUp();
        addUIControls();
    }

    public void setUp(){
        this.setAlignment(Pos.CENTER);
        this.setPadding(new Insets(50, 50, 50, 50));
        this.setVgap(40);
        this.setBackground(new Background(new BackgroundFill(Color.GHOSTWHITE, CornerRadii.EMPTY, Insets.EMPTY)));
        ColumnConstraints columnOneConstraints = new ColumnConstraints(100, 100, Double.MAX_VALUE);
        columnOneConstraints.setHalignment(HPos.RIGHT);
        ColumnConstraints columnTwoConstrains = new ColumnConstraints(100, 100, Double.MAX_VALUE);
        columnTwoConstrains.setHgrow(Priority.ALWAYS);
        this.getColumnConstraints().addAll(columnOneConstraints, columnTwoConstrains);
    }

    public void addUIControls(){
        headerLabel.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        this.add(headerLabel, 0,0,2,1);
        GridPane.setHalignment(headerLabel, HPos.CENTER);
        GridPane.setMargin(headerLabel, new Insets(20, 0,20,0));
        this.add(searchField, 0,0,2,4);
        searchField.setMaxWidth(800);
        GridPane.setHalignment(searchField,
                HPos.CENTER);
        GridPane.setMargin(searchField, new Insets(50, 0,50,0));
        submitButton.setDefaultButton(true);
        this.add(submitButton,0, 0,3,6);
        submitButton.setPrefWidth(200);
        GridPane.setHalignment(submitButton, HPos.CENTER);
        GridPane.setMargin(submitButton, new Insets(50, 0,50,0));
    }

    public String getSearchFieldInput(){
        return searchField.getText();
    }

    public Button getSubmitButton() {
        return submitButton;
    }
}
