package com.csgi.searchindexprocessor.parser;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Interface for parsing files and extracting words from an input stream.
 */
public interface FileParser {

    /**
     * Extracts words from the given input stream.
     *
     * @param inputStream the input stream of a file to parse
     * @return a list of words extracted from the input stream
     * @throws IOException if an I/O error occurs while reading from the stream
     */
    List<String> extractWords(InputStream inputStream) throws IOException;
}
