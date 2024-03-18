package configuration.enums;

public enum GenericProperties {

    URL_ADDRESS("url.address"),
    BROWSER("execution.browser");

    String name;

    GenericProperties(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}