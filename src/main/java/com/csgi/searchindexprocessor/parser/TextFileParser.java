package com.csgi.searchindexprocessor.parser;

import java.io.*;
import java.util.*;

import static java.util.stream.Collectors.toList;

/**
 * Implementation of {@link FileParser} to extract words from plain text (.txt) files.
 * <p>
 * This parser splits each line by spaces, filters out empty tokens, and returns the list of words.
 */
public class TextFileParser implements FileParser {

    /**
     * Extracts words from a plain text input stream.
     * <p>
     * Each line is split using a single space as the delimiter. Empty strings are filtered out.
     *
     * @param inputStream the input stream of the text file
     * @return a list of non-empty words extracted from the file
     * @throws IOException if an I/O error occurs while reading from the stream
     */
    @Override
    public List<String> extractWords(InputStream inputStream) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            return reader.lines()
                    .flatMap(line -> Arrays.stream(line.split(" ")))
                    .filter(w -> !w.isEmpty())
                    .collect(toList());
        }
    }
}
