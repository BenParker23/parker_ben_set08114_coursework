package com.ben.error;

/**
 * @author Ben Parker
 * @created 6/2/2018
 * @usage   Used when throwing custom exceptions within
 * the running app
 */

public class SalesAppException extends RuntimeException {

    public SalesAppException(String message){
        super(message);
    }
}
