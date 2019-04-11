package com.company.Exceptions;

public class NoComputingException extends Exception {

    int n;

    NoComputingException (int i) {
    n = i;
    }

    public String toString ()
        {
            return "Не произведено никаких операций! "  + n ;
        }
    }