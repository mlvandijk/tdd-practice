package calculator;

public class ArithmeticExpressionValidator implements Validator {

    @Override
    public boolean isValid(String expression) {
        if (expression == null || expression.trim().isEmpty()) {
            return false; // Empty or null expressions are invalid
        }

        // Validate the expression against allowed characters (digits, operators, and spaces)
        return expression.matches("[0-9\\s+\\-*/]+");
    }
}