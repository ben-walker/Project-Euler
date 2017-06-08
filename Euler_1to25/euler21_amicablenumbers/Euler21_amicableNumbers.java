package euler21_amicablenumbers;

import java.util.*;

/**
 *
 * @author Ben Walker
 */
public class Euler21_amicableNumbers {

    public static void main(String[] args) {
        int limit = 10000;
        Set<Integer> amicableNumbers = findAmicableNumbers(limit);
        
        System.out.println("SUM OF ALL AMICABLE NUMBERS UNDER " + limit + ": " + sumOfNumberSet(amicableNumbers));
    }
    
    private static Set<Integer> findAmicableNumbers (int limit) {
        Set<Integer> amicableNumbers = new HashSet<>();
        Set<Integer> divisors;
        
        for (int i = 2; i < limit; i++) {
            divisors = findDivisors(i);
            int sum = sumOfNumberSet(divisors);
            
            if(sumOfNumberSet(findDivisors(sum)) == i && sum != i) {
                amicableNumbers.add(i);
            }
            
        }
        
        return amicableNumbers;
    }
    
    private static Set<Integer> findDivisors (int number) {
        Set<Integer> divisors = new HashSet<>();
        if(number == 1)
            return divisors;
        divisors.add(1);
        
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if(number % i == 0 && !divisors.contains(i)) {
                divisors.add(i);
                divisors.add(number / i);
            }
        }
        
        return divisors;
    }
    
    private static int sumOfNumberSet (Set<Integer> numberSet) {
        int sum = 0;
        for (Integer number : numberSet) {
            sum += number;
        }
        return sum;
    }
    
}
