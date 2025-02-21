package calculator;

public class Calculator {
    private final Validator validator;

    public Calculator(Validator validator) {
        this.validator = validator;
    }

    public int calculate(String expression) {
        if (!validator.isValid(expression)) {
            return 0; // Return 0 for invalid expressions
        }

        try {
            // Remove all whitespace
            expression = expression.replaceAll("\\s+", "");

            // Perform operations
            if (expression.contains("+")) {
                String[] parts = expression.split("\\+");
                return Integer.parseInt(parts[0]) + Integer.parseInt(parts[1]);
            } else if (expression.contains("-")) {
                String[] parts = expression.split("-");
                return Integer.parseInt(parts[0]) - Integer.parseInt(parts[1]);
            } else if (expression.contains("*")) {
                String[] parts = expression.split("\\*");
                return Integer.parseInt(parts[0]) * Integer.parseInt(parts[1]);
            } else if (expression.contains("/")) {
                String[] parts = expression.split("/");
                int divisor = Integer.parseInt(parts[1]);
                if (divisor == 0) {
                    return 0; // Return 0 if division by zero
                }
                return Integer.parseInt(parts[0]) / divisor;
            }
        } catch (Exception e) {
            // In cases of malformed input, return 0
            return 0;
        }

        // Return 0 for unsupported operations
        return 0;
    }
}