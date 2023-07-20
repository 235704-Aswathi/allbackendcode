package org.example.Exception;

public class InvalidMovieDataException extends RuntimeException {
    public InvalidMovieDataException(String s) {
        super(s);
    }

}
