public class IncorrectEmailException extends Exception{
    private String parmeter;

    public IncorrectEmailException(String message, String email) {
        super(message);
        this.parmeter = email;
    }

    public String getParmeter() {
        return parmeter;
    }
}
