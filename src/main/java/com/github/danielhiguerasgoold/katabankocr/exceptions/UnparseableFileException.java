package com.github.danielhiguerasgoold.katabankocr.exceptions;

public class UnparseableFileException extends Exception {
    public UnparseableFileException() {
        super("The file contains an unparseable format.");
    }
}
