package br.com.brasilprev.brasilprevteste.exceptions;

import java.util.Date;

public class ExceptionResponse {
    private String message;
    private String status;

    public ExceptionResponse( String message, String status) {
        super();
        this.message = message;
        this.status=status;
    }

    public String getMessage() {
        return message;
    }

    public String getStatus() {
        return status;
    }
}
