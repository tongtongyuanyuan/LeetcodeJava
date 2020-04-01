

import javafx.scene.layout.Priority;
import java.util.Comparator;

import java.util.PriorityQueue;
import java.util.Queue;

public class MaxMinimumPath {

    public int maximumMinimumPath(int[][] A) {
        int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int row = A.length, cols = A[0].length;
        if (row == 1 && cols == 1) return A[0][0];

//        Queue<int[]> pq = new Priority<>(new Comparator<int[]>() {
////            @Override
////            public int compare(int[] a, int[] b) {
////                return b[0] - a[0];
////            }
////        });
        Queue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]); //use max heap to ensure poll the biggest elements

        pq.add(new int[] {A[0][0], 0, 0});
        A[0][0] = -1; //marked as visited

        while(!pq.isEmpty()) {
            int[] cur = pq.poll();

            for(int[] dir: dirs) {
                int next_i = cur[1] + dir[0];
                int next_j = cur[2] + dir[1];

                if(next_i >= 0 && next_i < row && next_j >= 0 && next_j < cols && A[next_i][next_j] >= 0) {
                    int next_v = Math.min(cur[0], A[next_i][next_j]);
                    if(next_i == row - 1 && next_j == cols - 1) return next_v;
                    pq.add(new int[]{next_i, next_j});
                    A[next_i][next_j] = -1;

                }
            }
        }
        return -1;

    }
}
