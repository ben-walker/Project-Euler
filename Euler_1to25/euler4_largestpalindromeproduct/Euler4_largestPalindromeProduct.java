package euler4_largestpalindromeproduct;

import java.util.*;

/**
 *
 * @author Ben Walker
 */
public class Euler4_largestPalindromeProduct {

    public static void main(String[] args) {
        List<Integer> palindromes = new ArrayList<>(getPalindrome());
        Collections.sort(palindromes);
        System.out.println("LARGEST PALINDROME: " + palindromes.get(palindromes.size()-1));
    }
    
    private static List<Integer> getPalindrome () {
        List<Integer> palindromes = new ArrayList<>();
        
        for (int i = 999; i > 0; i--) {
            for (int j = 999; j > 0; j--) {
                if(isPalindrome(i * j))
                    palindromes.add(i * j);
            }
        }
        return palindromes;
    }
    
    private static boolean isPalindrome (int num) {
        String palindrome = String.valueOf(num);
        String reversePalindrome = new StringBuilder(palindrome).reverse().toString();
        
        return palindrome.equals(reversePalindrome);
    }
    
}
