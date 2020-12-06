package controller.login;

import codex.utils.exception.ModelNotFoundException;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import view.forms.LoginForm;
import view.movie_view.MovieView;


import java.net.ConnectException;
import java.sql.SQLDataException;

/**
 * VoiceAssistent
 *
 * @author Jan Adams
 * @version 02.12.2020
 */

public class LoginController {
    private final Scene scene;

    public LoginController(Scene scene){
        this.scene = scene;
    }

    public void loginHandel(LoginForm loginForm, MovieView accessPane){
        try {
            AccessController controller = new AccessController();

            if (!controller.isRegistered(loginForm.getEmailInput(), loginForm.getPasswordInput())) {
                loginForm.showAlert(Alert.AlertType.ERROR, loginForm.getScene().getWindow(),
                        "login fail", "The email and password combination is not correct");
                return;
            }

            loginForm.getVoice().play();
            scene.setRoot(accessPane);

        } catch (ConnectException | ModelNotFoundException | SQLDataException e) {
            loginForm.showAlert(
                    Alert.AlertType.ERROR, loginForm.getScene().getWindow(),
                    "Connection Error", "connection fails");
        }
    }
}
