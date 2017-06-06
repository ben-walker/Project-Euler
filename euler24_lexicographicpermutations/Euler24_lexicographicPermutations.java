package euler24_lexicographicpermutations;

import java.util.*;

/**
 *
 * @author Ben Walker
 */
public class Euler25_lexicographicPermutations {

    public static String number = "0123456789";
    
    public static void main(String[] args) {
        List<String> permutations = findAllPermutations();
        System.out.println("ONE MILLIONTH LEXICOGRAPHIC PERMUTATION OF 0123456789: " + permutations.get(999999));
    }
    
    private static List<String> findAllPermutations () {
        int rightmostIndex;
        int ceilingIndex;
        
        String permutation = number;
        List<String> permutations = new ArrayList<>();
        permutations.add(permutation);
        
        for (int i = 0; i < getNumberPermutations(number.length()) - 1; i++) {
            rightmostIndex = indexOfRightmostSmallerThanNext(permutation);
            ceilingIndex = indexOfCeiling(permutation, rightmostIndex);
            
            permutation = swap(permutation, rightmostIndex, ceilingIndex);
            permutation = sortPermutation(permutation, rightmostIndex);
            permutations.add(permutation);
        }
        
        return permutations;
    }
    
    private static int indexOfRightmostSmallerThanNext (String number) {
        int index = -1;
        
        for (int i = number.length() - 2; i >= 0; i--) {
            if(Character.getNumericValue(number.charAt(i)) < Character.getNumericValue(number.charAt(i + 1))) {
                index = i;
                break;
            }
        }
        
        return index;
    }
    
    private static int indexOfCeiling (String number, int index) {
        int smallest = 0;
        int ceilingIndex = -1;
        
        for (int i = index + 1; i < number.length(); i++) {
            int indexValue = Character.getNumericValue(number.charAt(i));
            if((indexValue < smallest && indexValue > Character.getNumericValue(number.charAt(index))) || smallest == 0) {
                smallest = Character.getNumericValue(number.charAt(i));
                ceilingIndex = i;
            }
        }
        
        return ceilingIndex;
    }
    
    private static String swap (String word, int firstIndex, int secondIndex) {
        char[] letters = word.toCharArray();
        
        char temp = letters[firstIndex];
        letters[firstIndex] = letters[secondIndex];
        letters[secondIndex] = temp;
        
        return new String(letters);
    }
    
    private static String sortPermutation (String permutation, int indexToSortAfter) {
        char[] permutationArray = permutation.toCharArray();
        char[] partToSort = Arrays.copyOfRange(permutationArray, indexToSortAfter + 1, permutationArray.length);
        Arrays.sort(partToSort);
        char[] partToNotSort = Arrays.copyOfRange(permutationArray, 0, indexToSortAfter + 1);
        
        StringBuilder builder = new StringBuilder(64);
        builder.append(partToNotSort);
        builder.append(partToSort);
        
        return builder.toString();
    }
    
    private static int getNumberPermutations (int numberOfDigits) {
        int total = 1;
        
        for (int i = 1; i <= numberOfDigits; i++)
            total *= i;
        
        return total;
    }
    
}
