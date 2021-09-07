import com.sun.jmx.snmp.Timestamp;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestPath {
        public static void main(String[] args) {
            char[][] A = new char[][] {{'x','.','.','.'},
                    {'.','.','.','.'},
                    {'.','.','.','.'},
                    {'.','.','.','.'},};
            ShortestPath solution = new ShortestPath();

            printMatrix(A);
            System.out.println(new Timestamp(System.currentTimeMillis()));
            solution.markDist(A);
            System.out.println(new Timestamp(System.currentTimeMillis()));
            printMatrix(A);
        }

        private static void printMatrix(char[][] a) {
            for (int i = 0; i < a.length; ++i) {
                for (int j = 0; j < a[0].length; ++j) {
                    System.out.print(a[i][j]);
                    System.out.print(" ");
                }
                System.out.println("");
            }
        }

        public void markDist(char[][] A) {
            int row = A.length;
            int col = A[0].length;
            Queue<Integer> queue = new LinkedList<>();
            int[] dx = new int[] {0, 0, 1, -1};
            int[] dy = new int[] {1, -1, 0, 0};
            for (int i = 0; i < row; ++i) {
                for (int j = 0; j < col; ++j) {
                    if (A[i][j] == 'x') {
                        queue.offer(i * col + j);
                    }
                }
            }
            int step = 0;
            while (!queue.isEmpty()) {
                //step++; //不对了想想和1563的区别，不算他本身的距离，从他开始
                int size = queue.size();
                for (int i = 0; i < size; ++i) {
                    int cur = queue.poll();
                    int x = cur / col;
                    int y = cur % col;
                    if (step != 0) {
                        A[x][y] = (char) ('0' + step);
                    }
                    for (int k = 0; k < 4; ++k) {
                        int newX = x + dx[k];
                        int newY = y + dy[k];
                        if (newX < 0 || newX >= row || newY < 0 || newY >= col) {
                            continue;
                        }
                        if (A[newX][newY] != '.') {
                            continue;
                        }
                        queue.offer(newX * col + newY);
                    }
                }
                step++; //下一层再计算步数
            }
        }
    }

