package euler48_selfpowers;

import java.math.BigInteger;

/**
 *
 * @author Ben Walker
 */
public class Euler48_selfPowers {

    public static void main(String[] args) {
        BigInteger sum = sumOfSelfPowers(1000);
        BigInteger lastDigits = getLastTenDigits(sum);
        System.out.println("LAST TEN DIGITS: " + lastDigits);
    }
    
    private static BigInteger sumOfSelfPowers (int limit) {
        BigInteger sum = BigInteger.valueOf(0);
        
        for (int i = 1; i <= limit; i++) {
            sum = sum.add(BigInteger.valueOf(i).pow(i));
        }
        
        return sum;
    }
    
    private static BigInteger getLastTenDigits (BigInteger number) {
        return number.mod(new BigInteger("10000000000"));
    }
    
}
