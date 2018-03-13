public class ResponseObject {
    private String title;
    private String copyright;
    private String date;
    private String explanation;
    private String pictureUrl;

    public ResponseObject(String title, String copyright, String date, String explanation, String pictureUrl) {
        this.title = title;
        this.copyright = copyright;
        this.date = date;
        this.explanation = explanation;
        this.pictureUrl = pictureUrl;
    }

    public String getTitle() {
        return title;
    }

    public String getCopyright() {
        return copyright;
    }

    public String getDate() {
        return date;
    }

    public String getExplanation() {
        return explanation;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    @Override
    public String toString() {
        return title + "\n" + date + "\n" + explanation + "\n" + pictureUrl + "\n" + copyright;
    }
}
