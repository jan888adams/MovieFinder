package view.forms;

import javafx.geometry.HPos;
import javafx.geometry.Insets;

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
 * @version 01.12.2020
 */

public class RegisterForm extends Form {
    private final Label headerLabel;
    private final Label nameLabel;
    private final TextField nameField;
    private final Label surnameLabel;
    private final TextField surnameField;
    private final Label emailLabel;
    private final TextField emailField;
    private final Label passwordLabel;
    private final PasswordField passwordField;
    private final Button submitButton;
    private final Button toLoginButton;
    private final AudioClip voice;

    public RegisterForm() {
        headerLabel = new Label("Registrieren Sie sich:");
        nameLabel = new Label("firstname:");
        nameField = new TextField();
        surnameLabel = new Label("surname:");
        surnameField = new TextField();
        emailLabel = new Label("email:");
        emailField = new TextField();
        passwordLabel = new Label("Password:");
        passwordField = new PasswordField();
        submitButton = new Button("register");
        toLoginButton = new Button("back");
        voice = new AudioClip(this.getClass().getResource("/registerVoice.wav").toExternalForm());
        setUp();
        addUIControls();
    }

    private void addUIControls() {

        headerLabel.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        this.add(headerLabel, 0, 0, 2, 1);
        GridPane.setHalignment(headerLabel, HPos.CENTER);
        GridPane.setMargin(headerLabel, new Insets(20, 0, 20, 0));
        this.add(nameLabel, 0, 1);
        nameField.setPrefHeight(25);
        this.add(nameField, 1, 1);
        this.add(surnameLabel, 0, 2);
        surnameField.setPrefHeight(25);
        this.add(surnameField, 1, 2);
        this.add(emailLabel, 0, 3);
        emailField.setPrefHeight(25);
        this.add(emailField, 1, 3);
        this.add(passwordLabel, 0, 4);
        passwordField.setPrefHeight(25);
        this.add(passwordField, 1, 4);

        HBox submitPain = new HBox();
        submitPain.setSpacing(10);
        submitPain.setAlignment(Pos.CENTER);
        submitButton.setPrefHeight(25);
        submitButton.setDefaultButton(true);
        submitButton.setPrefWidth(100);
        submitPain.getChildren().add(submitButton);
        toLoginButton.setPrefHeight(25);
        toLoginButton.setDefaultButton(true);
        toLoginButton.setPrefWidth(100);

        submitPain.getChildren().add(toLoginButton);

        this.add(submitPain, 0, 5, 3, 2);
        GridPane.setHalignment(toLoginButton, HPos.RIGHT);
        GridPane.setMargin(toLoginButton, new Insets(10, 0, 10, 0));

    }


    public String getNameInput() {
        return nameField.getText();
    }

    public String getSurnameInput() {
        return surnameField.getText();
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

    public Button getToLoginButton() {
        return toLoginButton;
    }

    public AudioClip getVoice() {
        return voice;
    }
}
