package com.csgi.searchindexprocessor.rule;

/**
 * A {@link Rule} implementation that matches words starting with the letter 'M' (case-insensitive).
 */
public class StartsWithMRule implements Rule {

    /**
     * Checks whether the given word starts with the letter 'M', ignoring case.
     *
     * @param word the word to evaluate
     * @return {@code true} if the word is non-null and starts with 'M' (case-insensitive); {@code false} otherwise
     */
    @Override
    public boolean matches(String word) {
        return null != word && word.toUpperCase().startsWith("M");
    }
}
