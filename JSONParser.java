import org.json.*;

public class JSONParser {
    public static ResponseObject parse(String json) {
        try {
            JSONObject outer = new JSONObject(json);
            String title = outer.getString("title");
            String copyright = "None given";
            if (outer.has("copyright")) {
                copyright = outer.getString("copyright");
            }
            String date = outer.getString("date");
            String explanation = outer.getString("explanation");
            String pictureUrl = outer.getString("url");
            return new ResponseObject(title, copyright, date, explanation, pictureUrl);
        } catch (JSONException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }
}
