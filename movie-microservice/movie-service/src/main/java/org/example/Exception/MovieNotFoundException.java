package org.example.Exception;

public class MovieNotFoundException extends RuntimeException{

    private String uri;

    public MovieNotFoundException(String format, String uri) {
        super(format);
        this.uri = uri;
    }

    public String getUri() {
        return uri;
    }

}
