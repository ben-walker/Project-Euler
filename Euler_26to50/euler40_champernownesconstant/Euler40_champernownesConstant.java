package euler40_champernownesconstant;

/**
 *
 * @author Ben Walker
 */
public class Euler40_champernownesConstant {

    public static void main(String[] args) {
        StringBuilder champernownesNumber = getChampernowneString();
        long product = getProductFromChampernowne(champernownesNumber);
        System.out.println("PRODUCT OF CHAMPERNOWNE NUMBERS AT 1, 10, 100, 1000, 10000, 100000, AND 1000000: " + product);
    }
    
    private static StringBuilder getChampernowneString () {
        StringBuilder champernownesNumber = new StringBuilder("");
        int number = 1;
        
        while (champernownesNumber.length() < 1000000) {
            champernownesNumber.append(number);
            number ++;
        }
        
        return champernownesNumber;
    }
    
    private static long getProductFromChampernowne (StringBuilder number) {
        long product = 1L;
        
        for (int i = 1; i <= 1000000; i *= 10) {
            product *= Character.getNumericValue(number.charAt(i - 1));
        }
        
        return product;
    }
    
}
