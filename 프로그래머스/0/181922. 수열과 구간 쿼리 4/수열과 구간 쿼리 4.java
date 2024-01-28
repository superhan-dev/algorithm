import java.util.*;

class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        
        for(int idx=0;idx<queries.length;idx++){
            int s = queries[idx][0];
            int e = queries[idx][1];
            int k = queries[idx][2];
            
            for(int i=s;i<=e;i++){
                if(i == 0) arr[i] += 1;
                else if(i % k == 0) arr[i] += 1; 
            }
        }
  
        
        return arr;
    }
}