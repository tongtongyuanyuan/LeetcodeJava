import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class KSmallestPairs {
    public static List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[0] + a[1]) - (b[0] + b[1]));
        List<int[]> res = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        if (nums1.length == 0 || nums2.length == 0 || k == 0) return ans;
        for (int i = 0; i < nums1.length && i < k; i++)
            pq.offer(new int[]{nums1[i], nums2[0], 0}); //按最小堆排序，不超过k对

        while (k-- > 0 && !pq.isEmpty()) {
            int[] cur = pq.poll();
            res.add(new int[]{cur[0], cur[1]});
            if (cur[2] == nums2.length - 1) continue;
            //cur[2] = 0 开始，nums2[1],就是每次变nums2
            pq.offer(new int[]{cur[0], nums2[cur[2] + 1], cur[2] + 1});
        }
        //Convert list to array
        //  int[] array = list.stream().mapToInt(i->i).toArray();

        /* convert List<int[]> to List<Intger>res
        int[] ints = {1,2,3};
List<Integer> list = Arrays.stream(ints).boxed().collect(Collectors.toList()); */
        for(int[] r : res) {
            List<Integer> list = new ArrayList<>(r.length);
            for(int val : r) {
                list.add(val);
            }
            ans.add(list);
        }

        return ans;
    }

    public static void main(String[] args) {
            int[] nums1 = {1,7,11};
            int[] nums2 = {2,4,6};
            int k = 3;
            List<int[]> res = new ArrayList<>();
            List<List<Integer>> ans = new ArrayList<>();
            ans = KSmallestPairs.kSmallestPairs(nums1, nums2, k);
            System.out.print("[");
            for(List<Integer> r : ans) {
                 for(int val : r) {
             }
            System.out.print(r);
            }
            System.out.print("]");
    }
}
