package utils.java.practice;

import java.util.HashMap;
import java.util.Map;

public class CountOccurence {
  public static void main(String[] args) {
    CountOccurence ab = new CountOccurence();
    ab.countChars();
  }

  public void countChars() {
    String str = "Java langauge";
    // char[] abc = str.split(" ");

    HashMap<Character, Integer> map = new HashMap<>();
    for (Character a : str.toCharArray()) {
      map.put(a, map.getOrDefault(a, 0) + 1);
    }

    //      Charact  map.forEach((k,v) -> (
    //                System.out.println(k+":"+v);
    //        });

    for (Map.Entry<Character, Integer> maps : map.entrySet()) {
      System.out.println(maps.getKey() + ":" + maps.getValue());
    }
  }
}
