public class IncorrectPhoneNumberException extends Exception {
    private String number;

    public IncorrectPhoneNumberException(String message, String number) {
        super(message);
        this.number = number;
    }

    public String getNumber() {
        return number;
    }
}
