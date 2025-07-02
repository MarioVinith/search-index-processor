package com.csgi.searchindexprocessor.parser;

/**
 * Factory class to create appropriate {@link FileParser} instances based on file extension.
 * <p>
 * Supports `.txt` and `.csv` file types. Throws an exception for unsupported formats.
 */
public class FileParserFactory {

    /**
     * Returns a {@link FileParser} instance suitable for the given file name.
     *
     * @param fileName the name of the file for which a parser is required
     * @return a {@link TextFileParser} if the file ends with {@code .txt}, or a {@link CSVFileParser} if it ends with {@code .csv}
     * @throws IllegalArgumentException if the file extension is not supported
     */
    public static FileParser getParser(String fileName) {
        if (fileName.endsWith(".txt"))
            return new TextFileParser();
        if (fileName.endsWith(".csv"))
            return new CSVFileParser();
        throw new IllegalArgumentException("Unsupported file format: " + fileName);
    }
}
