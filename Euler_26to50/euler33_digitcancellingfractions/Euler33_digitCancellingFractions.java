package euler33_digitcancellingfractions;

import java.util.*;

/**
 *
 * @author Ben Walker
 */
public class Euler33_digitCancellingFractions {

    public static void main(String[] args) {
        List<Integer> numerators = new ArrayList<>();
        List<Integer> denominators = new ArrayList<>();
        
        findDigitCancellingFractions(numerators, denominators);
        int numerator = multiplyFraction(numerators);
        int denominator = multiplyFraction(denominators);
        int commonFactor = gcd(numerator, denominator);
        
        numerator /= commonFactor;
        denominator /= commonFactor;
        
        System.out.println("PRODUCT OF THE FOUR ANOMALOUS CANCELLATIONS: " + numerator + " / " + denominator);
        
    }
    
    private static int gcd (int a, int b) {
        if(a == 0 || b == 0)
            return a + b;
        return gcd(b, a % b);
    }
    
    private static int multiplyFraction (List<Integer> fraction) {
        int fractionProduct = 1;
        
        for (int i = 0; i < fraction.size(); i++) {
            fractionProduct *= fraction.get(i);
        }
        
        return fractionProduct;
    }
    
    private static void findDigitCancellingFractions (List<Integer> numerators, List<Integer> denominators) {
        for (double i = 10; i < 100; i++) {
            
            for (double j = i + 1; j < 100; j++) {
                String numerator = String.valueOf(i).substring(0, 1);
                String denominator = String.valueOf(j).substring(1, 2);
                
                String iCancel = String.valueOf(i).substring(1, 2);
                String jCancel = String.valueOf(j).substring(0, 1);
                
                if((i / j) == (Double.valueOf(numerator) / Double.valueOf(denominator)) && iCancel.equals(jCancel)) {
                    numerators.add((int)i);
                    denominators.add((int)j);
                }
            }
            
        }
    }
    
}
