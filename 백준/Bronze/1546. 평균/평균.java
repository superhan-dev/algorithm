import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        long sum = 0;
        long max = 0;
        
        for(int i=0;i<n;i++){
            int temp = sc.nextInt();
            max = Math.max(max, temp);
            sum += temp;
        }
        
        System.out.println(sum * 100.0 / max / n);
    }
}