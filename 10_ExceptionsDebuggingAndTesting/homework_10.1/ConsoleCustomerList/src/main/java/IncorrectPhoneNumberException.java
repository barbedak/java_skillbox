public class IncorrectPhoneNumberException extends Exception{
    private String number;

    public IncorrectPhoneNumberException(String message, String phone) {
        super(message);
        this.number = phone;
    }

    public String getNumber() {
        return number;
    }
}
