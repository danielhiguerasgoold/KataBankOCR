package com.github.danielhiguerasgoold.katabankocr;

import com.github.danielhiguerasgoold.katabankocr.exceptions.UnparseableFileException;
import com.github.danielhiguerasgoold.katabankocr.models.*;
import com.github.danielhiguerasgoold.katabankocr.services.OCRDigitFile;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String args[]) throws IOException, URISyntaxException, UnparseableFileException {
        FileLines fileLines = new FileLines("print.txt");
        List<OCRDigit> ocrDigits = Arrays.asList(new OneOCRDigit(), new TwoOCRDigit(), new ThreeOCRDigit(), new FourOCRDigit(),
                new FiveOCRDigit(), new SixOCRDigit(), new SevenOCRDigit(), new EightOCRDigit(), new NineOCRDigit(), new ZeroOCRDigit());
        OCRDigitFile ocrDigitFile = new OCRDigitFile(fileLines.asList());
        List<String> ocrStringDigits = ocrDigitFile.getOCRDigitStringChunks();
        System.out.println(new OneOCRDigit().matches("     |  |"));
        for(String s : ocrStringDigits) {
            ocrDigits.stream().filter(ocrDigit -> ocrDigit.matches(s)).forEach(ocrDigit -> {
                System.out.print(ocrDigit.getValue());
            });
        }
    }
}
