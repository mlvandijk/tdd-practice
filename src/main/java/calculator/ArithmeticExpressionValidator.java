package calculator;

public class ArithmeticExpressionValidator implements Validator {

    @Override
    public boolean isInputValid(String input) {
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (Character.isDigit(c) || "+-/*".contains(String.valueOf(c))) {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }
}