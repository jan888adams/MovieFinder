package repository;

import codex.database.DatabaseEngine;
import codex.modell.ModelInterface;
import codex.repository.RepositoryInterface;

import codex.utils.exception.ModelNotFoundException;
import codex.utils.sql.SqlStatement;
import model.Movie;


import java.net.ConnectException;
import java.sql.SQLDataException;
import java.util.List;

/**
 * VoiceAssistent
 *
 * @author Jan Adams
 * @version 02.12.2020
 */

public class MovieRepository implements RepositoryInterface {
    private final DatabaseEngine databaseEngine;
    private final String table;

    public MovieRepository() throws ConnectException {
        databaseEngine = new DatabaseEngine();
        table = "movie";
    }

    public Movie castToMovie(ModelInterface modelToParse) {
        Movie movie;
        try {
            movie = (Movie) modelToParse;
        } catch (ClassCastException e) {
            throw new ClassCastException("You have tried to create a NON-Person object with PersonRepository");
        }
        return movie;
    }

    @Override
    public ModelInterface create(ModelInterface modelToSave) throws SQLDataException, ConnectException {
        Movie model = castToMovie(modelToSave);
        String statement = new SqlStatement(table).insertInto(model.getDirector(), model.getTitle(),
                model.getPlot(), model.getPoster());

        return databaseEngine.executeSQL(new String[]{statement}) ? model : null;
    }


    @Override
    public ModelInterface update(ModelInterface modelInterface) throws SQLDataException, ConnectException {
        return null;
    }

    @Override
    public ModelInterface delete(ModelInterface modelInterface) throws SQLDataException, ConnectException {
        return null;
    }

    @Override
    public List<ModelInterface> findByModel(ModelInterface modelInterface) throws SQLDataException, ConnectException, ModelNotFoundException {
        return null;
    }

    @Override
    public ModelInterface findByKey(String s) throws SQLDataException, ConnectException, ModelNotFoundException {
        return null;
    }
}
