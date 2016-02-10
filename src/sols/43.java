package sols;
import java.util.*;

public class Solution {
  public String multiply(String num1, String num2) {
    num1 = new StringBuilder(num1).reverse().toString();
    num2 = new StringBuilder(num2).reverse().toString();

    int[] d = new int[num1.length() + num2.length()];
    for (int i = 0; i < num1.length(); i++) {
      int a = num1.charAt(i) - '0';
      for (int j = 0; j < num2.length(); j++) {
        int b = num2.charAt(j) - '0';
        d[i+j] += a*b;
      }
    }
    StringBuilder res = new StringBuilder();
    for (int i = 0; i < d.length; i++) {
      int digit = d[i]%10;
      int carry = d[i]/10;
      res.insert(0, digit);
      if (i < d.length - 1) {
        d[i+1] += carry;
      }
    }
    while (res.length() > 0 && res.charAt(0) == '0') {
      res.deleteCharAt(0);
    }
    return res.length() == 0?"0":res.toString();
  }
}
