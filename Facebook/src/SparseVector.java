import java.util.Arrays;

class SparseVector {

    private final int[] index;
    private final int[] nums;

    SparseVector(int[] nums) {
        int[] index = new int[nums.length];

        int c = 0;
        for(int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                index[c++] = i;
            }
        }

        this.index = Arrays.copyOf(index, c);
        this.nums = nums;
    }

    // Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVector vec) {
        int i = 0;
        int j = 0;
        int product = 0;
        while (i < index.length && j < vec.index.length) {
            int idx1 = index[i];
            int idx2 = vec.index[j];
            if (idx1 < idx2) {
                i++;
            } else if (idx1 > idx2) {
                j++;
            } else {
                product += nums[idx1] * vec.nums[idx2];
                i++;
                j++;
            }
        }
        return product;
    }

    public void main(String[] args) {
        int[] nums1 = {1,0,0,2,3};
        int[] nums2 = {0,3,0,4,0};

        SparseVector v1 = new SparseVector(nums1);
        SparseVector v2 = new SparseVector(nums2);
        int ans = v1.dotProduct(v2);
        System.out.print(ans);
    }
}