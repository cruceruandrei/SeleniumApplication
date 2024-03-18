package driver.enums;

public enum BrowserTypes {

    CHROME("chromedriver.exe");

    String name;

    BrowserTypes(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}