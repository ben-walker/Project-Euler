package euler32_pandigitalproducts;

import java.util.*;

/**
 *
 * @author Ben Walker
 */
public class Euler32_pandigitalProducts {

    public static void main(String[] args) {
        Set<Long> products = findPandigitalProducts();
        long pandigitalSum = setSummer(products);
        System.out.println("SUM OF ALL PANDIGITAL PRODUCTS: " + pandigitalSum);
    }
    
    private static Set<Long> findPandigitalProducts () {
        Set<Long> products = new HashSet<>();
        
        for (int a = 1; a <= 100; a++) {
            if(isCandidate(a)) {
                for (int b = 1; b <= 9999; b++) {
                    if(isCandidate(b)) {
                        long product = a * b;
                        if(isPandigital(String.valueOf(a) + String.valueOf(b) + String.valueOf(product)))
                            products.add(product);
                    }
                }
            }
        }
        
        return products;
    }
    
    private static long setSummer (Set<Long> numbers) {
        long sum = 0;
        
        for (long number : numbers)
            sum += number;
        
        return sum;
    }
    
    private static boolean isPandigital (String number) {
        if(number.contains("0"))
            return false;
        
        for (int i = 1; i <= 9; i++) {
            int occurences = number.length() - number.replace(String.valueOf(i), "").length();
            if(occurences != 1)
                return false;
        }
        
        return true;
    }
    
    private static boolean isCandidate (int number) {
        String numberString = String.valueOf(number);
        if(numberString.contains("0"))
            return false;
        
        for (int i = 1; i <= 9; i++) {
            int occurences = numberString.length() - numberString.replace(String.valueOf(i), "").length();
            if(occurences > 1)
                return false;
        }
        
        return true;
    }
    
}
