package euler38_pandigitalmultiples;

import java.util.*;

/**
 *
 * @author Ben Walker
 */
public class Euler38_pandigitalMultiples {

    public static final int NOT_PAN = -1;
    public static final int IS_PAN = 0;
    public static final int NOT_YET_PAN = 1;
    
    public static void main(String[] args) {
        List<Long> pandigitals = findPandigitals();
        System.out.println("MAXIMUM PANDIGITAL MULTIPLE: " + Collections.max(pandigitals));
    }
    
    private static List<Long> findPandigitals () {
        List<Long> pandigitals = new ArrayList<>();
        String number = "";
        int index = 1;
        int pandigitalCheck = NOT_YET_PAN;
        
        for (int i = 1; i <= 1000000; i++) {
            
            while (pandigitalCheck == NOT_YET_PAN) {
                number += (i * index);
                pandigitalCheck = isPandigital(number);
                index ++;
            }

            if(pandigitalCheck == IS_PAN)
                pandigitals.add(Long.parseLong(number));
            
            number = "";
            index = 1;
            pandigitalCheck = NOT_YET_PAN;
        }
        
        return pandigitals;
    }
    
    private static int isPandigital (String number) {
        if(number.contains("0"))
            return NOT_PAN;
        
        for (int i = 1; i <= 9; i++) {
            int occurences = number.length() - number.replace(String.valueOf(i), "").length();
            if(occurences > 1)
                return NOT_PAN;
            if(occurences == 0)
                return NOT_YET_PAN;
        }
        
        return IS_PAN;
    }
    
}
