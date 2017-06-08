package euler29_distinctpowers;

import java.math.BigInteger;
import java.util.*;

/**
 *
 * @author Ben Walker
 */
public class Euler29_distinctPowers {

    public static int[] A;
    public static int[] B;
    
    public static void main(String[] args) {
        loadA(2, 100);
        loadB(2, 100);
        Set<BigInteger> powerTerms = findAllPowerCombos();
        System.out.println(powerTerms.size() + " DISTINCT TERMS FOUND.");
    }
    
    private static Set<BigInteger> findAllPowerCombos () {
        Set<BigInteger> powerTerms = new HashSet<>();
        
        for (int a : A) {
            BigInteger aTerm = BigInteger.valueOf(a);
            for (int b : B) {
                powerTerms.add(aTerm.pow(b));
            }
        }
        
        return powerTerms;
    }
    
    private static void loadA (int lowRange, int highRange) {
        A = new int[highRange - lowRange + 1];
        int index = 0;
        
        for (int i = lowRange; i <= highRange; i++) {
            A[index] = i;
            index ++;
        }
    }
    
    private static void loadB (int lowRange, int highRange) {
        B = new int[highRange - lowRange + 1];
        int index = 0;
        
        for (int i = lowRange; i <= highRange; i++) {
            B[index] = i;
            index ++;
        }
    }
    
}
