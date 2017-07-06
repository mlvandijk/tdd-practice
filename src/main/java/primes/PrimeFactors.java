package primes;

import java.util.ArrayList;
import java.util.List;

/*
* First solution, after some  refactoring.
* Wanted to see if I could do a recursive one also
* */

public class PrimeFactors {
    List<Integer> primes = new ArrayList<>();

    public List<Integer> getPrimeFactors(int composite) {
        if (composite >= 2){
            int i = 2;
            while (i <= composite){
                if (composite % i == 0){
                    primes.add(i);
                    composite /= i;
                } else {
                    i++;
                }
                // base case
                if (i == composite){
                    primes.add(i);
                    break;
                }
            }
        }
        return primes;
    }
}
