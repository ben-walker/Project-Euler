package euler53_combinatoricselections;

import java.math.BigInteger;

/**
 *
 * @author Ben Walker
 */
public class Euler53_combinatoricSelections {

    public static void main(String[] args) {
        int combinatronics = findCombinatronicsOver(1000000, 100);
        System.out.println("COMBINATRONICS OVER 1,000,000: " + combinatronics);
    }
    
    private static int findCombinatronicsOver (int threshold, int limit) {
        int combinatronicCount = 0;
        BigInteger THRESHOLD = BigInteger.valueOf(threshold);
        
        for (int n = 1; n <= limit; n++) {
            for (int r = 1; r < n; r ++) {
                if(combinatronic(n, r).compareTo(THRESHOLD) == 1)
                    combinatronicCount ++;
            }
        }
        
        return combinatronicCount;
    }
    
    private static BigInteger combinatronic (int n, int r) {
        BigInteger numerator = factorial(n);
        BigInteger denominator = factorial(r).multiply(factorial(n - r));
        
        return numerator.divide(denominator);
    }
    
    private static BigInteger factorial (int n) {
        BigInteger factorial = BigInteger.valueOf(1);
        
        for (int i = n; i > 0; i--) {
            factorial = factorial.multiply(BigInteger.valueOf(i));
        }
        
        return factorial;
    }
    
}
