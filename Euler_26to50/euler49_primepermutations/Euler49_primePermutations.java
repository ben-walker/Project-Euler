package euler49_primepermutations;

import java.util.*;

/**
 *
 * @author Ben Walker
 */
public class Euler49_primePermutations {

    public static Set<List<Integer>> set = new HashSet<>();
    
    public static void main(String[] args) {
        Boolean[] primes = eratosthenesSieve(1000000);
        findIncreasingSequence(primes);
        
        System.out.println("ARITHMETIC SEQUENCES WHERE EACH TERM IS PRIME, AND EACH TERM IS A PERMUTATION OF THE FIRST:");
        for (List<Integer> list : set)
            System.out.println(getStringFromList(list));
    }
    
    private static void findIncreasingSequence (Boolean[] primes) {
        List<Integer> list = new ArrayList<>();
        
        for (int i = 1000; i < 10000; i++) {
            list.clear();
            
            if(primes[i] == true) {
                permutations("", String.valueOf(i), list, primes);
                Collections.sort(list);
                analyzeList(list);
            }
        }
    }
    
    private static void permutations (String prefix, String number, List<Integer> list, Boolean[] primes) {
        int n = number.length();
        
        if (n == 0) {
            int value = Integer.valueOf(prefix);
            
            if(!list.contains(value) && prefix.charAt(0) != '0' && primes[value] == true)
                list.add(Integer.valueOf(prefix));
        }
        
        else {
            for (int i = 0; i < n; i++)
                permutations(prefix + number.charAt(i), number.substring(0, i) + number.substring(i+1, n), list, primes);
        }
    }
    
    private static void analyzeList (List<Integer> list) {
        List<Integer> newList = new ArrayList<>();
        
        if(list.size() < 3)
            return;
        
        for (int i = 0; i < list.size(); i++) {
            
            for (int j = i + 1; j < list.size(); j++) {
                int current = list.get(i);
                int index = list.get(j) - current;
                
                if(list.contains(current + index) && list.contains(current + index * 2)) {
                    newList.add(current);
                    newList.add(current + index);
                    newList.add(current + index * 2);
                    set.add(newList);
                    return;
                }
            }
            
        }
    }
    
    private static String getStringFromList (List<Integer> list) {
        String str = "";
        
        for (int i : list)
            str = str.concat(String.valueOf(i));
        
        return str;
    }
    
    private static Boolean[] eratosthenesSieve (int limit) {
        Boolean[] primeFinder = new Boolean[limit];
        Arrays.fill(primeFinder, Boolean.TRUE);
        
        primeFinder[0] = false;
        primeFinder[1] = false;
        
        for (int i = 2; i < Math.sqrt(limit); i++) {
            
            if(primeFinder[i] == true) {
                for (int j = (int)Math.pow(i, 2); j < limit; j += i) {
                    primeFinder[j] = false;
                }
            }
            
        }
        
        return primeFinder;
    }
    
}
