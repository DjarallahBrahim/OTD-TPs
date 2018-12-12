package fr.ulille1.fil.odeva;

public class ValueException extends Exception {
    ValueException(int v1, int v2)
    {
        super("v2: "+v2+" is greater then " + v1);
    }
}

