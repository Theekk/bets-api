package com.betting.dice.excpetions;

public class DataNotFoundException extends RuntimeException{

    public DataNotFoundException(String msg) {super(msg);}

    public DataNotFoundException() {super("Data Object not found");}
}
