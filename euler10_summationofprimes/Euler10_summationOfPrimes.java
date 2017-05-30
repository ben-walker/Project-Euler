package euler10_summationofprimes;

/**
 *
 * @author BenWalker
 */
public class Euler10_summationOfPrimes {

    public static void main(String[] args) {
        long total = 0L;
        
        for (long i = 1L; i < 2000000L; i++) {
            if(isPrime(i))
                total += i;
        }
        
        System.out.println("SUM OF ALL PRIME NUMBERS BELOW 2,000,000: " + total);
    }
    
    public static boolean isPrime (long num) {
        if(num == 1)
            return false;
        if(num == 2 || num == 3)
            return true;
        if(num % 2 == 0)
            return false;
        
        for (int i = (int)Math.sqrt(num); i > 1; i--) {
            if(num % i == 0)
                return false;
        }
        
        return true;
        
    }
    
}
