package euler30_digitfifthpowers;

import java.math.BigInteger;
import java.util.*;

/**
 *
 * @author Ben Walker
 */
public class Euler30_digitFifthPowers {

    public static void main(String[] args) {
        List<Integer> numbers = findAllFifthPowerNumbers();
        System.out.println("SUM OF ALL NUMBERS EQUAL TO THE SUMS OF THEIR DIGITS TO THE FIFTH POWER (PROBABLY): " + getSum(numbers));
    }
    
    private static long getSum (List<Integer> numbers) {
        long sum = 0L;
        
        for (int number : numbers)
            sum += number;
        
        return sum;
    }
    
    private static List<Integer> findAllFifthPowerNumbers () {
        List<Integer> numbers = new ArrayList<>();
        
        for (int i = 2; i <= 1000000; i++) {
            if(isSumOfFifthPowers(i))
                numbers.add(i);
        }
        
        return numbers;
    }
    
    private static boolean isSumOfFifthPowers (int number) {
        String numberString = Integer.toString(number);
        BigInteger sum = BigInteger.valueOf(0);
        long powerValue;
        
        for (char digit : numberString.toCharArray()) {
            powerValue = (long)Math.pow(Character.getNumericValue(digit), 5);
            
            if(powerValue >= number)
                return false;
            
            sum = sum.add(BigInteger.valueOf(powerValue));
        }
        
        return sum.equals(BigInteger.valueOf(number));
    }
    
}
