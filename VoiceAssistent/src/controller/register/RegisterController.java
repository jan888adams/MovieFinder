package controller.register;

import codex.utils.input.InputHandler;
import controller.modell.UserController;
import javafx.scene.control.Alert;
import view.forms.RegisterForm;

import java.lang.reflect.InvocationTargetException;
import java.net.ConnectException;
import java.sql.SQLDataException;

/**
 * VoiceAssistent
 *
 * @author Jan Adams
 * @version 01.12.2020
 */

public class RegisterController {
    private final RegisterForm registerForm;

    public RegisterController(RegisterForm registerForm) {
        this.registerForm = registerForm;
    }

    public void registrationHandel() {

        if (registerForm.getNameInput().isEmpty() | registerForm.getSurnameInput().isEmpty() |
                registerForm.getPasswordInput().isEmpty() | registerForm.getEmailInput().isEmpty()) {

            registerForm.showAlert(
                    Alert.AlertType.ERROR, registerForm.getScene().getWindow(),
                    "Registrierungsfehler", "Bitte befüllen Sie das Formular");
            return;
        }

        save();

        registerForm.showAlert(
                Alert.AlertType.CONFIRMATION, registerForm.getScene().getWindow(),
                "Registrierung", "Sie konnten sich erfolgreich registrieren");

        registerForm.getVoice().play();
    }

    private void save() {

        UserController controller = null;
        try {
            controller = new UserController();
        } catch (ConnectException e) {
            registerForm.showAlert(
                    Alert.AlertType.ERROR,
                    registerForm.getScene().getWindow(),
                    "Verbindungsfehler", "Es konnte keine Verbindung zu Datenbank hergestellt werden");
        }
        InputHandler inputHandler = new InputHandler();

        inputHandler.save(registerForm.getEmailInput());
        inputHandler.save(registerForm.getNameInput());
        inputHandler.save(registerForm.getSurnameInput());
        inputHandler.save(registerForm.getPasswordInput());

        try {

            if (controller != null) {
                controller.apply(inputHandler.getInputs());
                controller.persist();
            }

        } catch (IllegalAccessException | InvocationTargetException |
                NoSuchMethodException | ConnectException | SQLDataException e) {
            registerForm.showAlert(Alert.AlertType.ERROR, registerForm.getScene().getWindow(), "Fehler", e.getMessage());
        }
    }


}
