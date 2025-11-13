import java.util.*;
import java.io.*;

class MyComparator implements Comparator<Integer> {
    @Override
    public int compare(Integer o1, Integer o2){
        int a1 = Math.abs(o1);
        int a2 = Math.abs(o2);
        if(a1 == a2) return o1 > o2 ? 1 : -1;
        
        return a1 - a2;
    }
}

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            for(int i=0;i<n;i++) arr[i] = Integer.parseInt(br.readLine());
            
            PriorityQueue<Integer> pq = new PriorityQueue<>(new MyComparator());
            
            for(int i=0;i<arr.length;i++){
                if(arr[i] == 0){
                    if(pq.peek() != null){
                        System.out.println(pq.poll());
                    } else {
                        System.out.println(0);
                    }
                } else {
                    pq.add(arr[i]);
                }
            }
        } catch(Exception e) {}
    }
}