import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MaximumPath {
        public static int N = 3, M = 3;

        // Function to calculate max path in matrix
        public static int findMaxPath(List<List<Integer>> mat)
        {
            // To find max val in first row
            int res = -1;

            for (int i = 1; i < N; i++)
            {
                for (int j = 0; j < M; j++) {
                    // When all paths are possible
                    int curr = mat.get(i).get(j);
                    if (j == 0) {
                        mat.get(i).set(j, curr + Math.max(mat.get(i - 1).get(j), M == 1 ? Integer.MIN_VALUE :
                                mat.get(i - 1).get(j + 1)));
                    }
                    // When diagonal right is not possible
                    else if (j == M - 1) {
                        mat.get(i).set(j, curr += Math.max(mat.get(i - 1).get(j), M == 1 ? Integer.MIN_VALUE :
                                mat.get(i - 1).get(j - 1)));
                    }
                    // When diagonal left is not possible
                    else  {
                        mat.get(i).set(j, curr += Math.max(mat.get(i - 1).get(j),
                                Math.max(mat.get(i - 1).get(i - 1), mat.get(i - 1).get(j + 1))));
                    }
                    // Store max path sum
                    res = Math.max(mat.get(i).get(j), res);
                }
            }
            return res;
        }

        // driver program
        public static void main (String[] args)
        {
//            int input[][] = { { 10, 10, 2, 0, 20, 4 },
//                    { 1, 0, 0, 30, 2, 5 },
//                    { 0, 10, 4, 0, 2, 0 },
//                    { 1, 0, 2, 20, 0, 4 }
//            };
//            List<List<Integer>> mat = new ArrayList<>();
//            for (int[] ints : input) {
//                List<Integer> list = new ArrayList<>();
//                for (int i : ints) {
//                    list.add(i);
//                }
//                mat.add(list);
//            }
            List<List<Integer>> mat = new ArrayList<>(
                                      Arrays.asList(
                                      new ArrayList<>(Arrays.asList(2,4,3)),
                                      new ArrayList<>(Arrays.asList(1,2,3)),
                                      new ArrayList<>(Arrays.asList(4,5,6))
            ));
            System.out.println(MaximumPath.findMaxPath(mat));
        }
    }

