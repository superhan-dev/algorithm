class Solution {
    public String solution(int[] numLog) {
        String answer = "";
        
        int prevNum = numLog[0];
        for(int i=1;i<numLog.length;i++){
            int currentNum = numLog[i];
            
            if(prevNum+1 == currentNum){
                answer += "w";
            } else if(prevNum-1 == currentNum){
                answer += "s";
            } else if(prevNum+10 == currentNum){
                answer += "d";
            } else if(prevNum-10 == currentNum){
                answer += "a";
            }
            
            prevNum = numLog[i];
        }
        
        return answer;
    }
}