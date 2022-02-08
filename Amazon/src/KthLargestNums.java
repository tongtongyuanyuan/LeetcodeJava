import java.util.Random;
public class KthLargestNums {
    int[] nums;

    public void swap(int a, int b) {
        int temp = this.nums[a];
        this.nums[a] = this.nums[b];
        this.nums[b] = temp;
    }

    public int partition(int left, int right, int pivot_idx) {
        int pivot = this.nums[pivot_idx];
        //1.move the pivot to the end
        swap(pivot_idx, right);
        int store_idx = left;

        //2.move all smaller elements to the left,不用管pivot右边了，现在剩下大于等于它的都在右边了
        for(int i = left; i <= right; i++) {
            if(this.nums[i] < pivot) {
                swap(store_idx, i);
                store_idx++;
            }
        }
        //3.move pivot to its final place
        swap(store_idx, right);
        return store_idx;
    }
    public int quickSelect(int left, int right, int k_smallest) {
        if(left == right) return this.nums[left];

        Random random_num = new Random();
        int pivot_idx = left + random_num.nextInt(right - left);
        pivot_idx = partition(left, right, pivot_idx);

        //this pivot is on (N - k) smallest position
        if(k_smallest == pivot_idx) {
            return this.nums[k_smallest];
        }
        //go to left side
        else if(k_smallest < pivot_idx) {
            return quickSelect(left, pivot_idx, k_smallest);
        }
        //go to right side
        return quickSelect(pivot_idx + 1, right, k_smallest);
    }

    public int findKthLargest(int[] nums, int k) {
        this.nums = nums;
        int n = nums.length;
        //kth largest is (N - k) smallest
        return quickSelect(0, n - 1, n - k);
    }
}
