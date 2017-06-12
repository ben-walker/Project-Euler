package euler37_truncatableprimes;

import java.util.*;

/**
 *
 * @author Ben Walker
 */
public class Euler37_truncatablePrimes {

    public static void main(String[] args) {
        Boolean[] sieve = primeSieve(1000000);
        List<Integer> twoSidedPrimes = getTwoSidedPrimes(sieve);
        System.out.println("SUM OF ALL 11 TWO-SIDED PRIMES: " + sumList(twoSidedPrimes));
    }
    
    private static Boolean[] primeSieve (int limit) {
        Boolean[] sieve = new Boolean[limit];
        Arrays.fill(sieve, true);
        
        sieve[0] = false;
        sieve[1] = false;
        
        for (int i = 2; i < Math.sqrt(limit); i++) {
            if(sieve[i] == true) {
                for (int j = i * i; j < limit; j += i) {
                    sieve[j] = false;
                }
            }
        }
        
        return sieve;
    }
    
    
    private static List<Integer> getTwoSidedPrimes (Boolean[] sieve) {
        List<Integer> twoSidedPrimes = new ArrayList<>();
        
        for (int i = 8; i < sieve.length; i++) {
            if(isLeftTruncatablePrime(sieve, String.valueOf(i)) && isRightTruncatablePrime(sieve, String.valueOf(i)))
                twoSidedPrimes.add(i);
        }
        
        return twoSidedPrimes;
    }
    
    private static long sumList (List<Integer> numbers) {
        long sum = 0L;
        
        for (int number : numbers)
            sum += number;
        
        return sum;
    }
    
    private static boolean isLeftTruncatablePrime (Boolean[] sieve, String number) {
        if(number.contains("0"))
            return false;
        
        for (int i = 0; i < number.length(); i++) {
            int index = Integer.valueOf(number.substring(i));
            if(!sieve[index])
                return false;
        }
        
        return true;
    }
    
    private static boolean isRightTruncatablePrime (Boolean[] sieve, String number) {
        if(number.contains("0"))
            return false;
        
        for (int i = number.length(); i > 0; i--) {
            int index = Integer.valueOf(number.substring(0, i));
            if(!sieve[index])
                return false;
        }
        
        return true;
    }
    
}
