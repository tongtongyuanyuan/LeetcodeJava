//https://www.lintcode.com/problem/subarray-sum-ii/?_from=ladder&&fromId=178
//nlogn
//二分法：
//求出一个prefixSum, 然后对于每一个前缀和presum[right],
//求出两个点left_start, left_end
//[left_start,right]--->最左边的使子数组和不大于end的点
//[left_end,right]--->最右边的点使得子数组和不喜爱与start的点
//在prefixSum[0...right]上二分查找确定left_start,left_end
//public class SubarrySumII {
//    private static int find(int[] A, int len, int target) {
//        if(len - 1 >= 0 && A[len - 1] < target) {
//            return len;
//        }
//        int l = 0, r = len - 1, ans = 0;
//        while(l <= r) {
//            int mid = (l + r) / 2;
//            if(target <= A[mid]) {
//                ans = mid;
//                r = mid - 1;
//            }else
//                l = mid + 1;
//        }
//        return ans;
//    }
//    public static int subarraySumII(int[]A, int start, int end) {
//        int len = A.length;
//
//        for(int i = 1; i < len; i++) {
//            A[i] += A[i-1];
//        }
//
//        int cnt = 0;
//        for(int i = 1; i < len; i++) {
//            if(A[i] >= start && A[i] <= end) {
//                cnt++;
//            }
//            int l = A[i] - end;
//            int r = A[i] - start;
//            cnt += find(A, i, r + 1) - find(A, i, l);
//        }
//        return cnt;
//    }
//    public static void main(String[] args) {
//        int[] A = {1,2,3,4};
//        int start = 1;
//        int end = 3;
//        System.out.println(subarraySumII(A, start, end));
//    }
//}
public class SubarrySumII {
    /**
     * @param A: An integer array
     * @param start: An integer
     * @param end: An integer
     * @return: the number of possible answer
     */
    //解法一，two pointers T = O(n)
    //先构造一个prefixSum
    //[0,1,3,6,10]
    //[1,2,3,4]  //求区间值在start和end之间，再用两个指针确定范围，移动l,r, i 则可以得出
    // l - r就是此时满足条件的区间的个数，累计则得结果
    //关键，怎么找到l,r,i的关系
    public int subarraySumII(int[] A, int start, int end) {
        // write your code here
        if(A.length == 0) return 0;

        int[] sum = new int[A.length + 1];  //prefixSum
        sum[0] = 0;
        int res = 0;
        int i,  l,  r = 0;
        for(i = 1; i <= A.length; i++) {
            sum[i] = sum[i - 1] + A[i-1];
        }
        l = r = 0;
        for(i = 1; i <= A.length; ++i) {
            while(l < i && sum[i] - sum[l] > end) {
                ++l;   //缩小范围，移动窗口,移动到某个位置< end的时候，l固定住，然后移动r的位置
            }
            while(r < i && sum[i] - sum[r] >= start) {
                ++r;   //说明满足条件，可以再让r后移动，然后找满足条件的起点，移动到某个位置可能<start
            }          //<start的时候，r固定住整个窗口后移动，l移动
            res += r - l;
        }
        return res;
    }
}
//T = O(nlogn)