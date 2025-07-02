package com.csgi.searchindexprocessor;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class SearchIndexProcessorTest {

    @Test
    void testProcessorWithTxtFile() throws Exception {
        String[] args = {"input.txt"};

        // Capture stdout
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        SearchIndexProcessor.main(args);
        String output = out.toString();

        assertTrue(output.contains("Words starting with 'M' or 'm':"));
        assertTrue(output.contains("Words longer than"));
    }

    @Test
    void testProcessorWithCSVFile() throws Exception {
        String[] args = {"input.csv"};

        // Capture stdout
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        SearchIndexProcessor.main(args);
        String output = out.toString();

        assertTrue(output.contains("Words starting with 'M' or 'm':"));
        assertTrue(output.contains("Words longer than"));
    }

    @Test()
    void testProcessorWithInvalidFile() {
        try {
            String[] args = {"input.hsh"};
            SearchIndexProcessor.main(args);
        } catch (Exception e) {
            assertInstanceOf(FileNotFoundException.class, e);
            assertEquals("File not found in resources: input.hsh", e.getMessage());
        }
    }

    @Test()
    void testProcessorWithNoArguments() {
        try {
            String[] args = new String[0];
            SearchIndexProcessor.main(args);
        } catch (Exception e) {
            assertInstanceOf(IllegalArgumentException.class, e);
            assertEquals("File name required in arguments.", e.getMessage());
        }
    }

    @Test()
    void testProcessorWithUnSupportedFile() {
        try {
            String[] args = {"input.drl"};
            SearchIndexProcessor.main(args);
        } catch (Exception e) {
            assertInstanceOf(IllegalArgumentException.class, e);
            assertEquals("Unsupported file format: input.drl", e.getMessage());
        }
    }
}
