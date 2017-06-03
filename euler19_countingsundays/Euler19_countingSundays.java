package euler19_countingsundays;

import java.util.*;

/**
 *
 * @author Ben Walker
 */
public class Euler19_countingSundays {
    
    public static int startYear = 1901;
    public static int endYear = 2000;
    
    public static void main(String[] args) {
        System.out.println("NUMBER OF SUNDAYS ON THE FIRST OF A MONTH BETWEEN 1901 AND 2000: " + countSundays());
    }
    
    private static int countSundays () {
        Calendar calendar = Calendar.getInstance();
        int sundayCount = 0;
        
        for (int year = startYear; year <= endYear; year++) {
            for (int month = 1; month <= 12; month++) {
                calendar.set(year, month, 1);
                if(calendar.get(Calendar.DAY_OF_WEEK) == 7)
                    sundayCount ++;
            }
        }
        
        return sundayCount;
    }
    
}
