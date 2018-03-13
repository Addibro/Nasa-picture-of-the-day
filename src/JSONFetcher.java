package src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.stream.Collectors;

public class JSONFetcher {

    private static final String API_KEY = "api_key=N2CbTmIdMiEJT1a1Mcwq193NrnSbovv4C0kKKBPG";
    private static final String BASE_URL = "https://api.nasa.gov/planetary/apod";

    public static String getJson(String query) {
        StringBuilder json = new StringBuilder();
        URL url;
        try {
            if (query.equals("")){
                url = new URL(BASE_URL + "?" + API_KEY);
            } else {
                url = new URL(BASE_URL + "?" + API_KEY + "&" + query);
            }
            // check http
            if (!isHttpOk(url)) {
                // return empty string
                return "{}";
            }

            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));

            for (String line : reader.lines().collect(Collectors.toList())) {
                json.append(line);
            }
            reader.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        return json.toString();
    }

    private static boolean isHttpOk(URL url) throws IOException {
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-Type", "application/json");
        conn.connect();
        int code = conn.getResponseCode();
        System.out.println((code != 200) ? "Something went wrong: " + code : "Success!");
        return code == 200;
    }
}
