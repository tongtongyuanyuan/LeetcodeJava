import java.util.Arrays;

public class getMinMoves {
    public static void main(String[] args) {
        int[] plates = {5, 2, 4, 3, 1, 6};
//        int[] plates = {1, 3, 2};
        //{2, 4, 3, 1, 6}
        int moves = getMinMoves(plates.length, plates);
        System.out.println("Minimum number of moves required: " + moves);

    }

    public static int getMinMoves(int platesCount, int[] plates) {
        int ans = 0;
        int mn = Integer.MAX_VALUE, mx = Integer.MIN_VALUE;
        int min_idx = 0; int max_idx;
        int[] arr = plates;
        for (int i = 0; i < mx; i++) {
            mx = arr[i];
            max_idx = i;

            if (arr[i] > mn) {
                ans += min_idx + (platesCount - 1 - max_idx);
            } else {
                ans += min_idx + (platesCount - 1 - max_idx);
                max_idx++;
                ans += (platesCount - 1 - max_idx);
            }
        }
        return ans;
    }
}
