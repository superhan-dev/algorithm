import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] str = br.readLine().toCharArray();
        
        int[] temp = new int[26];
        Arrays.fill(temp, -1);
        
        for(int i=0;i<str.length;i++){
            int tempIndex = (int)str[i] - 97;
            if(temp[tempIndex] == -1){
                temp[tempIndex] = i;
            }
        }
        
        for(int n:temp){
            System.out.print(n+" ");
        }
        
        br.close();
    }
}