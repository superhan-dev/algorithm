  package temp;

import java.io.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());
    String[] defaultTemp = br.readLine().split("");
    String[] answerTemp = br.readLine().split("");

    for(int i=0;i<N;i++){
      if(defaultTemp[i].equals("0")){
        defaultTemp[i] = "1";
      } else {
        defaultTemp[i] = "0";
      }

      if(i > 0){
        if(defaultTemp[i-1].equals("0")){
          defaultTemp[i-1] = "1";
        } else {
          defaultTemp[i-1] = "0";
        }
      }
   
      if(i < N-1){
        if(defaultTemp[i+1].equals("0")){
          defaultTemp[i+1] = "1";
        } else {
          defaultTemp[i+1] = "0";
        }
      }
  
      int diffCount=0;
      for(int j=0;j<N;j++){
        if(diffCount > 0){
          break;
        }

        if(!answerTemp[j].equals(defaultTemp[j])){
          diffCount++;
        }
      }

      if(diffCount == 0){
        System.out.println(i+1);
      } else {
        System.out.println(-1);
      }
    }
 }
}

