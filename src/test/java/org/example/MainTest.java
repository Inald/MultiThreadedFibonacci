package org.example;

import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test Class for Main class.
 * Unit tests for testing the behavior of Main class's main method.
 */
public class MainTest {

    /**
     * This test checks if the program prints the Fibonacci sequence correctly for the first 10 values.
     * The mock input represents a user input of 10.
     * The expected output contains the first 10 Fibonacci numbers.
     */
    @Test
    void testMainOutputsFibonacciSequence() {
        String input = "10\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        Main.main(new String[] {});

        String[] outputLines = out.toString().split(System.lineSeparator());
        String fibonacciSequence = outputLines[2];

        assertEquals("1 1 2 3 5 8 13 21 34 55 \n" + "---------------------", fibonacciSequence);
    }
}