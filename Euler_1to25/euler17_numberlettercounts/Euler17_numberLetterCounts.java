package euler17_numberlettercounts;

import java.util.*;

/**
 *
 * @author Ben Walker
 */
public class Euler17_numberLetterCounts {

    public static Map<Integer, String> basicNumbers;
    
    public static void main(String[] args) {
        loadBasicNumbers();
        System.out.println("NUMBER OF LETTERS COUNTING FROM 1 TO 1000: " + countNumberOfLetters(1, 1000));
    }
    
    private static long countNumberOfLetters (int startNumber, int endNumber) {
        long numberLetterSum = 0L;
        
        for (int i = startNumber; i <= endNumber; i++) {
            numberLetterSum += numberOfLetters(i);
        }
        
        return numberLetterSum;
    }
    
    private static int numberOfLetters (int number) {
        int numberLetters = 0;
        
        if(number < 20)
            numberLetters = basicNumbers.get(number).length();
        
        else if(number < 100)
            numberLetters = getTens(number) + getOnes(number);
        
        else if(number < 1000) {
            numberLetters += getHundreds(number);
            
            if(number % 100 < 20)
                numberLetters += basicNumbers.get(number % 100).length();
            else
                numberLetters += getTens(number) + getOnes(number);
            
            if(getOnes(number) != 0 || getTens(number) != 0)
                numberLetters += "and".length();
        }
        
        else if(number == 1000)
            numberLetters += getThousand(number);
        
        return numberLetters;
    }
    
    private static int getThousand (int number) {
        return basicNumbers.get((number - (number % 1000)) / 1000).length() + basicNumbers.get(1000).length();
    }
    
    private static int getHundreds (int number) {
        return basicNumbers.get((number - (number % 100)) / 100).length() + basicNumbers.get(100).length();
    }
    
    private static int getTens (int number) {
        return basicNumbers.get((number % 100) - (number % 10)).length();
    }
    
    private static int getOnes (int number) {
        return basicNumbers.get(number % 10).length();
    }
    
    private static void loadBasicNumbers () {
        basicNumbers = new HashMap<>();
        
        basicNumbers.put(0, "");
        basicNumbers.put(1, "one");
        basicNumbers.put(2, "two");
        basicNumbers.put(3, "three");
        basicNumbers.put(4, "four");
        basicNumbers.put(5, "five");
        basicNumbers.put(6, "six");
        basicNumbers.put(7, "seven");
        basicNumbers.put(8, "eight");
        basicNumbers.put(9, "nine");
        basicNumbers.put(10, "ten");
        basicNumbers.put(11, "eleven");
        basicNumbers.put(12, "twelve");
        basicNumbers.put(13, "thirteen");
        basicNumbers.put(14, "fourteen");
        basicNumbers.put(15, "fifteen");
        basicNumbers.put(16, "sixteen");
        basicNumbers.put(17, "seventeen");
        basicNumbers.put(18, "eighteen");
        basicNumbers.put(19, "nineteen");
        
        basicNumbers.put(20, "twenty");
        basicNumbers.put(30, "thirty");
        basicNumbers.put(40, "forty");
        basicNumbers.put(50, "fifty");
        basicNumbers.put(60, "sixty");
        basicNumbers.put(70, "seventy");
        basicNumbers.put(80, "eighty");
        basicNumbers.put(90, "ninety");
        
        basicNumbers.put(100, "hundred");
        basicNumbers.put(1000, "thousand");
    }
    
}
