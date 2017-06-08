package euler27_quadraticprimes;

/**
 *
 * @author Ben Walker
 */
public class Euler27_quadraticPrimes {
    
    public static void main(String[] args) {
        System.out.println("PRODUCT OF QUADRATIC COEFFICIENTS THAT PRODUCE THE MOST PRIMES FOR CONSECUTIVE Ns: " + coefficientProductForMaximumPrimes());
    }
    
    private static long coefficientProductForMaximumPrimes () {
        int mostConsecutivePrimes = 0;
        int consecutivePrimes;
        long coefficientProduct = 0;
        
        for (int a = -999; a < 1000; a++) {
            for (int b = -1000; b <= 1000; b++) {
                consecutivePrimes = howManyConsecutivePrimes(a, b);
                
                if(consecutivePrimes > mostConsecutivePrimes) {
                    mostConsecutivePrimes = consecutivePrimes;
                    coefficientProduct = a * b;
                }
                
            }
        }
        
        return coefficientProduct;
    }
    
    private static int howManyConsecutivePrimes (int a, int b) {
        int n = 0;
        int primeCount = 0;
        
        while (isPrime(getQuadraticOutput(n, a, b))) {
            n ++;
            primeCount ++;
        }
        
        return primeCount;
    }
    
    private static long getQuadraticOutput (int n, int a, int b) {
        return (n * n) + (a * n) + b;
    }
    
    private static boolean isPrime (long number) {
        if(number  <= 1) return false;
        
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if((number % i) == 0)
                return false;
        }
        return true;
    }
    
}
