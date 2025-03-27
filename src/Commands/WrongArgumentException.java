package Commands;

public class WrongArgumentException extends RuntimeException {
    public WrongArgumentException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return "Wrong arguments";
    }
}
