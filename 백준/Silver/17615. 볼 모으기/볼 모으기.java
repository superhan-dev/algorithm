import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String balls = br.readLine();
        int count = Integer.MAX_VALUE;
        
        boolean isSwitch = false;
        int subCount = 0;
        for(int i=0;i<N;i++){
            if(balls.charAt(i) == 'B') isSwitch = true;
            if(isSwitch && balls.charAt(i) == 'R') subCount++;
        
        }
        count = Math.min(count, subCount);
        
        isSwitch = false;
        subCount = 0;
        for(int i=0;i<N;i++){
            if(balls.charAt(i) == 'R') isSwitch = true;
            if(isSwitch && balls.charAt(i) == 'B') subCount++;
        }
        count = Math.min(count, subCount);
        
        isSwitch = false;
        subCount = 0;
        for(int i=N-1;i>=0;i--){
            if(balls.charAt(i) == 'B') isSwitch = true;
            if(isSwitch && balls.charAt(i) == 'R') subCount++;
        }
        count = Math.min(count,subCount);
        
        isSwitch = false;
        subCount = 0;
        for(int i=N-1;i>=0;i--){
            if(balls.charAt(i) == 'R') isSwitch = true;
            if(isSwitch && balls.charAt(i) == 'B') subCount++;
        }
        count = Math.min(count,subCount);
        
        System.out.println(count);
    }
}