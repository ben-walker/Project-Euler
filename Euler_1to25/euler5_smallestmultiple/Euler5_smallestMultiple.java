package euler5_smallestmultiple;

/**
 *
 * @author Ben Walker
 */
public class Euler5_smallestMultiple {

    public static void main(String[] args) {
        int RANGE = 20;
        int multiple = RANGE;
        
        while (true) {
            if(isMultiple(multiple))
                break;
            multiple += RANGE;
        }
        
        System.out.println("SMALLEST MULTIPLE: " + multiple);
    }
    
    private static boolean isMultiple (int multiple) {
        return((multiple % 20 == 0) && (multiple % 19 == 0) && (multiple % 18 == 0) &&
                (multiple % 17 == 0) && (multiple % 16 == 0) && (multiple % 15 == 0) &&
                (multiple % 14 == 0) && (multiple % 13 == 0) && (multiple % 12 == 0) &&
                (multiple % 11 == 0));
    }
    
}
