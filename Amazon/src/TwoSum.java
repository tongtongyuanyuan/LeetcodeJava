import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    //given an int array and a target, find an adjacent pair whose sum is targe
//    public static int[] twoSum(int[] nums, int target) {
//        int[] res = new int[2];
//        for (int i = 1; i < nums.length; i++) {
//            if (nums[i] + nums[i - 1] == target)
//                res[0] = i - 1;
//            res[1] = i;
//        }
//        return res;
//    }

    public static int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        Map<Integer, Integer> m = new HashMap<Integer, Integer>();

        for(int i = 0; i < nums.length; i++) {
            m.put(nums[i], i); //建立key-value(value & index)
        }
        for(int i = 0; i < nums.length; i++) {
            int temp = target - nums[i];
            if(m.containsKey(temp) && m.get(temp) != i) {
                res[0] = i;
                res[1] = m.get(temp);
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {11, 7, 2, 15};
        int target = 9;
        int[] res = twoSum(nums, target);
//        System.out.print("[");
//        for(int r : res) {
//            System.out.print(r + " ");
//        }
//        System.out.print("]");
//    }
        for (int r : res) {
            System.out.print(r + " ");
        }
    }
}
