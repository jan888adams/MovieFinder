package utils.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * VoiceAssistent
 *
 * @author Jan Adams
 * @version 01.12.2020
 */

public class WebService {

    private static String readResponse(HttpURLConnection con) throws IOException {
        InputStream inputStream = con.getInputStream();
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            String row;
            while ((row = reader.readLine()) != null) {
                stringBuilder.append(row);
            }
        }
        return stringBuilder.toString();
    }

    public static String getJSONFromURL(String urlString) throws MalformedURLException, IOException {
        URL url = new URL(urlString);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        return readResponse(con);
    }
}
