import java.util.*;

public class Main {
  public static void main(String[] stgs) {

    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    String sNum = sc.next();
    char[] cNum = sNum.toCharArray();

    int sum = 0;

    for (int i = 0; i < cNum.length; i++) {
      sum = sum + Integer.parseInt("" + cNum[i]);
    }

    System.out.println(sum);
  }
}