package controller.modell;

import codex.controller.Controller;
import model.User;
import repository.UserRepository;

import java.net.ConnectException;

/**
 * VoiceAssistent
 *
 * @author Jan Adams
 * @version 01.12.2020
 */


public class UserController extends Controller {

    public UserController() throws ConnectException {
        setModel(new User());
        addRepository(new UserRepository());
    }
}
