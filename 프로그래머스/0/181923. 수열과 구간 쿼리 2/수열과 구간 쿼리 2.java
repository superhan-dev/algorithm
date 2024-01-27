import java.util.*;

class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        int maxValue = 1000000;
        int[] answer = new int[queries.length];
        Arrays.fill(answer,maxValue);
        
        for(int i=0;i<queries.length;i++){
            int s = queries[i][0];
            int e = queries[i][1];
            int k = queries[i][2];
            
            int temp = answer[i];
            for(int j=s;j<=e;j++){
                if(arr[j] > k){
                    temp = Math.min(arr[j],temp);
                }
            }
            if(temp != maxValue){
               answer[i] = temp;
            } else {
               answer[i] = -1; 
            }
        
        }
        return answer;
    }
}