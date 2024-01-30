package org.acme.exceptions.runtime.exceptions;

/**
 * Exceção negocial
 */
public class BusinessException extends Exception{

    public BusinessException(String message){   
        super(message);
    }
    
}
