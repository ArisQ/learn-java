package love.lipbcu.learnjava.p020_exceptionhandler;

public class CustomException extends RuntimeException {
    public CustomException() {
    }

    public CustomException(String str) {
        super(str);
    }

}
