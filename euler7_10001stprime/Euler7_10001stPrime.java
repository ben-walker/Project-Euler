package euler7_10001stprime;

/**
 *
 * @author Ben Walker
 */
public class Euler7_10001stPrime {

    public static void main(String[] args) {
        int currentNum = -1;
        int primeCounter = 0;
        
        while (primeCounter < 10001) {
            currentNum ++;
            
            if(isPrime(currentNum)) {
                primeCounter ++;
            }
        }
        
        System.out.println("10001st PRIME: " + currentNum);
        
    }
    
    private static boolean isPrime (long num) {
        if(num  <= 1) return false;
        
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if((num % i) == 0)
                return false;
        }
        return true;
    }
    
}
