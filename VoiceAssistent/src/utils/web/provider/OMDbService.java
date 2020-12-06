package utils.web.provider;

import org.json.JSONObject;
import utils.web.WebService;

import java.io.IOException;

/**
 * VoiceAssistent
 *
 * @author Jan Adams
 * @version 02.12.2020
 */

public class OMDbService {
    private final String key;
    private final String url;


    public OMDbService() {
        key = "apikey=bad7e389&t=";
        url = "http://www.omdbapi.com/?";
    }

    public JSONObject search(String film) throws IOException {
        film = film.replace(" ", "+");
        String jsonString = WebService.getJSONFromURL(url + key + film);
        return new JSONObject(jsonString);
    }

}
