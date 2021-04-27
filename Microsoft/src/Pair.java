import java.util.*;

//A method that will return a histogram of the input int array. The histogram should be in the same order
// as the first appearance of the int in the input.
// Example: input: [6,9,8,6,8] output: [[6,2], [9,1], [8,2]] (where 1st element is the value, 2nd is count).
public class Pair {
    public static List<List<Integer>> histogram(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        LinkedHashMap<Integer, Integer> m = new LinkedHashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            // m.getOrDefault(nums[i], m.get(i) + 1);
            m.put(nums[i], m.getOrDefault(nums[i], 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : m.entrySet()) {
            //res.get(entry.getKey()).add(entry.getValue());
            res.add(Arrays.asList(entry.getKey(), entry.getValue()));
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {6, 9, 8, 6, 8};
        List<List<Integer>> res = new ArrayList<>();
        res = Pair.histogram(nums);
        System.out.print("[");
//        for(List<Integer> ans : res) {
//            System.out.print("[");
//            for(Integer a  : ans) {
//                System.out.print(a);
//            }
//            System.out.print("]");
//        }
//        System.out.print("]");
//    }
        for (int i = 0; i < res.size(); i++) {
            System.out.print("[");
            for (int j = 0; j < res.get(i).size(); j++) {
                System.out.print(res.get(i).get(j));
                if(j != res.get(i).size() - 1) {
                    System.out.print(",");
                }
            }
            System.out.print("]");
            if(i != res.size() - 1) {
                System.out.print(",");
            }
        }
        System.out.print("]");
    }
}
