package calculator;

import java.util.regex.Pattern;

public class ArithmeticExpressionValidator implements Validator {
    private static final String VALID_EXPRESSION_REGEX = 
        "^\\s*[+-]?\\s*\\(?\\s*\\d+(\\.\\d+)?\\s*\\)?\\s*([+\\-*/]\\s*\\(?\\s*[+-]?\\s*\\d+(\\.\\d+)?\\s*\\)?\\s*)*$";
    private static final Pattern VALID_EXPRESSION_PATTERN = Pattern.compile(VALID_EXPRESSION_REGEX);

    @Override
    public boolean isValid(String expression) {
        if (expression == null || expression.trim().isEmpty()) {
            return true; // Empty or null expressions are considered valid (will return 0)
        }

        // Check for invalid characters (except valid operators, numbers, spaces, parentheses, and decimal point)
        if (expression.replaceAll("[0-9+\\-*/()\\s.]", "").length() > 0) {
            return false;
        }

        // Check for division by zero
        if (expression.matches(".*\\/\\s*0.*")) {
            return false;
        }

        // Check for multiple consecutive operators
        if (expression.matches(".*[+\\-*/]\\s*[+\\-*/].*")) {
            return false;
        }

        // Validate the overall expression structure
        return VALID_EXPRESSION_PATTERN.matcher(expression).matches();
    }
}
