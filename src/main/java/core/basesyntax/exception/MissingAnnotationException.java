package core.basesyntax.exception;

public class MissingAnnotationException extends RuntimeException {
    public MissingAnnotationException(String message) {
        super(message);
    }
}