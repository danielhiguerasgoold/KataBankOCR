package com.github.danielhiguerasgoold.katabankocr.models;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class FileLines {
    private final String fileName;

    public FileLines(String fileName) {
        this.fileName = fileName;
    }

    public List<String> asList() throws URISyntaxException, IOException {
        return Files.readAllLines(Paths.get(getFileURI()));
    }

    private URI getFileURI() throws URISyntaxException {
        return this.getClass().getClassLoader().getResource(fileName).toURI();
    }
}
