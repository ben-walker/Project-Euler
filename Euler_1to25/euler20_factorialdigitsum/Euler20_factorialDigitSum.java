package euler20_factorialdigitsum;

import java.math.BigInteger;

/**
 *
 * @author Ben Walker
 */
public class Euler20_factorialDigitSum {

    public static void main(String[] args) {
        int factorialNumber = 100;
        BigInteger factorial = getFactorial(factorialNumber);
        System.out.println("SUM OF DIGITS IN FACTORIAL OF " + factorialNumber + ": " + getSumOfDigits(factorial));
    }
    
    private static BigInteger getFactorial (int startNumber) {
        BigInteger factorial = new BigInteger("1");
        
        for (int i = startNumber; i > 0; i--) {
            factorial = factorial.multiply(new BigInteger(String.valueOf(i)));
        }
        
        return factorial;
    }
    
    private static long getSumOfDigits (BigInteger number) {
        long sum = 0L;
        
        for (char digit : number.toString().toCharArray()) {
            sum += Character.getNumericValue(digit);
        }
        
        return sum;
    }
    
}
