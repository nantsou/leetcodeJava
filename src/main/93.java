package main;
//Import the required classes of LeetCode;
import objs.*;
import utils.*;
import sols.*;

//Import the required libraries;
import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    InputHandler ih = new InputHandler(args[0]);
    Solution sol = new Solution();
    
    ArrayList<String> inStr = ih.getDataAsStr();
    for (int i = 0; i < inStr.size(); i++) {
      String s = inStr.get(i);
      List<String> res = sol.restoreIpAddresses(s);
      System.out.println(res.toString());
    }
  }
}
