package controller.login;

import codex.controller.Controller;
import codex.utils.exception.ModelNotFoundException;
import controller.modell.UserController;
import model.User;


import java.net.ConnectException;
import java.sql.SQLDataException;

/**
 * VoiceAssistent
 *
 * @author Jan Adams
 * @version 01.12.2020
 */

public class AccessController extends Controller {

   private final UserController controller;

    public AccessController() throws ConnectException {
        this.controller = new UserController();
    }

    public boolean isRegistered(String email, String password) throws ConnectException, ModelNotFoundException, SQLDataException {
        User userData = (User) controller.getDataSets(email).get(0);
        if(userData.getPassword() == null ){
            return false;
        }
     return userData.getPassword().equals(password);
    }


}
