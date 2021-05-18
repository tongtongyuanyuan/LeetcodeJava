import java.util.*;

public class GroupingDigits {
    public static int minMoves(int[] arr){
          int count1 = 0;
          int dis = 0;
          for(int num : arr) {
              if(num == 1) {
                  count1 += 1;
              }
              if(num == 0) {
                  dis +=count1;
              }
          }
          int n = arr.length;
          int count0 = n - count1;

          int res = count1 * count0 - dis;
          return Math.min(dis, res);
    }

    public static void main(String[] args) {
        int[] arr = {0,0,1,1};
        int res = GroupingDigits.minMoves(arr);
        System.out.print(res);
    }
}


