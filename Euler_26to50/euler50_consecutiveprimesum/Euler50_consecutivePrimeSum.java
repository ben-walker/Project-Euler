package euler50_consecutiveprimesum;

import java.util.*;

/**
 *
 * @author Ben Walker
 */
public class Euler50_consecutivePrimeSum {

    public static void main(String[] args) {
        Boolean[] sieve = eratosthenesSieve(1000000);
        long prime = findConsecutivePrimeSum(1000000, sieve);
        
        System.out.println("PRIME BELOW 1000000 THAT CAN BE WRITTEN AS THE SUM OF THE MOST CONSECUTIVE PRIMES: " + prime);
    }
    
    private static long findConsecutivePrimeSum (int limit, Boolean[] sieve) {
        long prime;
        long mostConsecutivePrime = 0L;
        int consecutive;
        int longest = 0;
        
        for (int i = 0; i < limit; i++) {
            if(sieve[i] == true) {
                
                prime = 0L;
                consecutive = 0;
                for (int j = i; j < limit; j++) {
                    
                    if(sieve[j] == true) {
                        prime += j;
                        consecutive ++;
                        
                        if(isPrime(prime) && prime < limit) {
                            if(consecutive > longest) {
                                longest = consecutive;
                                mostConsecutivePrime = prime;
                            }
                        }
                        
                        else if(prime > limit)
                            break;
                    }
                }
                
            }
        }
        
        return mostConsecutivePrime;
    }
    
    private static Boolean[] eratosthenesSieve (int limit) {
        Boolean[] primeFinder = new Boolean[limit];
        Arrays.fill(primeFinder, Boolean.TRUE);
        
        primeFinder[0] = false;
        primeFinder[1] = false;
        
        for (int i = 2; i < Math.sqrt(limit); i++) {
            
            if(primeFinder[i] == true) {
                for (int j = (int)Math.pow(i, 2); j < limit; j += i) {
                    primeFinder[j] = false;
                }
            }
            
        }
        
        return primeFinder;
    }
    
    private static boolean isPrime (long num) {
        if(num  <= 1) return false;
        
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if((num % i) == 0)
                return false;
        }
        return true;
    }
    
}
