package src;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class Main {

    public static void main(String[] args) {
        String query = "";
        if (args.length == 1) {
            query = args[0];
        }
        String jsonString = JSONFetcher.getJson(query);
        ResponseObject response = JSONParser.parse(jsonString);
        if (Desktop.isDesktopSupported()) {
            try {
                Desktop.getDesktop().browse(new URI(response.getPictureUrl()));
            } catch (URISyntaxException | IOException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}
