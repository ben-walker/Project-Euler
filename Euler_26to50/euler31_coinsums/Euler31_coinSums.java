package euler31_coinsums;

/**
 *
 * @author Ben Walker
 */
public class Euler31_coinSums {

    public static int[] coins = {200, 100, 50, 20, 10, 5, 2, 1};
    
    public static void main(String[] args) {
        int combos = findNumberOfWaysToMake(coins[0]);
        System.out.println("NUMBER OF WAYS TO MAKE 2 POUNDS WITH 8 COINS: " + combos);
    }
    
    private static int findNumberOfWaysToMake (int pence) {
        return recurrentCoinSum(pence, coins.length - 1) + 1;
    }
    
    private static int recurrentCoinSum (int nPence, int kCoins) {
        if(kCoins < 1 || nPence < 0) return 0;
        if(nPence == 0) return 1;
        
        return recurrentCoinSum(nPence, kCoins - 1) + recurrentCoinSum(nPence - coins[kCoins], kCoins);
    }
    
}
