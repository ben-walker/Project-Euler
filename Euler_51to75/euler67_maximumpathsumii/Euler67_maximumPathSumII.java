package euler67_maximumpathsumii;

import java.io.*;
import java.util.*;

/**
 *
 * @author Ben Walker
 */
public class Euler67_maximumPathSumII {
    
    public static final String PATH = "p067_triangle.txt";
    
    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>();
        
        loadTriangle(triangle);
        System.out.println("MAXIMUM PATH SUM II: " + findMaxPath(triangle));
    }
    
    private static int findMaxPath (List<List<Integer>> triangle) {
        for (int i = triangle.size() - 2; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                triangle.get(i).set(j, triangle.get(i).get(j) + Math.max(triangle.get(i + 1).get(j), triangle.get(i + 1).get(j + 1)));
            }
        }
        
        return triangle.get(0).get(0);
    }
    
    private static void loadTriangle (List<List<Integer>> triangle) {
        String filePath = new File("").getAbsolutePath().concat("/" + PATH);
        
        try {
            FileReader fileReader = new FileReader(filePath);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            
            String line;
            List<Integer> list = new ArrayList<>();
            
            while ((line = bufferedReader.readLine()) != null) {
                for (String s : line.split(" ")) list.add(Integer.valueOf(s));
                triangle.add(list);
                list = new ArrayList<>();
            }
            
        } catch (FileNotFoundException ex) {
            System.out.println("Could not find file: " + PATH);
        } catch (IOException ex) {
            System.out.println("Error reading from file: " + PATH);
        }
    }
    
}
