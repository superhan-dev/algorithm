# The sumPossible algorithm

# algorithm complexity

- time
  - with memo: O(n power of a)
    - a = amount
    - n = length of numbers
  - with memo: O(a\*n)
    - a = amount
    - n = length of numbers
- space: O(a)

# The code

```java

import java.util.*;

class Main {
  public static void main(String[] args){

  }

  public static boolean sumPossible(int amount, List<Integer> numbers){
    if(amount == 0){
      return true;
    }

    if(amount < 0) {
      return false;
    }

    for(int num : numbers){
      int subAmount = amount - num;
      if(sumPossible(subAmount, numbers)){
        return true
      }
    }

    return false;
  }

  public static int sumPossibleWithMemo(int amount, List<Integer> numbers, HashMap<Integer,Boolean> memo){
    if(amount == 0){
     return true;
   }

   if(amount < 0) {
     return false;
   }

   if(memo.containsKey(n)){
     return memo.get(n);
   }

   for(int num : numbers){
    int subAmount = amount - num;
    if(sumPossible(subAbmount, numbers)){
      memo.put(amount, true);
      return true;
    }
   }
   memo.put(amount, false);
   return false;
  }
}

```
