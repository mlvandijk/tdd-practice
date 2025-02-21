package calculator;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class CalculatorTest {
    Calculator calculator;


    @Before
    public void setUp() {
        Validator validator = new ArithmeticExpressionValidator();
        calculator = new Calculator(validator);
    }

    @Test
    public void two_plus_two_equals_four(){
        Assert.assertThat(calculator.calculate("2+2"), Matchers.is(4));
    }

    @Test
    public void fourty_minus_twenty_equals_twenty(){
        Assert.assertThat(calculator.calculate("40-20"), Matchers.is(20));
    }

    @Test
    public void two_times_thirty_equals_sixty(){
        Assert.assertThat(calculator.calculate("2*30"), Matchers.is(60));
    }

    @Test
    public void six_divided_by_three_equals_two(){
        Assert.assertThat(calculator.calculate("6/3"), Matchers.is(2));
    }

    @Test
    public void space_returns_zero(){
        Assert.assertThat(calculator.calculate(" "), Matchers.is(0));
    }

    @Test
    public void multiple_spaces_return_zero(){
        Assert.assertThat(calculator.calculate("           "), Matchers.is(0));
    }

    @Test
    public void special_chars_return_zero(){
        Assert.assertThat(calculator.calculate("!@#$"), Matchers.is(0));
    }

    @Test
    public void more_special_chars_return_zero(){
        Assert.assertThat(calculator.calculate("!@#$&*()^"), Matchers.is(0));
    }

    @Test
    public void large_numbers_sum_correctly() {
        Assert.assertThat(calculator.calculate("1000000+2000000"), Matchers.is(3000000));
    }

    @Test
    public void large_numbers_subtract_correctly() {
        Assert.assertThat(calculator.calculate("9999999-8888888"), Matchers.is(1111111));
    }

    @Test
    public void division_by_zero_returns_zero() {
        Assert.assertThat(calculator.calculate("10/0"), Matchers.is(0));
    }

    @Test
    public void whitespace_around_numbers_is_ignored() {
        Assert.assertThat(calculator.calculate("  2  *  3  "), Matchers.is(6));
    }

    @Test
    public void multiple_spaces_between_operators_is_handled() {
        Assert.assertThat(calculator.calculate("4    +     5"), Matchers.is(9));
    }

    @Test
    public void mixed_numbers_and_special_characters_return_zero() {
        Assert.assertThat(calculator.calculate("2a+3b"), Matchers.is(0));
    }

    @Test
    public void unsupported_operator_returns_zero() {
        Assert.assertThat(calculator.calculate("5^2"), Matchers.is(0)); // Assuming exponentiation is unsupported
    }

    @Test
    public void zero_input_returns_valid_results() {
        Assert.assertThat(calculator.calculate("0+0"), Matchers.is(0));
        Assert.assertThat(calculator.calculate("0-5"), Matchers.is(-5));
    }

    @Test
    public void input_with_newlines_returns_zero() {
        Assert.assertThat(calculator.calculate("2\n+\n3"), Matchers.is(5));
    }

    @Test
    public void empty_string_returns_zero() {
        Assert.assertThat(calculator.calculate(""), Matchers.is(0));
    }

    @Test
    public void input_starting_with_operator_returns_zero() {
        Assert.assertThat(calculator.calculate("+2+3"), Matchers.is(0)); // Or handle as preferred.
    }

    @Test
    public void input_ending_with_operator_returns_zero() {
        Assert.assertThat(calculator.calculate("2+3*"), Matchers.is(0)); // Or handle as preferred.
    }

    @Test
    public void multiple_consecutive_operators_return_zero() {
        Assert.assertThat(calculator.calculate("2++2"), Matchers.is(0));
        Assert.assertThat(calculator.calculate("4--5"), Matchers.is(0));
    }

    @Test
    public void unary_negative_operator_is_supported() {
        Assert.assertThat(calculator.calculate("-2+3"), Matchers.is(1));
    }

    @Test
    public void unary_positive_operator_is_supported() {
        Assert.assertThat(calculator.calculate("+5+10"), Matchers.is(15));
    }

    @Test
    public void decimal_addition_returns_correct_result() {
        Assert.assertThat(calculator.calculate("1.5+2.5"), Matchers.is(4.0)); // Assuming decimal support
    }

    @Test
    public void mixed_operators_respect_precedence() {
        Assert.assertThat(calculator.calculate("2+3*5"), Matchers.is(17)); // 2 + (3*5)
    }

    @Test
    public void parenthesis_override_operator_precedence() {
        Assert.assertThat(calculator.calculate("(2+3)*5"), Matchers.is(25)); // (2+3) * 5
    }

    @Test
    public void negative_subtraction_returns_correct_value() {
        Assert.assertThat(calculator.calculate("-10-5"), Matchers.is(-15));
    }

    @Test
    public void negative_multiplication_returns_correct_value() {
        Assert.assertThat(calculator.calculate("-2*3"), Matchers.is(-6));
    }

    @Test
    public void very_large_expression_is_handled_properly() {
        Assert.assertThat(calculator.calculate("1+2+3+4+5+6+7+8+9+10"), Matchers.is(55));
    }
}
