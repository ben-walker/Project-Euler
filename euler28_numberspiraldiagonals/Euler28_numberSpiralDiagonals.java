package euler28_numberspiraldiagonals;

import java.math.BigInteger;
import java.util.*;

/**
 *
 * @author Ben Walker
 */
public class Euler28_numberSpiralDiagonals {
    
    public static void main(String[] args) {
        long area = computeSpiralArea(1001, 1001);
        List<Integer> diagonals = getSpiralDiagonals(area);
        System.out.println("SUM OF ALL DIAGONALS IN 1001 x 1001 SPIRAL: " + sumDiagonals(diagonals));
    }
    
    private static long computeSpiralArea (int x, int y) {
        return x * y;
    }
    
    private static List<Integer> getSpiralDiagonals (long spiralArea) {
        List<Integer> diagonalValues = new ArrayList<>();
        diagonalValues.add(1);
        int loopIterate = 2;
        int diagonalValueCount = 0;
        
        for (int i = 3; i <= spiralArea; i += loopIterate) {
            diagonalValues.add(i);
            diagonalValueCount ++;
            
            if(diagonalValueCount == 4) {
                diagonalValueCount = 0;
                loopIterate += 2;
            }
        }
        
        return diagonalValues;
    }
    
    private static BigInteger sumDiagonals (List<Integer> diagonals) {
        BigInteger sum = BigInteger.valueOf(0);
        
        for (int diagonal : diagonals)
            sum = sum.add(BigInteger.valueOf(diagonal));
        
        return sum;
    }
    
}
