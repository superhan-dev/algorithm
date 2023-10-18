
import java.io.*;

public class Main {
  public static void main(String[] args) {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    try {
      String[] firstLine = bf.readLine().split(" ");

      int totalNumber = Integer.parseInt(firstLine[0]);
      int addCount = Integer.parseInt(firstLine[1]);

      int[] numbers = new int[totalNumber];
      String[] numStrs = bf.readLine().split(" ");
      for (int i = 0; i < numStrs.length; i++) {
        if (i > 0) {
          numbers[i] = Integer.parseInt(numStrs[i]) + numbers[i - 1];
        } else {
          numbers[i] = Integer.parseInt(numStrs[i]);
        }
      }

      int[] answer = new int[addCount];
      for (int i = 0; i < addCount; i++) {
        String[] idxs = bf.readLine().split(" ");
        int startIdx = Integer.parseInt(idxs[0]) - 1;
        int endIdx = Integer.parseInt(idxs[1]) - 1;

        if (startIdx - 1 < 0) {
          answer[i] = numbers[endIdx];
        } else {
          answer[i] = numbers[endIdx] - numbers[startIdx - 1];
        }
      }

      for (int i = 0; i < answer.length; i++) {
        System.out.println(answer[i]);
      }
    } catch (Exception e) {
      System.out.println(e);
    }
  }
}