import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strs = br.readLine().split(" ");
        int n = strs.length;
        int[] arr = new int[n];      
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(strs[i]);
        }
        
        int flag = 0;
        for(int i=0;i<arr.length;i++){
            if(i==0) {continue;}
            
            if(arr[i] < arr[i-1]){
                flag--;
            } else {
                flag++;
            }
        }
        
        if(flag > 0 && flag == arr.length - 1){
            System.out.println("ascending");
        } else if(flag < 0 && flag == (arr.length * -1)+1){
            System.out.println("descending");
        } else {
            System.out.println("mixed");
        }
    }
}