package euler52_permutedmultiples;

import java.util.*;

/**
 *
 * @author Ben Walker
 */
public class Euler52_permutedMultiples {

    public static void main(String[] args) {
        System.out.println("SMALLEST PERMUTABLE INTEGER: " + findSmallestPermutableInteger());
    }
    
    private static int findSmallestPermutableInteger () {
        long initial, result;
        
        for (int i = 1; i < 1000000; i++) {
            initial = i * 2;
            
            for (int j = 3; j <= 6; j++) {
                result = i * j;
                
                if(!sameDigits(String.valueOf(initial), String.valueOf(result)))
                    break;
                if(j == 6)
                    return i;
            }
        }
        
        return -1;
    }
    
    private static boolean sameDigits (String num1, String num2) {
        char[] testNum1 = num1.toCharArray();
        char[] testNum2 = num2.toCharArray();
        Arrays.sort(testNum1);
        Arrays.sort(testNum2);
        
        num1 = Arrays.toString(testNum1);
        num2 = Arrays.toString(testNum2);

        return num1.equals(num2);
    }
    
}
