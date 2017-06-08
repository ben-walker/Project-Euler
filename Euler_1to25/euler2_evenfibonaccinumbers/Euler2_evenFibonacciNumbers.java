package euler2_evenfibonaccinumbers;

/**
 *
 * @author Ben Walker
 */
public class Euler2_evenFibonacciNumbers {

    public static void main(String[] args) {
        int term1 = 1;
        int term2 = 2;
        int currentTerm = term2;
        int total = 0;
        
        while (currentTerm <= 4000000) {
            if((currentTerm % 2) == 0)
                total += currentTerm;
            
            currentTerm = term1 + term2;
            term1 = term2;
            term2 = currentTerm;
        }
        
        System.out.println("TOTAL: " + total);
    }
    
}
