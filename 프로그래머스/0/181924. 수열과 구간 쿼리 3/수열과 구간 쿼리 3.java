import java.util.*;

class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        
        for(int q=0;q<queries.length;q++){
            int i = queries[q][0];
            int iv = arr[i];

            int j = queries[q][1];
            int jv = arr[j];

            arr[i] = jv;
            arr[j] = iv;
        }
 
        return arr;
    }
}