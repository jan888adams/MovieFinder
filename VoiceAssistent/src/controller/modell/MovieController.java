package controller.modell;


import codex.controller.Controller;
import model.Movie;
import repository.MovieRepository;

import java.net.ConnectException;

/**
 * VoiceAssistent
 *
 * @author Jan Adams
 * @version 01.12.2020
 */

public class MovieController extends Controller {

    public MovieController() throws ConnectException {
        setModel(new Movie());
        addRepository(new MovieRepository());
    }
}
