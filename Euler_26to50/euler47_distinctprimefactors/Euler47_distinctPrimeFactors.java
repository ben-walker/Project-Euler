package euler47_distinctprimefactors;

import java.util.*;

/**
 *
 * @author Ben Walker
 */
public class Euler47_distinctPrimeFactors {

    public static void main(String[] args) {
        Boolean[] sieve = eratosthenesSieve(1000000);
        int firstNumber = findConsecutiveNumbersDistinctFactors(sieve, 4);
        System.out.println("FIRST NUMBER OF THE FIRST FOUR CONSECUTIVE NUMBERS TO HAVE FOUR DISTINCT PRIME FACTORS: " + firstNumber);
    }
    
    private static int findConsecutiveNumbersDistinctFactors (Boolean[] sieve, int consecutiveTarget) {
        Queue<List<Integer>> queue = new LinkedList<>();
        
        for (int i = 1; i <= 1000000; i++) {
            queue.add(getPrimeFactors(i, sieve));
            
            if(queue.size() > consecutiveTarget)
                queue.remove();
            
            if(checkQueue(queue, consecutiveTarget))
                return i - (queue.size() - 1);
        }
        
        return -1;
        
    }
    
    private static boolean checkQueue (Queue<List<Integer>> queue, int mandatorySize) {
        for(List<Integer> list : queue) {
            if(list.size() != mandatorySize)
                return false;
        }
        
        Set<List<Integer>> testSet = new HashSet<>(queue);
        return testSet.size() == queue.size();
    }
    
    private static List<Integer> getPrimeFactors (int number, Boolean[] sieve) {
        List<Integer> primeFactors = new ArrayList<>();
        
        for (int i = 2; i <= number / 2; i++) {
            if(number % i == 0 && sieve[i] == true)
                primeFactors.add(i);
        }
        
        return primeFactors;
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
    
}
