package euler35_circularprimes;

/**
 *
 * @author Ben Walker
 */
public class Euler35_circularPrimes {

    public static void main(String[] args) {
        System.out.println("THERE ARE " + findCircularPrimesBelow(1000000) + " CIRCULAR PRIMES BELOW 1000000.");
    }
    
    private static int findCircularPrimesBelow (long limit) {
        int circularPrimeCount = 0;
        
        for (long i = 1L; i < limit; i++) {
            if(isCircularPrime(i))
                circularPrimeCount ++;
        }
        
        return circularPrimeCount;
    }
    
    private static boolean isCircularPrime (long num) {
        String numberString = Long.toString(num);
        
        for (int i = 0; i < numberString.length(); i++) {
            numberString = numberString.charAt(numberString.length() - 1) + numberString.substring(0, numberString.length() - 1);
            if(!isPrime(Long.parseLong(numberString)))
                return false;
        }
        
        return true;
    }
    
    private static boolean isPrime (long num) {
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
