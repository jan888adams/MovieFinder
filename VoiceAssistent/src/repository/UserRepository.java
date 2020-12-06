package repository;

import codex.database.DatabaseEngine;
import codex.modell.ModelInterface;
import codex.repository.RepositoryInterface;
import codex.utils.exception.ModelNotFoundException;
import codex.utils.sql.SqlStatement;
import model.User;


import java.net.ConnectException;
import java.sql.ResultSet;
import java.sql.SQLDataException;
import java.sql.SQLException;
import java.util.List;


/**
 * Login
 *
 * @author Jan Adams
 * @version 28.11.2020
 */

public class UserRepository implements RepositoryInterface {
    private final DatabaseEngine databaseEngine;
    private final String table;

    public UserRepository() throws ConnectException {
        this.table = "user";
        databaseEngine = new DatabaseEngine();
    }

    public User castToUser(ModelInterface modelToParse) {
        User user;
        try {
            user = (User) modelToParse;
        } catch (ClassCastException e) {
            throw new ClassCastException("You have tried to create a NON-Person object with PersonRepository");
        }
        return user;
    }

    @Override
    public ModelInterface create(ModelInterface modelToSave) throws SQLDataException, ConnectException {
        User model = castToUser(modelToSave);
        String statement = new SqlStatement(table).insertInto(model.getEmail(), model.getFirstname(),
                model.getSurname(), model.getPassword());

        return databaseEngine.executeSQL(new String[]{statement}) ? model : null;
    }

    @Override
    public ModelInterface update(ModelInterface modelToSave) throws SQLDataException, ConnectException {
        return null;
    }

    @Override
    public ModelInterface delete(ModelInterface modelToDelete) throws SQLDataException, ConnectException {
        return null;
    }

    @Override
    public List<ModelInterface> findByModel(ModelInterface modelToSave) throws SQLDataException, ConnectException, ModelNotFoundException {
        return null;
    }

    @Override
    public ModelInterface findByKey(String key) throws SQLDataException, ConnectException, ModelNotFoundException {

        ResultSet results = databaseEngine.executeSQL(new SqlStatement(table).selectAll("email", key));
        User model = new User();

        try {
            while (results.next()) {
                model.setEmail(results.getString("email"));
                model.setFirstname(results.getString("firstname"));
                model.setSurname(results.getString("surname"));
                model.setPassword(results.getString("password"));
            }
        } catch (SQLException e) {
           // throw new ModelNotFoundException("Can not find a model whit this key = " + key);
            e.printStackTrace();
        }
        return model;
    }
}

