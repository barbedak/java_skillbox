public class IncorrectEmailException extends Exception {
    private String email;

    public IncorrectEmailException(String message, String email) {
        super(message);
        this.email = email;
    }

    public String getEmail() {
        return email;
    }
}
