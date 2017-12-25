package ua.nure.garmash.Practice8.ExceptionHandlers;

public class DBException extends RuntimeException {

    public DBException(String message, Throwable cause) {
        super(message, cause);
    }
}
