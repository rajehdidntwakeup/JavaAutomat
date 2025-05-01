package org.fogl.automat;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.fogl.reader.Reader.checkTheInputAndPrintTheResult;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestCheckInput {

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
        checkTheInputAndPrintTheResult(null);
        String output = outContent.toString().trim();
        assertTrue(output.contains("[ERROR] No input provided!"));
    }

    @Test
    void testEmptyInput() {
        checkTheInputAndPrintTheResult("   ");
        String output = outContent.toString().trim();
        assertTrue(output.contains("[ERROR] No input provided!"));
    }

    @Test
    void testValidInput() {
        String input = "322/(22*7*44)=81";
        checkTheInputAndPrintTheResult(input);
        String output = outContent.toString().trim();
        assertTrue(output.contains("[SUCCESS]"));
    }

    @Test
    void testInvalidInput() {
        String input = "322/22*7*44)=81";
        checkTheInputAndPrintTheResult(input);
        String output = outContent.toString().trim();
        assertTrue(output.contains("[ERROR]") && output.contains("NOT syntactically correct"));
    }
}
