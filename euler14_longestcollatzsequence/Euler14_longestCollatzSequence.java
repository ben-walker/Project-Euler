package euler14_longestcollatzsequence;

/**
 *
 * @author Ben Walker
 */
public class Euler14_longestCollatzSequence {

    public static void main(String[] args) {
        int longestCollatz = findLongestCollatz(1000000);
        System.out.println("LONGEST COLLATZ SEQUENCE BELOW 1 000 000: " + longestCollatz);
    }
    
    private static int findLongestCollatz (long maxNumber) {
        int chainLength, longestChainLength = 0;
        int longestCollatz = 0;
        
        for (int i = 1; i < maxNumber; i++) {
            chainLength = findCollatzChainLength(i);
            if(chainLength > longestChainLength) {
                longestCollatz = i;
                longestChainLength = chainLength;
            }
        }
        
        return longestCollatz;
    }
    
    private static int findCollatzChainLength (int number) {
        int collatzLength = 1;
        long collatzNumber = number;
        
        while (collatzNumber != 1) {
            if(collatzNumber % 2 == 0)
                collatzNumber = collatzNumber / 2;
            else
                collatzNumber = (3 * collatzNumber) + 1;
            collatzLength ++;
        }
        
        return collatzLength;
    }
    
}
