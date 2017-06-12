package euler39_integerrighttriangles;

import java.util.*;

/**
 *
 * @author Ben Walker
 */
public class Euler39_integerRightTriangles {

    public static void main(String[] args) {
        List<Integer> perimeters = generateTrianglePerimeters();
        System.out.println("PYTHAGOREAN TRIANGLE PERIMETER BELOW 1000 FOR WHICH THE NUMBER OF SOLUTIONS IS MAXIMIZED: " + findMaximizedPerimeter(perimeters));
    }
    
    private static List<Integer> generateTrianglePerimeters () {
        List<Integer> perimeters = new ArrayList<>();
        
        for (int a = 1; a < 1000; a++) {
            for (int b = a + 1; b < 1000; b++) {
                double c = Math.sqrt(a * a + b * b);
                int perimeter = a + b + (int)c;
                
                if(c > b && c == Math.floor(c) && perimeter <= 1000)
                    perimeters.add(a + b + (int)c);
            }
        }
        
        return perimeters;
    }
    
    private static int findMaximizedPerimeter (List<Integer> perimeters) {
        int mostSolutions = 0;
        int maximizedPerimeter = 0;
        
        for (int perimeter : perimeters) {
            int solutions = Collections.frequency(perimeters, perimeter);
            if(solutions > mostSolutions) {
                mostSolutions = solutions;
                maximizedPerimeter = perimeter;
            }
        }
        
        return maximizedPerimeter;
    }
    
}
