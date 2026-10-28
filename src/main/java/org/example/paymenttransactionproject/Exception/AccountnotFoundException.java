package org.example.paymenttransactionproject.Exception;

public class AccountnotFoundException extends RuntimeException{

    public AccountnotFoundException(String message){
        super(message);
    }
}
