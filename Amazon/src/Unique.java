import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


//public class Unique {
//  //count how many unique words in a string
//  public static int count(String str) {
//      //String[] words = str.split("[^a-zA-Z]");  819.
//      String[] words = str.toLowerCase().split(" "); //大小写一样
//
//      Set<String> uniquewords = new HashSet<String>();
//      for(String w : words) {
//            uniquewords.add(w);
//      }
//        return uniquewords.size();
//  }
//public class UniqueWords{
//    public static int CountUnique(String str) {
//
//        Set<Character> hset = new HashSet<Character>();
//        for (int i = 0; i < str.length(); i++) {
//            char ch = str.charAt(i);
//            if (ch >= 'a' && ch <= 'z' && ch >= 'A' && ch <= 'Z')
//                hset.add(ch);
//        }
//        return hset.size();
//    }
//    public static void main(String[] args) {
//        String st = "#GeeKs01fOr@gEEks07";
//        System.out.println(CountUnique(st));
//    }
//}
  //print all words and their counts
  //print all words and their counts
public class Unique {
      public static void main(String[] args) {
      String str1 = "Bob hit a ball, the hit BALL flew far after it was hit.";
      String[] words = str1.toLowerCase().split("[^a-z]+");
      Map<String, Integer> hmap = new HashMap<>();
      for (String w : words) {
          if (!hmap.containsKey(w)) {
              hmap.put(w, 1); //不存在放入map计数为1
          } else {
              hmap.put(w, hmap.get(w) + 1); //存在的话次数加1
          }
      }
//      for (String keys : hmap.keySet()) {
//          System.out.println(keys);
//      }
//      for (Map.Entry<String, Integer> entry : hmap.entrySet()) {
////          System.out.println(entry.getKey() + ": " + entry.getValue());
////      }
      hmap.forEach((key, value) -> System.out.println(key + ": " + value));
  }
}
// print the uppercase letters, lowercase letters,

