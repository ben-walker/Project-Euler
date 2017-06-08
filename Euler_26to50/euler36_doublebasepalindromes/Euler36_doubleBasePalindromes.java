package euler36_doublebasepalindromes;

/**
 *
 * @author Ben Walker
 */
public class Euler36_doubleBasePalindromes {

    public static void main(String[] args) {
        long sum = sumOfPalindromesInTwoBases(1000000);
        System.out.println("SUM OF DOUBLE BASE PALINDROMES: " + sum);
    }
    
    private static long sumOfPalindromesInTwoBases (long limit) {
        long sum = 0;
        
        for (long i = 1L; i < limit; i++) {
            if(isPalindromicTwoBases(i))
                sum += i;
        }
        
        return sum;
    }
    
    private static boolean isPalindromicTwoBases (long number) {
        String decimalString = String.valueOf(number);
        String decimalReverse = new StringBuilder(decimalString).reverse().toString();
        
        String binaryString = Long.toString(number, 2);
        String binaryReverse = new StringBuilder(binaryString).reverse().toString();
        
        return decimalString.equals(decimalReverse) && binaryString.equals(binaryReverse);
    }
    
}
