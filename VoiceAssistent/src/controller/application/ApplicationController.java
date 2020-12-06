package controller.application;

import codex.utils.input.InputHandler;
import controller.modell.MovieController;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import model.Movie;
import org.json.JSONException;
import org.json.JSONObject;
import utils.web.provider.OMDbService;
import view.movie_view.MovieView;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.ConnectException;
import java.sql.SQLDataException;

/**
 * VoiceAssistent
 *
 * @author Jan Adams
 * @version 02.12.2020
 */

public class ApplicationController {
    private final MovieController movieController;
    private final OMDbService service;
    private final Scene scene;


    public ApplicationController(Scene scene) throws ConnectException {
        this.scene = scene;
        movieController = new MovieController();
        service = new OMDbService();
    }

    public void handelRequest(MovieView movieView) {
        try {
            setRequest(service.search(movieView.getSearchFieldInput()));
            movieView.setBody((Movie) movieController.getModel());
            scene.setRoot(movieView);
        } catch (IOException | JSONException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            movieView.showAlert(Alert.AlertType.ERROR, movieView.getScene().getWindow(),
                    "no results", "No movies could be found");
        }
    }

    private void setRequest(JSONObject request) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        InputHandler inputhandler = new InputHandler();
        inputhandler.save(request.getString("Director"));
        inputhandler.save(request.getString("Title"));
        inputhandler.save(request.getString("Plot"));
        inputhandler.save(request.getString("Poster"));
        movieController.apply(inputhandler.getInputs());
    }

    public void saveRequest(MovieView movieView){
        try {
            movieController.persist();
            movieView.showAlert(Alert.AlertType.CONFIRMATION, movieView.getScene().getWindow(),
                    "movie", "you have save the movie");
        } catch (SQLDataException | ConnectException e) {
            movieView.showAlert(Alert.AlertType.ERROR, movieView.getScene().getWindow(),
                    "no results", "No movies could be found");
        }

    }

}
