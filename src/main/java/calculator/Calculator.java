package calculator;

public class Calculator {
    private final Validator validator;
    private int[] numbers = new int[2];

    public Calculator(Validator validator){
        this.validator = validator;
    }

    int calculate(String input){
        if (validator.isInputValid(input)) {
            return calculateArithMeticExpression(input);
        }
        return 0;
    }

    private int calculateArithMeticExpression(String input) {
        if (input.contains("+")){
            numbers = getNumbersFromString(input, "+");
            return Math.addExact(numbers[0], numbers[1]);
        } else if (input.contains("-")) {
            numbers = getNumbersFromString(input, "-");
            return Math.subtractExact(numbers[0], numbers[1]);
        } else if (input.contains("*")) {
            numbers = getNumbersFromString(input, "*");
            return Math.multiplyExact(numbers[0], numbers[1]);
        } else if (input.contains("/")) {
            numbers = getNumbersFromString(input, "/");
            if (numbers[1] == 0) {
                return 0;
            }
            return Math.floorDiv(numbers[0], numbers[1]);
        }
        return -1;
    }

    private int[] getNumbersFromString(String input, String operator) {
        int index = input.indexOf(operator);
        numbers[0] = Integer.parseInt(input.substring(0, index).trim());
        numbers[1] = Integer.parseInt(input.substring(index + 1, input.length()).trim());
        return numbers;
    }
}
