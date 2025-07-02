package com.csgi.searchindexprocessor.parser;

import java.io.*;
import java.util.*;

import static java.util.stream.Collectors.toList;

/**
 * Implementation of {@link FileParser} to extract words from CSV-like files.
 * <p>
 * This parser splits each line of the input stream using comma (`,`) or semicolon (`;`)
 * as delimiters, trims the results, and filters out empty strings.
 */
public class CSVFileParser implements FileParser {

    /**
     * Extracts words from a CSV-like input stream.
     * <p>
     * Each line is split using comma or semicolon as the delimiter. Whitespace is trimmed
     * from each entry and empty entries are ignored.
     *
     * @param inputStream the input stream of the CSV file
     * @return a list of non-empty trimmed words extracted from the file
     * @throws IOException if an I/O error occurs while reading from the stream
     */
    @Override
    public List<String> extractWords(InputStream inputStream) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            return reader.lines()
                    .flatMap(line -> Arrays.stream(line.split("[,;]")))
                    .map(String::trim)
                    .filter(w -> !w.isEmpty())
                    .collect(toList());
        }
    }
}
