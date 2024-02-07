# What I have learn
- Usually, When I use the for loop, always loop through entire of the array. <br/>
  But, If I put the idx value out of the for loop, I can control the pointer easier than use an auxiliary variables.

# Code

```java
import java.util.*;

class Solution {
    public static void main(String[] args){
        int[] nums = {1,1,2};

        removeDuplicates(nums);
        // the num will be {1,2,_}
    }
    
    public static int removeDuplicates(int[] nums) {
        Arrays.sort(nums);
        Integer temp = null; 
        int idx = 0;
        for(int num : nums){
            if(temp == null || temp != num){
                nums[idx] = num;
                temp=num;
                idx++;
            } else {
                temp = num;
            }
        }
        return idx;
    }
}
```