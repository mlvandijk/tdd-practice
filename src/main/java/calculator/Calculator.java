package calculator;

import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {
    private final Validator validator;
    private static final Pattern NUMBER_PATTERN = Pattern.compile("-?\\d+(\\.\\d+)?");

    public Calculator(Validator validator) {
        this.validator = validator;
    }

    public double calculate(String expression) {
        if (!validator.isValid(expression)) {
            return 0;
        }

        expression = expression.trim();
        if (expression.isEmpty()) {
            return 0;
        }

        try {
            return evaluateExpression(expression);
        } catch (Exception e) {
            return 0;
        }
    }

    public int calculateInt(String expression) {
        return (int)Math.round(calculate(expression));
    }

    private double evaluateExpression(String expression) {
        expression = expression.replaceAll("\\s+", "");

        // Handle parentheses first
        while (expression.contains("(")) {
            int start = expression.lastIndexOf("(");
            int end = expression.indexOf(")", start);
            if (end == -1) return 0;

            String subExpr = expression.substring(start + 1, end);
            double result = evaluateExpression(subExpr);
            expression = expression.substring(0, start) + String.valueOf(result) + expression.substring(end + 1);
        }

        // Split expression into numbers and operators
        Stack<Double> numbers = new Stack<>();
        Stack<Character> operators = new Stack<>();

        StringBuilder numBuilder = new StringBuilder();
        boolean expectNumber = true;

        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);

            if ((c == '-' || c == '+') && (expectNumber || i == 0)) {
                numBuilder.append(c);
                continue;
            }

            if (Character.isDigit(c) || c == '.') {
                numBuilder.append(c);
                expectNumber = false;
            } else if (isOperator(c)) {
                if (numBuilder.length() > 0) {
                    numbers.push(Double.parseDouble(numBuilder.toString()));
                    numBuilder.setLength(0);
                }

                while (!operators.isEmpty() && hasPrecedence(operators.peek(), c)) {
                    numbers.push(applyOperator(operators.pop(), numbers.pop(), numbers.pop()));
                }
                operators.push(c);
                expectNumber = true;
            }
        }

        if (numBuilder.length() > 0) {
            numbers.push(Double.parseDouble(numBuilder.toString()));
        }

        while (!operators.isEmpty()) {
            numbers.push(applyOperator(operators.pop(), numbers.pop(), numbers.pop()));
        }

        return numbers.isEmpty() ? 0 : numbers.pop();
    }

    private boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }

    private boolean hasPrecedence(char op1, char op2) {
        if ((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-')) {
            return true;
        }
        return false;
    }

    private double applyOperator(char operator, double b, double a) {
        switch (operator) {
            case '+': return a + b;
            case '-': return a - b;
            case '*': return a * b;
            case '/': return b == 0 ? 0 : a / b;
            default: return 0;
        }
    }
}
