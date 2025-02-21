package calculator;

public interface Validator {
    /**
     * Validates if the given arithmetic expression is valid.
     * @param expression The arithmetic expression to validate
     * @return true if the expression is valid, false otherwise
     */
    boolean isValid(String expression);
}