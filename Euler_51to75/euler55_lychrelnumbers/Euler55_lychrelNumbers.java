package euler55_lychrelnumbers;

import java.math.BigInteger;

/**
 *
 * @author Ben Walker
 */
public class Euler55_lychrelNumbers {

    public static void main(String[] args) {
        System.out.println("NUMBER OF LYCHREL NUMBERS BELOW 10000: " + findNumberOfLychrelsUnder(10000));
    }
    
    private static int findNumberOfLychrelsUnder (int limit) {
        int lychrelCounter = 0;
        
        for (int i = 1; i < 10000; i++) {
            if(isLychrel(i))
                lychrelCounter ++;
        }
        
        return lychrelCounter;
    }
    
    private static boolean isLychrel (int number) {
        BigInteger NUM = BigInteger.valueOf(number);
        
        NUM = NUM.add(reversed(NUM));
        int iterations = 1;
        
        while (!isPalindrome(NUM.toString()) && iterations < 50) {
            NUM = NUM.add(reversed(NUM));
            iterations ++;
        }
        
        return iterations == 50;
    }
    
    private static BigInteger reversed (BigInteger number) {
        String reverse = new StringBuilder(number.toString()).reverse().toString();
        return new BigInteger(reverse);
    }
    
    private static boolean isPalindrome (String candidate) {
        return candidate.equals(new StringBuilder(candidate).reverse().toString());
    }
    
}
