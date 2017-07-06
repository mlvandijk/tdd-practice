package primes;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

public class PrimeFactorsLists {
    PrimeFactors primeFactors;

    @Before
    public void setUp(){
        primeFactors = new PrimeFactors();
    }

    @Test
    public void zero_returns_zero(){
        Assert.assertEquals(Arrays.asList(), primeFactors.getPrimeFactors(1));
    }

    @Test
    public void two_returns_two(){
        Assert.assertEquals(Arrays.asList(2), primeFactors.getPrimeFactors(2));
    }

    @Test
    public void three_returns_three(){
        Assert.assertEquals(Arrays.asList(3), primeFactors.getPrimeFactors(3));
    }

    @Test
    public void four_returns_list_of_two_twos(){
        Assert.assertEquals(Arrays.asList(2, 2), primeFactors.getPrimeFactors(4));
    }

    @Test
    public void six_returns_list_of_two_and_three(){
        Assert.assertEquals(Arrays.asList(2, 3), primeFactors.getPrimeFactors(6));
    }

    @Test
    public void eight_returns_list_of_two_and_three(){
        Assert.assertEquals(Arrays.asList(2, 2, 2), primeFactors.getPrimeFactors(8));
    }

    @Test
    public void eight_returns_list_of_two_threes(){
        Assert.assertEquals(Arrays.asList(3, 3), primeFactors.getPrimeFactors(9));
    }

    @Test
    public void twelve_returns_list_of_two_twos_and_three(){
        Assert.assertEquals(Arrays.asList( 2, 2, 3), primeFactors.getPrimeFactors(12));
    }

    @Test
    public void thirtyfive_returns_five_and_seven(){
        Assert.assertEquals(Arrays.asList( 5, 7), primeFactors.getPrimeFactors(35));
    }

    @Test
    public void multiplication_of_primes_returns_list_of_its_components(){
        Assert.assertEquals(Arrays.asList( 2, 2, 2, 3, 3, 5, 7, 11), primeFactors.getPrimeFactors(2*2*2*3*3*5*7*11));
    }

}
