# The Logic
Finding all possible cases from a word or digit number.
in this case we use backtracking for the algorithm

the algorithm usually use with recursive function.

## Important point
- set exit point
- wrap the recursive function.

# Code
```java
import java.util.*;

class Main {
    public static void main(String[] args){
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        permutation(list,0,2);
    }
    
    public static void permutation(List<Integer> list,int start,int end){
        if(start == end){
            System.out.println(list);
        }
        
        for(int i=start;i<=end;i++){
            swap(list, start,i);
            permutation(list,start+1,end);
            // backtracking
            swap(list, start,i);
        }
        
    }
    // swap with start end i
    public static swap(List<Integer> list,int start,int idx){
        int temp = list.get(start);
        list.set(start,list.get(idx)); 
        list.set(idx,temp);
    }
}
```

