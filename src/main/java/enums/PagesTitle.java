package enums;

public enum PagesTitle {

    LIDL_ONLINESHOP("LIDL lohnt sich » Top-Angebote im Onlineshop & in der Filiale");

    String title;

    PagesTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}