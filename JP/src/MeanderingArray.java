import java.util.*;

public class MeanderingArray {
    public static List <Integer> MeanderingArray(List <Integer> unsorted) {
        List <Integer> result = new ArrayList <>();
        if (unsorted.size() == 0) {
            return result;
        }
        Collections.sort(unsorted);
        //loop from both start and end
        for (int i = 0, j = unsorted.size() - 1; i <= unsorted.size() / 2 || j > unsorted.size() / 2; i++, j--) {
            if (i <= unsorted.size() / 2) {
                result.add(unsorted.get(j));
            }
            if (j > unsorted.size() / 2) {
                result.add(unsorted.get(i));
            }
        }
        return result;
    }
    public static void main(String args[]) {
      List<Integer> arr = new ArrayList<>();
     // List<Integer> result = new ArrayList<>();
      arr.add(5);
      arr.add(8);
      arr.add(1);
      arr.add(4);
      arr.add(2);
      arr.add(9);
      arr.add(3);
      arr.add(7);
      arr.add(6);
      System.out.println("Original List " + arr);
     // MeanderingArray(arr);
      System.out.print(MeanderingArray(arr));
    }
}


