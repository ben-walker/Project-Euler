package euler56_powerfuldigitsum;

import java.math.BigInteger;

/**
 *
 * @author Ben Walker
 */
public class Euler56_powerfulDigitSum {

    public static void main(String[] args) {
        System.out.println("MAXIMAL DIGIT SUM: " + findMaximalDigitSum());
    }
    
    private static int findMaximalDigitSum () {
        BigInteger result;
        int sum, largest = 0;
        
        for (int i = 1; i < 100; i++) {
            for (int j = 1; j < 100; j++) {
                result = BigInteger.valueOf(i).pow(j);
                sum = sumBigIntegerDigits(result);
                if(sum > largest)
                    largest = sum;
            }
        }
        
        return largest;
    }
    
    private static int sumBigIntegerDigits (BigInteger number) {
        char[] num = number.toString().toCharArray();
        int sum = 0;
        
        for (char i : num) {
            sum += Character.getNumericValue(i);
        }
        
        return sum;
    }
    
}
