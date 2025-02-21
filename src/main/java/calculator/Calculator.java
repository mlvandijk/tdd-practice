package calculator;

import java.util.Stack;

public class Calculator {
    private final Validator validator;

    public Calculator(Validator validator) {
        this.validator = validator;
    }

    public double calculate(String expression) {
        if (!validator.isValid(expression)) {
            return 0;
        }

        // Normalize the expression (handle spaces)
        expression = expression.replaceAll("\\s+", "");

        try {
            return evaluate(expression);
        } catch (Exception e) {
            return 0; // Return 0 for any malformed or invalid expressions
        }
    }

    private double evaluate(String expression) {
        // Convert to postfix (Reverse Polish Notation - RPN) and then evaluate
        String postfix = convertToPostfix(expression);
        return evaluatePostfix(postfix);
    }

    private String convertToPostfix(String expression) {
        StringBuilder postfix = new StringBuilder();
        Stack<Character> operators = new Stack<>();

        int i = 0;
        while (i < expression.length()) {
            char ch = expression.charAt(i);

            if (Character.isDigit(ch) || ch == '.') {
                // Read the entire numeric value (e.g., 123.45)
                while (i < expression.length() && (Character.isDigit(expression.charAt(i)) || expression.charAt(i) == '.')) {
                    postfix.append(expression.charAt(i));
                    i++;
                }
                postfix.append(' ');
                continue;
            } else if (ch == '(') {
                operators.push(ch);
            } else if (ch == ')') {
                while (!operators.isEmpty() && operators.peek() != '(') {
                    postfix.append(operators.pop()).append(' ');
                }
                if (!operators.isEmpty() && operators.peek() == '(') {
                    operators.pop();
                }
            } else if (isOperator(ch)) {
                // Handle unary + and -
                if ((i == 0 || (!Character.isDigit(expression.charAt(i - 1)) && expression.charAt(i - 1) != ')')) && (ch == '+' || ch == '-')) {
                    postfix.append('0').append(' '); // Prepend 0 for cases like -2 or +3
                }

                while (!operators.isEmpty() && precedence(operators.peek()) >= precedence(ch)) {
                    postfix.append(operators.pop()).append(' ');
                }
                operators.push(ch);
            }

            i++;
        }

        // Append remaining operators
        while (!operators.isEmpty()) {
            postfix.append(operators.pop()).append(' ');
        }

        return postfix.toString();
    }

    private double evaluatePostfix(String postfix) {
        Stack<Double> stack = new Stack<>();
        String[] tokens = postfix.split("\\s+");

        for (String token : tokens) {
            if (isNumeric(token)) {
                stack.push(Double.parseDouble(token));
            } else if (token.length() == 1 && isOperator(token.charAt(0))) {
                double b = stack.pop();
                double a = stack.isEmpty() ? 0 : stack.pop(); // Handle unary operators with a default of 0

                switch (token.charAt(0)) {
                    case '+':
                        stack.push(a + b);
                        break;
                    case '-':
                        stack.push(a - b);
                        break;
                    case '*':
                        stack.push(a * b);
                        break;
                    case '/':
                        if (b == 0) {
                            return 0; // Division by zero returns 0 (as per test case)
                        }
                        stack.push(a / b);
                        break;
                }
            }
        }

        return stack.isEmpty() ? 0 : stack.pop();
    }

    private boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }

    private boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private int precedence(char operator) {
        switch (operator) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            default:
                return 0;
        }
    }
}