package enums;

public enum WebElementsText {

    ALREADY_EXISTING_EMAIL("Diese E-Mail-Adresse ist bereits in einem anderen Konto hinterlegt"),
    INVALID_EMAIL("Ungültige E-Mail-Adresse"),
    PASSWORD_AT_LEAST_10_CHARACTERS_LONG("Mindestens 10 Zeichen lang"),
    PASSWORD_AT_LEAST_1_LOWERCASE_LETTER("Mindestens 1 Kleinbuchstabe"),
    PASSWORD_AT_LEAST_1_CAPITAL_LETTER("Mindestens 1 Großbuchstabe"),
    PASSWORD_AT_LEAST_1_NUMBER("Mindestens 1 Zahl"),
    PASSWORD_AT_LEAST_1_SPECIAL_CHARACTER("Mindestens 1 Sonderzeichen"),
    ERROR_INVALID_VERIFICATION_CODE("Bitte überprüfen Sie den 6-stelligen Code, den Sie per E-Mail erhalten haben, da der eingegebene Code ungültig ist."),
    ERROR_WRONG_PASSWORD("Falsches Passwort. Versuche es erneut oder tippe auf \"Passwort vergessen\", um es zu ändern."),
    ERROR_WRONG_PASSWORD_THREE_TIMES("Aus Sicherheitsgründen musst du nach 3 fehlgeschlagenen Anmeldeversuchen 30 Minuten warten, bevor du es erneut versuchen kannst.");

    String webElementText;

    WebElementsText(String webElementText) {
        this.webElementText = webElementText;
    }

    public String getWebElementsText() {
        return webElementText;
    }
}