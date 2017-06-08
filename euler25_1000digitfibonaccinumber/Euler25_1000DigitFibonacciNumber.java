package euler25_1000digitfibonaccinumber;

import java.math.BigInteger;

/**
 *
 * @author Ben Walker
 */
public class Euler25_1000DigitFibonacciNumber {

    public static final int FIB11 = 89;
    public static final int FIB12 = 144;
    
    public static void main(String[] args) {
        System.out.println("INDEX OF FIRST FIBONACCI NUMBER WITH 1000 DIGITS: " + fibonacciIterator());
    }
    
    private static long fibonacciIterator () {
        BigInteger twoBack = new BigInteger(String.valueOf(FIB11));
        BigInteger oneBack = new BigInteger(String.valueOf(FIB12));
        BigInteger current = oneBack;
        long index = 12;
        
        while (numberOfDigits(current) < 1000) {
            current = oneBack.add(twoBack);
            twoBack = oneBack;
            oneBack = current;
            index ++;
        }
        
        return index;
    }
    
    private static int numberOfDigits (BigInteger number) {
        return number.toString().length();
    }
    
}
