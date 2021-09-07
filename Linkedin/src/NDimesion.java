import java.util.List;

/* You are given an N-Dimensional list with 2 methods:
i) getDim -> returns the dimensions .e.g [5,4,3].
ii) getElement([i,j,k]) -> return list[i][j][k] . You have to implement a method to sum all elements in the list.
Ex:- If we have 3D list of dimensions [2,2,3]
        # We will have a total of 2*2*3 = 12 elements
        # To get the correspoding indices for these elements
        # 0 0 0
        # 0 0 1
        # 0 0 2
        # 0 1 0
        # ...
        # ...
        # 1 1 1
        # 1 1 2
        # The strategy is to increment the last index value and once
        # we hit the dimension length of that particular index we mark it as zero
        # and increment the prior index value and if reaches end as well, we continue
        # to increment its prev index; the moment we reach a index which doesn't overflow
        032 >> 033 > 0 40 >> 100

        */
// T = O(N  * M) S= O(M) Iterative
//Time Complexity: O(N*M)
//Space Complexity: O(M)
import java.util.Random;


public class NDimesion {
    private int[][][] nums;
    NDimesion() {
        nums = new int[5][4][3];
        Random rand = new Random();
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 4; j++) {
                for (int k = 0; k < 3; k++) {
                    nums[i][j][k] = rand.nextInt(100);
                }
            }
        }
    }
    private int[] getDim() {
        return new int[]{5, 4, 3};
    }

    private int getElement(int[] indexes) {
        // [3, 1, 2]
        return nums[indexes[0]][indexes[1]][indexes[2]];
    }

    private void updateIdxes(int[] indexes) {
        // 000 -> 001
        int idx = indexes.length - 1;
        int[] dimensions = getDim(); // 5 4 3
        // 0 0 0 + 1 >> 0 0 1 >> 1 =? 3
        // 0 0 2 + 1 >> 0 0 3 >> 3 ?= 3 >> 0 0 3 >> 0 0 0 >> 0 1 0
        // 4 3 2 + 1 >> 4 3 3 >> 4 4 0 >> 5 0 0 >> idx = -1?
        while (idx >= 0) {
            indexes[idx]++;
            if (indexes[idx] == dimensions[idx]) {
                indexes[idx] = 0;
                idx--;
            }
            else {
                return;
            }
        }
    }

    public int sumAllElements() {
        int[] dimensions = getDim();
        // 0 0 0 -> 4 3 2
        int[] cur_idxes = new int[dimensions.length];
        // 计算总共循环的次数
        int loops = 1;
        for (int dim : dimensions) {
            loops *= dim;
        }
        int res = 0;
        // 0 0 0
        while (loops-- != 0) {
            int cur = getElement(cur_idxes);
            res += cur;
            // cur_idxes + 1. 000 -> 001
            updateIdxes(cur_idxes);
        }
        return res;
    }
}
