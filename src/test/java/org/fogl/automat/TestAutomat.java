package org.fogl.automat;

import org.fogl.reader.Reader;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.fogl.reader.Reader.readAndCheckTheInputAndPrintTheResult;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestAutomat {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }


    @Test
    void testNullInput() {
        readAndCheckTheInputAndPrintTheResult(null);
        String output = outContent.toString().trim();
        assertTrue(output.contains("[ERROR] No input provided!"));
    }

    @Test
    void testEmptyInput() {
        readAndCheckTheInputAndPrintTheResult("   ");
        String output = outContent.toString().trim();
        assertTrue(output.contains("[ERROR] No input provided!"));
    }

    @Test
    void testValidInput() {
        String input = "322/(22*7*44)=81";
        readAndCheckTheInputAndPrintTheResult(input);
        String output = outContent.toString().trim();
        assertTrue(output.contains("[SUCCESS]"));
    }

    @Test
    void testInvalidInput() {
        String input = "322/22*7*44)=81";
        readAndCheckTheInputAndPrintTheResult(input);
        String output = outContent.toString().trim();
        assertTrue(output.contains("[ERROR]") && output.contains("NOT syntactically correct"));
    }

    @Test
    void testInvalidFileName() {
        String filepath = "src/test/resources/testfile.csv";
        Reader.readFromFile(filepath);
        String output = outContent.toString().trim();
        assertTrue(output.contains("[ERROR]") && output.contains("File must have a .txt extension"));
    }

    @Test
    void testFileDoesNotExist() {
        String filepath = "src/test/resources/fakeTestFile.txt";
        Reader.readFromFile(filepath);
        String output = outContent.toString().trim();
        assertTrue(output.contains("[ERROR]") && output.contains("File not found: " + filepath));
    }

    @Test
    public void testAutomatReadFromFile() {
        String filepath = "src/test/resources/testfile.txt";
        Assertions.assertDoesNotThrow(()-> Reader.readFromFile(filepath));

    }
}
