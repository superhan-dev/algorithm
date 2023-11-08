package temp;

import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    Graph<Integer> graph = new Graph<>();

    int size = Integer.parseInt(br.readLine());
    for (int i = 0; i < size; i++) {
      String[] inputTemp = br.readLine().split(" ");
      for (int j = 0; j < inputTemp.length; j++) {
        if (Integer.parseInt(inputTemp[j]) == 1) {
          graph.addEdge(i, j);
        }
      }
    }

    int[][] answerArr = new int[size][size];
    for (int key : graph.getMap().keySet()) {
      answerArr[key][key] = 1;
      for (int val : graph.getMap().get(key)) {
        answerArr[key][val] = 1;
      }
    }

    for (int i = 0; i < answerArr.length; i++) {
      System.out.println();
      for (int j = 0; j < answerArr[i].length; j++) {
        System.out.print(answerArr[i][j] + " ");
      }
    }
    System.out.println();

  }
}

class Graph<T> {
  Map<T, List<T>> map = new HashMap<>();

  Graph() {
  }

  public Map<T, List<T>> getMap() {
    return map;
  }

  void addEdge(T source, T destination) {
    if (map.get(source) == null) {
      map.put(source, new LinkedList<>());
    }
    if (map.get(destination) == null) {
      map.put(destination, new LinkedList<>());
    }

    map.get(source).add(destination);
    map.get(destination).add(source);
  }
}