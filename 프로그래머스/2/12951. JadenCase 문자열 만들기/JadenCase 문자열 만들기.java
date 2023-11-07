
class Solution {
    public String solution(String s) {
        String answer = "";
        char[] charArr = s.toCharArray();
        
        for(int i=0;i<charArr.length;i++){
            if(i == 0){
             charArr[0] = Character.toUpperCase(charArr[0]);
            } else if(charArr[i-1] == ' '){
                charArr[i] = Character.toUpperCase(charArr[i]);
            } else if (charArr[i-1] != ' ' 
                       && Character.isUpperCase(charArr[i])) {
                charArr[i] = Character.toLowerCase(charArr[i]);
            }
        }
        
        answer = String.valueOf(charArr);
        
        return answer;
    }
}