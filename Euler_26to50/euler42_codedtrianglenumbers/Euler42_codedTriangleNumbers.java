package euler42_codedtrianglenumbers;

import java.io.*;
import java.util.*;

/**
 *
 * @author Ben Walker
 */
public class Euler42_codedTriangleNumbers {

    public static String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
    public static final String PATH = "p042_words.txt";
    public static List<String> words = new ArrayList<>();
    
    public static void main(String[] args) {
        getWords();
        List<Integer> wordValues = getWordValues();
        Set<Integer> triangleNumbers = getTriangleNumbersUpTo(Collections.max(wordValues));
        
        wordValues.retainAll(triangleNumbers);
        System.out.println(wordValues.size() + " WORDS ARE EQUAL TO TRIANGLE NUMBERS.");
    }
    
    private static void getWords () {
        String line = readFileLine(PATH);
        line = line.replaceAll("\"", "");
        
        words = Arrays.asList(line.split(","));
    }
    
    private static List<Integer> getWordValues () {
        List<Integer> wordValues = new ArrayList<>();
        
        for(String word : words)
            wordValues.add(getWordValue(word));
        
        return wordValues;
    }
    
    private static Set<Integer> getTriangleNumbersUpTo (int maxNum) {
        Set<Integer> triangleNumbers = new LinkedHashSet<>();
        Double triangleNumber = 0.0;
        int index = 1;
        
        while (triangleNumber < maxNum) {
            triangleNumber = (0.5 * index) * (index + 1);
            triangleNumbers.add(triangleNumber.intValue());
            index ++;
        }
        
        return triangleNumbers;
    }
    
    private static String readFileLine (String path) {
        String filePath = new File("").getAbsolutePath().concat("/" + path);
        String line = "";
        
        try {
            FileReader fileReader = new FileReader(filePath);
            BufferedReader buffer = new BufferedReader(fileReader);
            return buffer.readLine();
            
        } catch (FileNotFoundException ex) {
            System.out.println("Could not find file " + path);
        } catch (IOException ex) {
            System.out.println("Error reading from file " + path);
        }
        
        return line;
    }
    
    private static int getWordValue (String word) {
        int wordValue = 0;
        word = word.toLowerCase();
        
        for (char letter : word.toCharArray()) {
            wordValue += ALPHABET.indexOf(letter) + 1;
        }
        
        return wordValue;
    }
    
}
