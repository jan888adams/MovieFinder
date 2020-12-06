package model;

import codex.modell.ModelInterface;
import codex.utils.annotations.Settable;

import java.io.Serializable;

/**
 * VoiceAssistent
 *
 * @author Jan Adams
 * @version 01.12.2020
 */


public class User implements ModelInterface, Serializable {

    private String firstname;
    private String surname;
    private String email;
    private String password;

    public String getFirstname() {
        return firstname;
    }

    @Settable(order = 2)
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getSurname() {
        return surname;
    }

    @Settable(order = 3)
    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    @Settable(order = 1)
    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    @Settable(order = 4)
    public void setPassword(String password) {
        this.password = password;
    }
}

