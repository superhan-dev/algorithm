import java.util.*;

class Solution {
    public int[] solution(int n) {
        List<Integer> answer = new ArrayList<>();
                 
        while(n > 1){
            answer.add(n);
            if(n % 2 == 0) n = n / 2;
            else n = n * 3 + 1;
        }
        
        answer.add(1);
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
    
  
}