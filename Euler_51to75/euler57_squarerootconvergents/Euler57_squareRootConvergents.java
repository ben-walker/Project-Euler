package euler57_squarerootconvergents;

import java.math.BigInteger;
import java.util.*;

/**
 *
 * @author Ben Walker
 */
public class Euler57_squareRootConvergents {

    public static List<BigInteger> numerators = new ArrayList<>();
    public static List<BigInteger> denominators = new ArrayList<>();
    
    public static void main(String[] args) {
        numerators.add(BigInteger.valueOf(3));
        denominators.add(BigInteger.valueOf(2));
        
        getFractions();
        System.out.println("NUMBER OF EXPANSIONS < 1000 WITH LARGER NUMERATORS: " + findFractionsLargerNumerator());
    }
    
    private static int findFractionsLargerNumerator () {
        int count = 0;
        
        for (int i = 0; i < numerators.size(); i++) {
            if(numerators.get(i).toString().length() > denominators.get(i).toString().length())
                count ++;
        }
        
        return count;
    }
    
    private static void getFractions () {
        int expansions = 1;
        
        while (expansions < 1000) {
            denominators.add(numerators.get(numerators.size() - 1).add(denominators.get(denominators.size() - 1)));
            numerators.add(denominators.get(denominators.size() - 2).add(denominators.get(denominators.size() - 1)));
            expansions ++;
        }
    }
    
}
