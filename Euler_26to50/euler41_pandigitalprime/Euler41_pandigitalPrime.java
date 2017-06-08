package euler41_pandigitalprime;

/**
 *
 * @author Ben Walker
 */
public class Euler41_pandigitalPrime {

    public static long pandigitalPrime = 0L;
    
    public static void main(String[] args) {
        findLargestPandigitalPrime();
        System.out.println("LARGEST PANDIGITAL PRIME: " + pandigitalPrime);
    }
    
    private static void findLargestPandigitalPrime () {
        String startString = "987654321";
        
        while (pandigitalPrime == 0L && startString.length() != 0) {
            pandigitalPermutations("", startString);
            startString = startString.substring(1);
        }
    }

    private static void pandigitalPermutations (String prefix, String number) {
        int n = number.length();
        
        if (n == 0) {
            long value = Long.valueOf(prefix);
            if(isPrime(value) && value > pandigitalPrime)
                pandigitalPrime = value;
        }
        
        else {
            for (int i = 0; i < n; i++)
                pandigitalPermutations(prefix + number.charAt(i), number.substring(0, i) + number.substring(i+1, n));
        }
    }
    
    private static boolean isPrime (long num) {
        if(num == 1)
            return false;
        if(num == 2 || num == 3)
            return true;
        if(num % 2 == 0)
            return false;
        
        for (int i = (int)Math.sqrt(num); i > 1; i--) {
            if(num % i == 0)
                return false;
        }
        
        return true;
    }
    
}
