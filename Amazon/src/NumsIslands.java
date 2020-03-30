import java.util.LinkedList;
import java.util.Queue;

public class NumsIslands {

        public static int numIslands(char[][] grid) {
            if(grid == null || grid.length == 0) return 0;
            int m = grid.length, n = grid[0].length;
            int res = 0;
            int [][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
            for(int i = 0; i < m; ++i) {
                for(int j = 0; j < n; ++j) {
                    if(grid[i][j] == '1') {
                        ++res;
                        grid[i][j] = '0'; //marked as visited
                        Queue<Integer> q = new LinkedList<>();
                        q.add(i * n + j);
                        while(!q.isEmpty()) {
                            int id = q.poll();
                            int row = id / n; //问题所在
                            int col = id % n;
                            for(int[] dir : dirs) {
                                int x = row + dir[0];
                                int y = col + dir[1];
                                if(x < 0 || x >= m || y < 0 || y >= n || grid[x][y] == '0')continue;
                                q.offer(x * n + y);
                                grid[x][y] = '0';//mared as visited;
                            }
                        }
                    }
                }
            }
            return res;
        }
        public static void main(String[] args) {
            char[][] grid = new char[][] {{1,1,0,0,0}, {1,1,0,0,0}, {0,0,1,0,0}, {0,0,0,1,1}};
            System.out.println(numIslands(grid));
         }
    }

