# The min change

this algorithm try to find mininum number of coins to make the target amount value.

For exampple, the amount is 4, and you have coins 1,2 and 3.
Then, try to make the number 4 with the minimun number of coins.
In this case 1,3 can be make.(It will be the shortest path.)

# Time Complexity

## Without Memoization

Time: O(C power of a)
Space: O(a)

## The Brute Force

Time: O(C x a)
Space: O(a)

# The Brute Force Code

```Java
import java.util.*;

public class Main {
  public static void main(String[] args) {
    List<Integer> coins = new ArrayList<>();
    coins.add(50);
    coins.add(100);
    coins.add(500);

    // Let's try to find the minimum counter of coins for the amount.
    minChange(1000,coins);
  }

  public static int minChange(int amount, List<Integer> coins){
    //reach the usable value
    if(amount == 0){
      return 0;
    }

    if(amount < 0){
      return -1;
    }

    int minCoins = -1; // The number of min Coins;
    for(int coin : coins) {
      // the substraction will accumulated through the algorithm. When the value meet zero, all the algorithm will be finished.
      int subAmount = amount - coin;
      // When the value meet zero, subCoin variable will have zero as well.
      int subCoins = minChange(subAmount, coins); // count of coins
      // If the subAmount is not negative number, It need to be counted
      if(subCoins != -1){
        int numCoins = subCoins + 1; // sub coins plus current(+1) count.
        if(numCoins < minCoins || minCoins == -1){
          minCoins = numCoins;
        }
      }
    }
    return minCoins;
  }

  public static int minChangeWithMemoization(int amount, List<Integer> coins, HashMap<Integer,Integer> memo){
    if(amount == 0){
      return 0;
    }

    if(amount < 0){
      return -1;
    }

    if(memo.containsKey(amount)){
      return memo.get(amount);
    }

    int minCoins = -1;
    for(int coin : coins){
      int subAmount = amount - coin;
      int subCoins = minChangeWithMemoization(subAmount, coins, memo);

      // subCoins are the result of method.
      if(subCoins != -1){
        int numCoins = subCoins + 1; // the subCoins will return 0, if the subAmount is 0. So, add the count by plus 1
        // How the minCoins are gibber than numCoins?
        // In usual case the minCoins will be -1. So, the minCoins will be 1 for proper count.
        if(numCoins < minCoins || minCoins == -1){
          minCoins = numCoins;
        }
      }
    }

    memo.put(amount, minCoins);
    return minCoins;
  }
}


```
