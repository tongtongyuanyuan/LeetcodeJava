import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Triplet {
    public static List increasingTriplet(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < nums.length; i++) {
            while(!stack.isEmpty() && nums[stack.peek()] >= nums[i]) {
                stack.pop();
            }
            stack.push(i);
        }
        while(!stack.isEmpty()) {
            res.add(0,nums[stack.pop()]);
        }

        return res;
    }

    public static void main(String[] args) {
        //int[] nums = {2,1,5,0,4,6,9};
        int[] nums = {5,4,3,2,1};
        List<Integer> res = new ArrayList<>();
        res = Triplet.increasingTriplet(nums);;
        System.out.print(res);
    }
}
