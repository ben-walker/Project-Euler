package euler12_highlydivisibletriangularnumber;

/**
 *
 * @author Ben Walker
 */
public class Euler12_highlyDivisibleTriangularNumber {

    public static void main(String[] args) {
        int numberOfFactors = 0;
        long currentNumber = 1L;
        long triangularNumber = 0L;
        
        while (numberOfFactors < 500) {
            triangularNumber = getTriangularNumber(currentNumber);
            numberOfFactors = findNumberOfFactors(triangularNumber, currentNumber);
            currentNumber ++;
        }
        
        System.out.println("FIRST TRIANGULAR NUMBER TO HAVE OVER 500 DIVISORS: " + triangularNumber);
    }
    
    private static long getTriangularNumber (long number) {        
        return number * (number + 1) / 2;
    }
    
    private static int findNumberOfFactors (long triangularNumber, long currentNumber) {        
        if(currentNumber % 2 == 0)
            return findDivisorsForEven(currentNumber);
        else
            return findDivisorsForOdd(currentNumber);
    }
    
    private static int findDivisorsForEven (long currentNumber) {
        long nDividedBy2 = currentNumber / 2;
        long nPlus1 = currentNumber + 1;
        
        int numberOfDivisorsA = 0, numberOfDivisorsB = 0;
        
        for (long i = 1L; i <= Math.sqrt(nDividedBy2); i++) {
            if(nDividedBy2 % i == 0)
                numberOfDivisorsA ++;
        }
        numberOfDivisorsA *= 2;
        
        for (long i = 1L; i <= Math.sqrt(nPlus1); i++) {
            if(nPlus1 % i == 0)
                numberOfDivisorsB ++;
        }
        numberOfDivisorsB *= 2;
        
        return numberOfDivisorsA * numberOfDivisorsB;
    }
    
    private static int findDivisorsForOdd (long currentNumber) {
        long n = currentNumber;
        long nPlus1DividedBy2 = (currentNumber + 1) / 2;
        
        int numberOfDivisorsA = 0, numberOfDivisorsB = 0;
        
        for (long i = 1L; i <= Math.sqrt(n); i++) {
            if(n % i == 0)
                numberOfDivisorsA ++;
        }
        numberOfDivisorsA *= 2;
        
        for (long i = 1L; i <= Math.sqrt(nPlus1DividedBy2); i++) {
            if(nPlus1DividedBy2 % i == 0)
                numberOfDivisorsB ++;
        }
        numberOfDivisorsB *= 2;
        
        return numberOfDivisorsA * numberOfDivisorsB;
    }
    
}
