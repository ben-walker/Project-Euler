package euler23_non.abundantsums;

import java.util.*;

/**
 *
 * @author Ben Walker
 */
public class Euler23_nonAbundantSums {
    
    public static Set<Integer> allNumbers = new HashSet<>();

    public static void main(String[] args) {
        Set<Integer> abundantNumbers = findAbundantNumbers(28123);
        Set<Integer> numbersFromAbundantSum = getAllNumbersFromAbundantSums(abundantNumbers);
        
        allNumbers.removeAll(numbersFromAbundantSum);
        System.out.println("SUM OF NUMBERS THAT CAN'T BE WRITTEN AS SUM OF ABUNDANT NUMBERS: " + sumNumberSet(allNumbers));
    }
    
    private static Set<Integer> findAbundantNumbers (int limit) {
        Set<Integer> abundantNumbers = new HashSet<>();
        
        for (int i = 1; i <= limit; i++) {
            allNumbers.add(i);
            if(sumNumberSet(getProperDivisors(i)) > i)
                abundantNumbers.add(i);
        }
        
        return abundantNumbers;
    }
    
    private static Set<Integer> getAllNumbersFromAbundantSums (Set<Integer> abundantNumbers) {
        Set<Integer> abundantSums = new HashSet<>();
        
        for (int abundant1 : abundantNumbers) {
            for (int abundant2 : abundantNumbers) {
                abundantSums.add(abundant1 + abundant2);
            }
        }
        
        return abundantSums;
    }
    
    private static Set<Integer> getProperDivisors (int number) {
        Set<Integer> properDivisors = new HashSet<>();
        if(number <= 1)
            return properDivisors;
        properDivisors.add(1);
        
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if(number % i == 0) {
                properDivisors.add(i);
                properDivisors.add(number / i);
            }
        }
        
        return properDivisors;
    }
    
    private static int sumNumberSet (Set<Integer> numbers) {
        int sum = 0;
        
        for (int number : numbers)
            sum += number;
        
        return sum;
    }
    
}
