package euler1_multiplesof3and5;

/**
 *
 * @author Ben Walker
 */
public class Euler1_multiplesOf3And5 {

    public static void main(String[] args) {
        int total = 0;
        final int LESS_THAN = 1000;
        
        for (int i = 3; i < LESS_THAN; i += 3) {
            if((i % 5) != 0)
                total += i;
        }
        
        for (int i = 5; i < LESS_THAN; i += 5) {
            total += i;
        }
        
        System.out.println("TOTAL: " + total);
    }
    
}
