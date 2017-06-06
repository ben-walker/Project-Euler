package euler26_reciprocalcycles;

import java.math.BigInteger;
import java.util.*;

/**
 *
 * @author Ben Walker
 */
public class Euler26_reciprocalCycles {

    public static void main(String[] args) {
        System.out.println("NUMBER LESS THAN 1000 WITH THE LONGEST REPETEND: " + getLongestRepetend(1000));
    }
    
    private static int getLongestRepetend (int limit) {
        List<Integer> primes = getCoprimesTo10(limit);
        int longestRepetend = 0;
        int longestPrime = 0;
        
        for (int prime : primes) {
            int repetendLength = getRepetendLength(prime);
            
            if(repetendLength > longestRepetend) {
                longestPrime = prime;
                longestRepetend = repetendLength;
            }
        }
        
        return longestPrime;
    }
    
    private static int getRepetendLength (int number) {
        BigInteger exponent = BigInteger.valueOf(1);
        BigInteger primeNumber = BigInteger.valueOf(number);
        BigInteger base = BigInteger.valueOf(10);
        int order = 0;
        
        while (order == 0) {
            if(base.modPow(exponent, primeNumber).equals(BigInteger.valueOf(1))) {
                order = exponent.intValue();
                break;
            }
            exponent = exponent.add(BigInteger.valueOf(1));
        }
        
        return order;
    }
    
    private static List<Integer> getCoprimesTo10 (int limit) {
        List<Integer> primes = new ArrayList<>();
        for (int i = 1; i <= limit; i++) {
            if(isPrime(i) && 10 % i != 0)
                primes.add(i);
        }
        return primes;
    }
    
    private static boolean isPrime (long num) {
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if((num % i) == 0)
                return false;
        }
        return true;
    }
    
}
