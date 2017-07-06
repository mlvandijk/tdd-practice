package primes;

import java.util.ArrayList;
import java.util.List;

/*
* A recursive solution to the prime factors problem
* */

public class PrimeFactorsRecursive {
    List<Integer> primes = new ArrayList<>();

    public List<Integer> getPrimeFactors(int composite) {
        return getPrimeFactors(composite, 2);

    }
    public List<Integer> getPrimeFactors(int composite, int n) {
        if (composite < 2){
            return primes;
        }

        if (composite % n == 0){
            primes.add(n);
            getPrimeFactors(composite /= n, n);
        } else {
            getPrimeFactors(composite, n + 1);
        }

        return primes;
    }
}
