package calculator;

import java.util.regex.Pattern;

public class ArithmeticExpressionValidator implements Validator {
    private static final Pattern VALID_EXPRESSION_PATTERN = Pattern.compile(
        "^[\\s\\d.+\\-*/()]*$" // Allow only numbers, operators (+, -, *, /), whitespace, decimal points, and parentheses
    );

    @Override
    public boolean isValid(String expression) {
        if (expression == null || expression.trim().isEmpty()) {
            return false;
        }
        return VALID_EXPRESSION_PATTERN.matcher(expression).matches();
    }
}