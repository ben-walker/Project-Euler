package euler34_digitfactorials;

/**
 *
 * @author Ben Walker
 */
public class Euler34_digitFactorials {

    public static void main(String[] args) {
        System.out.println("SUM OF ALL NUMBERS THAT CAN BE WRITTEN AS THE SUM OF THEIR FACTORIALS: " + getSumOfFactorialNumbers());
    }
    
    private static long getSumOfFactorialNumbers () {
        long sum = 0;
        
        for (long i = 3L; i <= 1000000L; i++) {
            if(getNumberAsFactorialSum(i) == i)
                sum += i;
        }
        
        return sum;
    }
    
    private static long getNumberAsFactorialSum (long number) {
        char[] digits = String.valueOf(number).toCharArray();
        long sum = 0;
        
        for (char digit : digits) {
            sum += getFactorial(Character.getNumericValue(digit));
        }
        
        return sum;
    }
    
    private static long getFactorial (int number) {
        long factorial = 1L;
        
        for (int i = number; i > 1; i--)
            factorial *= i;
        
        return factorial;
    }
    
}
