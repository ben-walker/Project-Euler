package euler16_powerdigitsum;

import java.math.BigInteger;

/**
 *
 * @author Ben Walker
 */
public class Euler16_powerDigitSum {

    public static void main(String[] args) {
        BigInteger result = new BigInteger("2").pow(1000);
        System.out.println("SUM OF DIGITS OF 2 ^ 1000: " + sumDigits(result));
    }
    
    private static int sumDigits(BigInteger number) {
        int sum = 0;
        
        for (char digit : number.toString().toCharArray()) {
            sum += Character.getNumericValue(digit);
        }
        
        return sum;
    }
    
}
