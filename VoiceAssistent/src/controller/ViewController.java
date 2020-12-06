package controller;

import controller.login.LoginController;
import controller.application.ApplicationController;
import controller.register.RegisterController;

import javafx.application.Platform;
import view.forms.LoginForm;
import view.forms.RegisterForm;
import javafx.scene.Scene;
import javafx.stage.Stage;
import view.movie_view.MovieView;

import java.net.ConnectException;


/**
 * VoiceAssistent
 *
 * @author Jan Adams
 * @version 01.12.2020
 */

public class ViewController {
    private Stage stage;
    private Scene scene;

    private LoginForm loginForm;
    private RegisterForm registerForm;
    private MovieView movieView;
    private ApplicationController applicationController;

    public ViewController(Stage stage) throws ConnectException {
        stage.setFullScreen(true);
        setUp(stage);
        eventHandel();
        stage.setScene(scene);
        stage.show();
    }

    private void setUp(Stage primaryStage) throws ConnectException {
        stage = primaryStage;
        loginForm = new LoginForm();
        registerForm = new RegisterForm();
        movieView = new MovieView();
        scene = new Scene(loginForm);
        applicationController = new ApplicationController(scene);
    }


    public void eventHandel() {

        loginForm.getSubmitButton().setOnAction(event -> new LoginController(scene).loginHandel(loginForm, movieView));

        loginForm.getRegisterButton().setOnAction(event -> scene.setRoot(registerForm));

        registerForm.getToLoginButton().setOnAction(event -> scene.setRoot(loginForm));

        registerForm.getSubmitButton().setOnAction(actionEvent -> new RegisterController(registerForm).registrationHandel());

        movieView.getSearchButton().setOnAction(actionEvent -> applicationController.handelRequest(movieView));

        movieView.getSaveButton().setOnAction(actionEvent -> applicationController.saveRequest(movieView));

        movieView.getCloseButton().setOnAction(actionEvent -> Platform.exit());

    }
}
