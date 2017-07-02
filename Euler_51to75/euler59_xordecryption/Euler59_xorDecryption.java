package euler59_xordecryption;

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Ben Walker
 */
public class Euler59_xorDecryption {

    public static final String PATH = "p059_cipher.txt";
    public static final char[] ALPHA = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
                                        'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
    
    public static void main(String[] args) {
        String line = readFile();
        List<Integer> codes = parseLine(line);
        List<int[]> passwords = getPasswords();
        String text = decode(codes, passwords);
        
        System.out.println("SUM OF ASCII CODES IN THE DECODED TEXT: " + sumAsciiValuesOf(text));
    }
    
    private static int sumAsciiValuesOf (String text) {
        int sum = 0;
        
        for (char character : text.toCharArray())
            sum += (int) character;
        
        return sum;
    }
    
    private static String decode (List<Integer> codes, List<int[]> passwords) {
        StringBuilder sentence;
        Pattern pattern = Pattern.compile("^[ A-Za-z0-9./()!,;:']*$");
        Matcher matcher;
        
        for (int[] password : passwords) {
            int index = 0;
            sentence = new StringBuilder();
            
            for (int code : codes) {
                sentence.append((char) (password[index] ^ code));
                index ++;
                
                if(index == 3)
                    index = 0;
            }
            
            matcher = pattern.matcher(sentence);
            if(matcher.matches())
                return sentence.toString();
        }
        
        return "";
    }
    
    private static List<int[]> getPasswords () {
        List<int[]> passwords = new ArrayList<>();
        
        for (char letter1 : ALPHA) {
            for (char letter2 : ALPHA) {
                for (char letter3 : ALPHA)
                    passwords.add(new int[] {(int)letter1, (int)letter2, (int)letter3});
            }
        }
        
        return passwords;
    }
    
    private static List<Integer> parseLine (String line) {
        List<Integer> parsed = new ArrayList<>();
        
        for (String s : line.split(","))
            parsed.add(Integer.valueOf(s));
        
        return parsed;
    }
    
    private static String readFile () {
        String filePath = new File("").getAbsolutePath().concat("/" + PATH);
        String line = "";
        
        try {
            FileReader fileReader = new FileReader(filePath);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            
            line = bufferedReader.readLine();
            
        } catch (FileNotFoundException ex) {
            System.out.println("Could not find file: " + PATH);
        } catch (IOException ex) {
            System.out.println("Error reading from file: " + PATH);
        }
        
        return line;
    }
    
}
