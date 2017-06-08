package euler9_specialpythagoreantriplet;

/**
 *
 * @author BenWalker
 */
public class Euler9_specialPythagoreanTriplet {

    public static void main(String[] args) {        
        long product = findSpecialTripletProduct();
        System.out.println("SPECIAL PYTHAGOREAN TRIPLET PRODUCT: " + product);
    }
    
    private static long findSpecialTripletProduct () {
        int a = 0, b, c;
        
        for (b = 0; b <= 1000; b++) {
            a = findSpecialA(b);
            if(a != -1)
                break;
        }
        
        c = 1000 - (a + b);
        return a * b * c;
    }
    
    private static int findSpecialA (int b) {
        long cSquared;
        
        for (int a = 0; a < b; a++) {
            cSquared = (a * a) + (b * b);
            
            if(a + b + Math.sqrt(cSquared) == 1000.0) {
                return a;
            }
        }
        
        return -1;
    }
    
}
