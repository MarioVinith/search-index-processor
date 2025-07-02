package com.csgi.searchindexprocessor.rule;

/**
 * Represents a rule that can be applied to a word to determine if it matches certain criteria.
 * <p>
 * This interface is typically used for filtering or validating words based on custom logic.
 */
public interface Rule {

    /**
     * Checks whether the given word matches the rule's criteria.
     *
     * @param word the word to evaluate
     * @return {@code true} if the word matches the rule; {@code false} otherwise
     */
    boolean matches(String word);
}
