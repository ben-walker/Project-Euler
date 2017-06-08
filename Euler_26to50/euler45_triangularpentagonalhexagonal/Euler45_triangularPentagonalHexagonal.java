package euler45_triangularpentagonalhexagonal;

import java.util.*;

/**
 *
 * @author Ben Walker
 */
public class Euler45_triangularPentagonalHexagonal {

    public static List<Long> pentagons;
    
    public static void main(String[] args) {
        System.out.println("NEXT TRIANGULAR NUMBER AFTER INDEX 286 THAT IS PENTAGONAL AND HEXAGONAL: " + findNextTriangular(286, 100000));
    }
    
    private static long findNextTriangular (int start, int end) {
        for (int i = start; i <= end; i++) {
            long triangular = calculateTriangular(i);
            
            if(isPentagonal(triangular) && isHexagonal(i))
                return triangular;
        }
        
        return -1;
    }
    
    private static boolean isPentagonal (long number) {
        double value = (Math.sqrt(24 * number + 1) + 1) / 6;
        return value == (int)value && value > 0;
    }
    
    private static boolean isHexagonal (long number) {
        return number % 2 != 0;
    }
    
    private static long calculateTriangular (long n) {
        return (n * (n + 1)) / 2;
    }
    
}
