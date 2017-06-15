package euler44_pentagonnumbers;

import java.util.*;

/**
 *
 * @author Ben Walker
 */
public class Euler44_pentagonNumbers {

    public static void main(String[] args) {
        List<Integer> pentagons = getPentagons(2500);
        int difference = findPentagonalDifference(pentagons);
        System.out.println("SMALLEST DIFFERENCE: " + difference);
    }
    
    private static int findPentagonalDifference (List<Integer> pentagons) {
        for (int pentagon1 : pentagons) {
            
            for (int pentagon2 : pentagons) {
                int sum = pentagon1 + pentagon2;
                int difference = Math.abs(pentagon1 - pentagon2);
                
                if(pentagons.contains(sum) && pentagons.contains(difference))
                    return difference;
            }
            
        }
        
        return -1;
    }
    
    private static List<Integer> getPentagons (int limit) {
        List<Integer> pentagons = new ArrayList<>();
        
        for (int i = 1; i <= limit; i++) {
            double mid = (3 * i - 1) / 2.0;
            pentagons.add((int)(i * mid));
        }
        
        return pentagons;
    }
    
}
