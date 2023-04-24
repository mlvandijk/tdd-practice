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
    public void special_chars_return_zero(){
        Assert.assertThat(calculator.calculate("!@#$"), Matchers.is(0));
    }

    @Test
    public void more_special_chars_return_zero(){
        Assert.assertThat(calculator.calculate("!@#$&*()^"), Matchers.is(0));
    }
}
