import java.util.*;

public class BasicCalulator{
//    public static List <Integer> MeanderingArray(List <Integer> unsorted) {
//
//    }
    public static void main(String args[]) {
      String s = "a204";
      int num = 0;
      for(int i = 0; i < s.length(); i++) {
          char ch = s.charAtt(i);
          if(isDigit(ch)) {
              num = num  * 10 + (ch - '0');
              System.out.println()
          }
          System.out.print(ch);
      }
    }
}


