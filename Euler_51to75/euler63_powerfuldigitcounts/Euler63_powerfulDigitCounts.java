package euler63_powerfuldigitcounts;

import java.math.BigInteger;

/**
 *
 * @author Ben Walker
 */
public class Euler63_powerfulDigitCounts {

    public static void main(String[] args) {
        System.out.println("ALL POSITIVE INTEGER POWERFUL DIGITS: " + findAllPowerfulDigits());
    }
    
    private static int findAllPowerfulDigits () {
        int counter = 0;
        
        for (int i = 1; i <= 100; i ++) {
            for (int j = 1; j <= 100; j++) {
                if(isPowerfulDigit(i, j))
                    counter ++;
            }
        }
        
        return counter;
    }
    
    private static boolean isPowerfulDigit (int base, int exp) {
        BigInteger BASE = BigInteger.valueOf(base);
        String result = BASE.pow(exp).toString();
        return result.length() == exp;
    }
    
}
