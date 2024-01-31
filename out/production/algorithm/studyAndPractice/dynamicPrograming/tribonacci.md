# The tribonacci algorithm

The tribonacci algorithm is kind of further version of fibonacci.

# algorithm complexity

- time
  - without memo: O(n!)
  - with memo: O(n)
- space: O(n)

# The code

```java

import java.util.*;

class Main {
  public static void main(String[] args){

  }

  public static int tribonacci(int n){
    if(n == 0 || n == 1){
      return 0;
    }

    if(n == 2) {
      return 1;
    }

    return tribonacci(n - 1) + tribonacci(n - 2) + tribonacci(n - 3);
  }

  /**
   * n will be the key of memo HashMap.
   */
  public static int tribonacciWithMemo(int n, HashMap<Integer,Integer> memo){
    if(n == 0 || n == 1){
     return 0;
   }

   if(n == 2) {
     return 1;
   }


   if(memo.containsKey(n)){
     return memo.get(n);
   }

   int result = tribonacciWithMemo(n - 1,memo) + tribonacciWithMemo(n - 2,memo) + tribonacciWithMemo(n - 3,memo);

   memo.put(n, result);

   return result;
  }
}

```
