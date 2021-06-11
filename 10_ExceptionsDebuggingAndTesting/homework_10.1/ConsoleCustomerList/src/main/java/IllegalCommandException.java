public class IllegalCommandException extends Exception{
    private String command;

    public IllegalCommandException(String message, String command) {
        super(message);
        this.command = command;
    }

    public String getCommand() {
        return command;
    }
}
