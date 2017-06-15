package euler43_substringdivisibility;

import java.util.*;

/**
 *
 * @author Ben Walker
 */
public class Euler43_substringDivisibility {
    
    public static int[] primeDivisors = {2, 3, 5, 7, 11, 13, 17};
    
    public static void main(String[] args) {
        List<Long> pandigitals = new ArrayList<>();
        pandigitalPermutations("", "0123456789", pandigitals);
        
        System.out.println("SUM OF 0-9 PANDIGITALS WITH INTERESTING PROPERTY: " + sumList(pandigitals));
    }
    
    private static long sumList (List<Long> list) {
        long sum = 0L;
        
        for (long number : list)
            sum += number;
        
        return sum;
    }
    
    private static void pandigitalPermutations (String prefix, String number, List<Long> list) {
        int n = number.length();
        
        if (n == 0) {
            boolean add = true;
            
            for(int i = 1; i <= 7; i++) {
                long num = Long.valueOf(prefix.substring(i, i + 3));
                
                if(num % primeDivisors[i - 1] != 0)
                    add = false;
            }
            
            if(add)
                list.add(Long.valueOf(prefix));
        }
        
        else {
            for (int i = 0; i < n; i++)
                pandigitalPermutations(prefix + number.charAt(i), number.substring(0, i) + number.substring(i+1, n), list);
        }
    }
    
}
