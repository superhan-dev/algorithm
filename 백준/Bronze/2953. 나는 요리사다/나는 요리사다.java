import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int max=0;
        int index=0;
        for(int i=0;i<5;i++){
            String[] numStrs = br.readLine().split(" ");
            int sum=0;
            for(String n : numStrs){
                sum+=Integer.parseInt(n);
            }
            if(max < sum){
                index=i+1;
                max=sum;
            }
        }
        System.out.println(index+" "+max);
        br.close();
    }
}