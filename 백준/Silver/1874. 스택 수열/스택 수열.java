import java.util.*;
import java.io.*;

class Main {
         public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        Deque<Integer> stack = new ArrayDeque<>();

        StringBuilder sb = new StringBuilder();
        int num = 1;

        boolean ok = true;

        for(int i=0;i<n;i++){
            int curr = arr[i];

            while(num <= curr){
                stack.push(num++);
                sb.append("+\n");
            }

            if(stack.isEmpty() || !stack.peek().equals(curr)) {
                ok = false;
                break;
            }

            stack.pop();
            sb.append("-\n");
        }

        System.out.print(ok ? sb.toString() : "NO");
        br.close();
    }
}