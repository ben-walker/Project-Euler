package euler46_goldbachsotherconjecture;

import java.util.*;

/**
 *
 * @author Ben Walker
 */
public class Euler46_goldbachsOtherConjecture {
    
    public static void main(String[] args) {
        Boolean[] primeSieve = eratosthenesSieve(1000000);
        System.out.println("SMALLEST ODD COMPOSITE THAT CANNOT BE WRITTEN AS SUM OF PRIME AND TWICE A SQUARE: " + findMinNonGoldbach(primeSieve, 1000000));
    }
    
    private static int findMinNonGoldbach (Boolean[] sieve, int limit) {
        for (int i = 2; i < limit; i++) {
            if(i % 2 != 0 && sieve[i] == false) {
                if(findComposition(sieve, i) == false)
                    return i;
            }
        }
        
        return -1;
    }
    
    private static boolean findComposition (Boolean[] sieve, int index) {
        for (int i = 0; i < index; i++) {
            if(sieve[i] == true) {
                
                for (int j = 1; j < index / 2; j++) {
                    
                    if(i + (2 * Math.pow(j, 2)) == index)
                        return true;
                    
                }
                
            }
        }
        
        return false;
    }
    
    private static Boolean[] eratosthenesSieve (int limit) {
        Boolean[] sieve = new Boolean[limit];
        Arrays.fill(sieve, Boolean.TRUE);
        
        sieve[0] = false;
        sieve[1] = false;
        
        for (int i = 2; i < Math.sqrt(limit); i++) {
            
            if(sieve[i] == true) {
                for (int j = (int)Math.pow(i, 2); j < limit; j += i) {
                    sieve[j] = false;
                }
            }
            
        }
        
        return sieve;
    }
    
}
