package com.github.danielhiguerasgoold.katabankocr.services;

import com.github.danielhiguerasgoold.katabankocr.exceptions.UnparseableFileException;

import java.util.ArrayList;
import java.util.List;

public class OCRDigitFile {
    private List<String> fileLines;

    public OCRDigitFile(List<String> fileLines) throws UnparseableFileException {
        this.fileLines = fileLines;
    }

    public List<String> getOCRDigitStringChunks() {
        List<String> ocrChunks = new ArrayList<>();
        for (int i = 0; i < fileLines.size(); i+= 4) {
            String[] firstStringChunks = fileLines.get(i+1).split("(?<=\\G...)");
            String[] secondStringChunks = fileLines.get(i+2).split("(?<=\\G...)");
            String[] thirdStringChunks = fileLines.get(i+3).split("(?<=\\G...)");

            for(int j = 0; j < firstStringChunks.length; j++) {
                String ocrChunk = firstStringChunks[j] + secondStringChunks[j] + thirdStringChunks[j];
                ocrChunks.add(ocrChunk);
            }
        }
        return ocrChunks;
    }

    private void validateFileBounds() throws UnparseableFileException {
        if (fileLines.size() % 4 != 0) {
            throw new UnparseableFileException();
        }

        for (int i = 0; i < fileLines.size(); i++) {
            checkLineBound(fileLines.get(i), i);
        }
    }

    private void checkLineBound(String line, Integer lineNumber) throws UnparseableFileException {
        System.out.println(line.length());
        if (lineNumber % 4 == 0) {
            if (line.trim().length() != 0) {
                throw new UnparseableFileException();
            }
        } else if (line.length() != 27) {
            throw new UnparseableFileException();
        }
    }
}
