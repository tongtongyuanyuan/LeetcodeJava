//https://leetcode.com/discuss/interview-question/346342/facebook-onsite-matrix-antidiagonal-traverse
//https://leetcode.com/problems/diagonal-traverse/
//https://www.geeksforgeeks.org/return-an-array-of-anti-diagonals-of-given-nn-square-matrix/
//https://leetcode.com/problems/diagonal-traverse-ii/
//498, 1424

import java.util.ArrayList;
import java.util.*;
    //Solution1. T = O(N*M)
public class Antidiagonal {
        public static void main(String[] args) {
            Antidiagonal main = new Antidiagonal();

            int[][] matrix = new int[][]{{12, 7, 21, 31, 11},
                                         {45, -2, 14, 27, 19},
                                         {-3, 15, 36, 71, 26},
                                         {4, -13, 55, 34, 15}};
            System.out.println(main.diagonal(matrix));

//
//            int[][] matrix = new int[][]{{1, 2, 3},
//                    {4, 5, 6},
//                    {7, 8, 9}};

           // System.out.println(main.diagonal(matrix));
        }

        public List<List<Integer>> diagonal(int[][] matrix) {
            List<List<Integer>> result = new ArrayList<>();

            int m = matrix.length;
            int n = matrix[0].length; //columns

            for (int i=0;i<m+n-1;i++) {
                List<Integer> diag = new ArrayList<>();

                int row = i < n ? 0 : i - n + 1;
                int col = i < n ? i : n - 1;

                while (row < m && col >= 0) {
                    diag.add(matrix[row][col]);
                    row++;
                    col--;
                }

                result.add(diag);
            }

            return result;
        }
    }


//            public static void main (String args[]){
//                String s = "a204";
//                int num = 0;
//                for (int i = 0; i < s.length(); i++) {
//                    char ch = s.charAt(i);
//                    if (Character.isDigit(ch)) {
//                        num = num * 10 + (ch - '0'); //2, 20. 204
//                        System.out.println(num);
//                    }
//                }
//            }
//        }