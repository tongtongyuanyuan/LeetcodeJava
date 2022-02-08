/*
//Tree老师代码
//1.QuickSort: temp每次都从index0开始用，注意最后要从temp复制回A
//start和end只有开始使用，中间都是用left和right
//注意递归出口要先写，否则计算pivot时会数组越界
//2.MergeSort
// */
////QuickSort
public class SortIntegers {
//    public static void sortIntegers2(int[] A) {
//        if(A == null || A.length < 2) return;
//        quickSort(A, 0, A.length - 1);
//    }
//    private static void quickSort(int[]A, int start, int end) {
//        if(start >= end) return;
//        int pivot = A[start + (end - start) / 2]; //中间随便选一个点
//        int left = start, right = end;
//        while(left <= right) {
//            while(left <= right && A[left] < pivot) { //保证比pivot小的点放到其左边
//                left++;
//            }
//            while(left <= right && A[right] > pivot) { //保证比pivot大的点放到其右边去
//                right--;
//            }
//            //剩下的条件就是A[left] >= pivot || A[right] <= pivot,swap(left, right)
//            if(left <= right) {
//                int temp = A[left];
//                A[left] = A[right];
//                A[right] = temp;
//            }
//        }
//        quickSort(A, start, right);
//        quickSort(A, left, end);
//    }
    //mergeSort
    public void sortIntegers2(int[] A){
        if(A == null || A.length == 0) return;
        int[] temp = new int[A.length];
        helper(A, 0, A.length - 1,temp);
    }
    private void helper(int[]A, int start, int end, int[] temp) {
        if(start >= end) return;
        int mid = start + (end - start) / 2;
        helper(A, start, mid, temp);
        helper(A, mid + 1, end, temp);
        merge(A, start, end, mid, temp);
    }

    private void merge(int[]A, int start, int end, int mid, int[] temp) {
        int left = start, right = mid + 1, idx = 0;
        while(left <= mid && right <= end) {
            if(A[left] <= A[right]) {
                temp[idx++] = A[left++];
            } else {
                temp[idx++] = A[right++]; //注意这里的right是从mid开始的
            }
        }
        while(left <= mid) {
            temp[idx++] = A[left++];
        }
        while(right <= end) {
            temp[idx++] = A[right++];
        }
        for(int i = 0; i < end - start + 1; i++) {
            A[start + 1] = temp[i];
        }
    }

    public void main(String[] args) {
        int[] nums = new int[] {3, 2, 1, 4, 5};
        sortIntegers2(nums);
        for(int n : nums) {
            System.out.print(n + " ");
        }
    }
}
