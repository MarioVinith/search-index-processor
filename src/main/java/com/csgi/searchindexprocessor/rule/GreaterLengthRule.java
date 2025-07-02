package com.csgi.searchindexprocessor.rule;

/**
 * A {@link Rule} implementation that matches words whose length is greater than a specified threshold.
 */
public class GreaterLengthRule implements Rule {

    private final int length;

    /**
     * Constructs a {@code GreaterLengthRule} with the specified length threshold.
     *
     * @param length the length that a word must exceed to be considered a match
     */
    public GreaterLengthRule(int length) {
        this.length = length;
    }

    /**
     * Checks whether the given word's length is greater than the configured threshold.
     *
     * @param word the word to evaluate
     * @return {@code true} if the word is non-null and its length is greater than the threshold; {@code false} otherwise
     */
    @Override
    public boolean matches(String word) {
        return word != null && word.length() > length;
    }
}
