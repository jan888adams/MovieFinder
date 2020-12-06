package view.forms;

import controller.login.AccessController;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.control.*;

import javafx.scene.layout.GridPane;

import javafx.scene.layout.HBox;
import javafx.scene.media.AudioClip;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;


/**
 * VoiceAssistent
 *
 * @author Jan Adams
 * @version 30.11.2020
 */

public class LoginForm extends Form {

    private AccessController controller;

    private Label headerLabel;
    private Label emailLabel;
    private TextField emailField;
    private Label passwordLabel;
    private PasswordField passwordField;
    private Button submitButton;
    private Button registerButton;
    private AudioClip voice;


    public LoginForm() {
        addComponents();
        setUp();
        addUIControls();
    }

    private void addComponents() {
        headerLabel = new Label("Login");
        emailLabel = new Label("Email: ");
        emailField = new TextField();
        passwordLabel = new Label("Passwort");
        passwordField =  new PasswordField();
        submitButton = new Button("Anmelden");
        registerButton = new Button("Registrieren");
        voice = new AudioClip(this.getClass().getResource("/loginVoice.wav").toExternalForm());
    }

    private void addUIControls() {
        headerLabel.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        this.add(headerLabel, 0, 0, 2, 1);
        GridPane.setHalignment(headerLabel, HPos.CENTER);
        this.add(emailLabel, 0, 3);
        emailField.setPrefHeight(25);
        this.add(emailField, 1, 3);
        emailField.setPrefHeight(25);
        passwordField.setPrefHeight(25);
        this.add(passwordLabel, 0, 4);
        this.add(passwordField, 1, 4);
        submitButton.setPrefHeight(25);
        submitButton.setDefaultButton(true);
        submitButton.setPrefWidth(100);

        HBox submitPain = new HBox();
        submitPain.setSpacing(10);
        submitPain.setAlignment(Pos.CENTER);

        submitPain.getChildren().add(submitButton);

        GridPane.setHalignment(submitButton, HPos.RIGHT);

        registerButton.setPrefHeight(25);
        registerButton.setDefaultButton(true);
        submitPain.getChildren().add(registerButton);
        registerButton.setPrefWidth(100);
        this.add(submitPain, 0, 5, 3, 2);

    }



    public Button getRegisterButton() {
        return registerButton;
    }

    public String getEmailInput() {
        return emailField.getText();
    }

    public String getPasswordInput() {
        return passwordField.getText();
    }

    public Button getSubmitButton() {
        return submitButton;
    }

    public AudioClip getVoice() {
        return voice;
    }
}
