package euler6_sumsquaredifference;

/**
 *
 * @author Ben Walker
 */
public class Euler6_sumSquareDifference {

    public static void main(String[] args) {
        int difference = Math.abs(squareOfSum() - sumOfSquares());
        System.out.println("SUM SQUARE DIFFERENCE: " + difference);
    }
    
    private static int sumOfSquares () {
        int total = 0;

        for (int i = 1; i <= 100; i++) {
            total += i*i;
        }
        
        return total;
    }
    
    private static int squareOfSum () {
        int total = 0;
        
        for (int i = 1; i <= 100; i++) {
            total += i;
        }
        
        return total * total;
    }
    
}
