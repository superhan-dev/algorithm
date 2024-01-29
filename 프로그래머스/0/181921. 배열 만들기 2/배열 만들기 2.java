import java.util.*;

class Solution {
    public int[] solution(int l, int r) {
        List<Integer> list = new LinkedList<>();
       
        for(int i=l;i<=r;i++){
            String numStr = String.valueOf(i);
            int strLengthCount = 0;
            for(char digit: numStr.toCharArray()){
                if(digit == '5' || digit == '0'){
                    strLengthCount++;
                }
            }
            
            if(strLengthCount == numStr.length()){
                list.add(i);     
            }
        }
        
        if(list.isEmpty()) list.add(-1);
        
        int[] answer = list.stream().mapToInt(Integer::intValue).toArray();
        return answer;
    }
}