# The fibonacci algorithm

The fibonacci uses a recursive call for the algorithm. and It has slow time complexity which is the worst time efficiency.
to overcome this time efficiency, we can use the concept of memoization.

If the memoization, the time complexity will get better.
We can save some of the reclusive calls for repeated numbers.

## When to use?

can be used to model natural growth patterns in plants, animals, and other living things. The algorithm can also be used to generate fractals, which are patterns that repeat over and over again.

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

  public static int fibonacci(int n){
    if(n == 0 || n == 1){
      return 1;
    }

    return fibonacci(n - 1) + fibonacci(n - 2);
  }

  /**
   * n will be the key of memo HashMap.
   */
  public static int fibonacciWithMemo(int n, HashMap<Integer,Integer> memo){
    if(n == 0 || n == 1){
      return 1;
    }

    if(memo.containsKey(n)){
      return memo.get(n);
    }

    int result = fibonacciWithMemo(n, memo) + fibonacciWithMemo(n, memo);

    memo.put(n, result);

    return result;
  }
}

```
