package temp.graph;

import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws IOException {
    Graph<String> graph = new Graph<>();

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int length = Integer.parseInt(br.readLine().toString());

    for (int i = 0; i < length; i++) {
      String[] inputTemp = br.readLine().split(" ");
      for (int j = 0; j < inputTemp.length; j++) {
        if (inputTemp[j].equals("1")) {
          graph.addEdge(String.valueOf(i), String.valueOf(j), true);
        }
      }
    }

    String[][] temp = new String[length][length];
    // iterate as graph's map size()
    for (String key : graph.getAdjencyVertiex().keySet()) {
      int k = Integer.parseInt(key);
      temp[k][k] = "1";
      List<String> ls = graph.getAdjencyVertiex().get(key);
      for (String str : ls) {
        int v = Integer.parseInt(str);

        temp[k][v] = "1";
      }
    }

    for (int i = 0; i < temp.length; i++) {
      System.out.println();
      for (int j = 0; j < temp[i].length; j++) {
        System.out.print(temp[i][j] + " ");
      }
    }
    System.out.println();

  }
}