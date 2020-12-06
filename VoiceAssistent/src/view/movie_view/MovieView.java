package view.movie_view;

import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Window;
import model.Movie;
import view.movie_view.body.ImageSection;
import view.movie_view.body.InfoSection;
import view.movie_view.header.MovieSearchBar;


/**
 * VoiceAssistent
 *
 * @author Jan Adams
 * @version 01.12.2020
 */

public class MovieView extends BorderPane {
    private final MovieSearchBar header;
    private InfoSection body;
    private ImageSection imagesection;

    public MovieView() {
        body = new InfoSection();
        header = new MovieSearchBar();
        this.setTop(header);

    }

    public String getSearchFieldInput() {
        return header.getSearchFieldInput();
    }

    public Button getSearchButton() {
        return header.getSubmitButton();
    }

    public Button getSaveButton() {
        return body.getSaveButton();
    }

    public Button getCloseButton(){
        return body.getCloseButton();
    }

    public void setBody(Movie movie) {
        body.setTitle(movie.getTitle());
        body.setDirector(movie.getDirector());
        body.setPlot(movie.getPlot());
        this.setCenter(body);
        imagesection = new ImageSection(movie.getPoster());
        this.setLeft(imagesection);

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
