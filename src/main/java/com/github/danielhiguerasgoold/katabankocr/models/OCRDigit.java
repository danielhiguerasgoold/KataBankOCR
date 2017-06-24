package com.github.danielhiguerasgoold.katabankocr.models;

public abstract class OCRDigit {
    private final String representation;
    private final Integer value;

    public OCRDigit(String representation, Integer value) {
        this.representation = representation;
        this.value = value;
    }

    public Boolean matches(String representation) {
        return this.representation.equals(representation);
    }

    public Integer getValue() {
        return value;
    }
}
