package studyAndPractice;

import java.util.*;
class Main {
  public static void main(String[] args){
    List<Integer> coins = new ArrayList<>();
    coins.add(100);
    coins.add(500);

    System.out.println(minChange(1000,coins,new HashMap<>()));
  }

  // return the minmum number of 
  public static int minChange(int amount, List<Integer> coins, HashMap<Integer, Integer> memo){
    if(amount == 0){
      return 0;
    }
    if(amount < 0){
      return -1;
    }

    if(memo.containsKey(amount)){
      return memo.get(amount);
    }

    // subCoins return -1 if it does not calculate a value with amount.
    int minCoins = -1;
    for(int coin: coins){
      int subAmount = amount - coin;
      int subCoins = minChange(subAmount, coins, memo);

      // If it's not return -1, the value will return a valil number. 
      // So, add a count with subCoins.
      if(subCoins != -1){
        int numCoins = subCoins + 1; // add count if it is possible to calcultate with amount.
        if(numCoins < minCoins || minCoins == -1){
          minCoins = numCoins;
        }
      }
    }

    memo.put(amount, minCoins); // find amount's minCoins
    return minCoins;
  }
}