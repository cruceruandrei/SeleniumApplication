package enums;

public enum UsersAndPasswords {

    VALID_EMAIL("testuser@gmail.com"),
    VALID_PASSWORD("TestTest1!"),
    INVALID_EMAIL("abcd@"),
    ALREADY_EXISTING_EMAIL("test@gmail.com"),
    EMPTY_PASSWORD(""),
    PASSWORD_LESS_THAN_10_CHARACTERS_LONG("Test1!"),
    PASSWORD_NO_LOWERCASE_LETTER("TESTTEST1!"),
    PASSWORD_NO_CAPITAL_LETTER("testtest1!"),
    PASSWORD_NO_NUMBER("TestTest!@"),
    PASSWORD_NO_SPECIAL_CHARACTER("TestTest12"),
    INVALID_VERIFICATION_CODE("123456"),
    INCORECT_PASSWORD("TestTest1!");

    String value;

    UsersAndPasswords(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}