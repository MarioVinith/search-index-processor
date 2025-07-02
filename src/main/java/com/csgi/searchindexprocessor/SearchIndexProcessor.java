package com.csgi.searchindexprocessor;

import com.csgi.searchindexprocessor.config.AppConfig;
import com.csgi.searchindexprocessor.parser.FileParser;
import com.csgi.searchindexprocessor.parser.FileParserFactory;
import com.csgi.searchindexprocessor.rule.*;

import java.io.*;
import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * Entry point for the Search Index Processor application.
 * <p>
 * This class reads a file (TXT or CSV), extracts words using the appropriate parser,
 * and applies rules to:
 * <ul>
 *     <li>Count words that start with the letter 'M' (case-insensitive)</li>
 *     <li>Filter and print words longer than a configured minimum length</li>
 * </ul>
 *
 * <p>
 * Configuration is read from a properties file named {@code config.properties} in the classpath,
 * which must include the property {@code min.length}.
 */
public class SearchIndexProcessor {

    /**
     * Main method to run the search index processor.
     *
     * @param args expects a single argument - the name of the file to process (e.g., {@code input.txt} or {@code data.csv})
     * @throws IOException if an I/O error occurs during file or configuration reading
     * @throws FileNotFoundException if no file is found at resources for the provided name
     * @throws IllegalArgumentException if no file name is provided or if the file format is unsupported
     */
    public static void main(String[] args) throws IOException {
        if (args.length < 1)
            throw new IllegalArgumentException("File name required in arguments.");

        String fileName = args[0];
        AppConfig config = new AppConfig("config.properties");

        InputStream inputStream = SearchIndexProcessor.class
                .getClassLoader()
                .getResourceAsStream(fileName);

        if (inputStream == null)
            throw new FileNotFoundException("File not found in resources: " + fileName);

        FileParser parser = FileParserFactory.getParser(fileName);
        List<String> words = parser.extractWords(inputStream);

        Rule startsWithMRule = new StartsWithMRule();
        Rule greaterThanRule = new GreaterLengthRule(config.getMinLength());

        long mWords = words.stream().filter(startsWithMRule::matches).count();
        List<String> longWords = words.stream()
                .filter(greaterThanRule::matches)
                .collect(toList());

        System.out.println("Words starting with 'M' or 'm': " + mWords);
        System.out.println("Words longer than " + config.getMinLength() + " characters: " + longWords);
    }
}
