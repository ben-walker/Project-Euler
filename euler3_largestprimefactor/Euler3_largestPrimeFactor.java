package euler3_largestprimefactor;

/**
 *
 * @author Ben Walker
 */
public class Euler3_largestPrimeFactor {

    public static void main(String[] args) {
        long rawNum = 600851475143L;
        long largestPrime = largePrimeFind(rawNum);
        System.out.println("LARGEST PRIME: " + largestPrime);
    }
    
    private static long largePrimeFind (long rawNum) {
        long num;
        
        for (int i = 1; i <= rawNum; i++) {
            if((rawNum % i) == 0) {
                num = rawNum / i;
                if(isPrime(num)) {
                    return num;
                }
            }
        }
        return -1;
    }
    
    private static boolean isPrime (long num) {
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if((num % i) == 0)
                return false;
        }
        return true;
    }
    
}
