import java.io.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int[][] arr = new int[n][n];
    for (int i = 0; i < n; i++) {
      String[] temp = br.readLine().split(" ");
      for (int j = 0; j < temp.length; j++) {
        arr[i][j] = Integer.parseInt(temp[j]);
      }
    }

    arr = floydWarshall(arr, n);

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr[i].length; j++) {
        sb.append(arr[i][j] + " ");
      }
      sb.append("\n");
    }
    System.out.println(sb);

  }

  /**
   * @description
   *              In this question, we didn't need to compare the original
   *              floydWarshall's condition(which is dist[i][j] < dist[i][k] +
   *              dist[k][j].).
   *              But it needs to used the condition below (dist[i][k] == 1 &&
   *              dist[k][j] == 1) to give a number to the target.
   * 
   */
  static int[][] floydWarshall(int[][] dist, int n) {
    // K is vertex number
    for (int k = 0; k < n; k++) {
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
          if (dist[i][k] == 1 && dist[k][j] == 1) {
            dist[i][j] = 1;
          }
        }
      }
    }

    return dist;
  }
}
