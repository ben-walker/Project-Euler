package euler22_namesscores;

import java.io.*;
import java.math.BigInteger;
import java.util.*;

/**
 *
 * @author Ben Walker
 */
public class Euler22_namesScores {

    public static final String PATH = "p022_names.txt";
    public static List<String> names = new ArrayList<>();
    public static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
    
    public static void main(String[] args) {
        getNames();
        System.out.println("TOTAL OF ALL NAME SCORES: " + getNameScoreTotal());
    }
    
    private static BigInteger getNameScoreTotal () {
        BigInteger total = new BigInteger("0");
        
        for (int i = 0; i < names.size(); i++) {
            long value = (i + 1) * getNameScore(names.get(i));
            total = total.add(new BigInteger(String.valueOf(value)));
        }
        
        return total;
    }
    
    private static int getNameScore (String name) {
        int nameScore = 0;
        
        for (char letter : name.toCharArray())
            nameScore += ALPHABET.indexOf(Character.toLowerCase(letter)) + 1;
        
        return nameScore;
    }
    
    private static void getNames () {
        String line = readFileLine(PATH);
        line = line.replaceAll("\"", "");
        
        names = Arrays.asList(line.split(","));
        Collections.sort(names);
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
}
