/* Problem Name is &&& Best Average Grade &&& PLEASE DO NOT REMOVE THIS LINE. */

import java.io.*;
import java.util.*;

/*
 **  Instructions:
 **
 **  Given a list of student test scores, find the best average grade.
 **  Each student may have more than one test score in the list.
 **
 **  Complete the bestAverageGrade function in the editor below.
 **  It has one parameter, scores, which is an array of student test scores.
 **  Each element in the array is a two-element array of the form [student name, test score]
 **  e.g. [ "Bobby", "87" ].
 **  Test scores may be positive or negative integers.
 **
 **  If you end up with an average grade that is not an integer, you should
 **  use a floor function to return the largest integer less than or equal to the average.
 **  Return 0 for an empty input.
 **
 **  Example:
 **
 **  Input:
 **  [ [ "Bobby", "87" ],
 **    [ "Charles", "100" ],
 **    [ "Eric", "64" ],
 **    [ "Charles", "22" ] ].
 **
 **  Expected output: 87
 **  Explanation: The average scores are 87, 61, and 64 for Bobby, Charles, and Eric,
 **  respectively. 87 is the highest.
 */

/* float ? floor?
float ? double ?
        float val1 = -0.9;
        double val2 = -0.9;
        int val3 = (int) val1;
        int val4 = (int) val2;
        if (val3 == val4) {

        }
*/

class GS {
    /*
     **  Find the best average grade.
     */
    public static Integer bestAverageGrade(String[][] scores) {
        if (scores == null || scores.length == 0) {
            return 0;
        }

        int highestAve = 0;
        Map<String, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < scores.length; i++) {
            List<Integer> scoreList = new ArrayList<>();
            scoreList = map.get(scores[i][0]);
            if (scoreList == null) {
                List<Integer> currentScore = new ArrayList<>();
                currentScore.add(Integer.valueOf(scores[i][1]));
                map.put(scores[i][0], currentScore);
            } else {
                scoreList.add(Integer.valueOf(scores[i][1]));
                map.put(scores[i][0], scoreList);
            }
        }

        for (Map.Entry<String, List<Integer>> entry : map.entrySet()) {
            int currentAve = aveCalculate(entry.getValue());

            highestAve = Math.max(highestAve, currentAve);

        }
        return highestAve;
    }


   /*A: 100		100
    B: 90			90 < 100 => 100
    A: -100		0 < 100 => 100

    Res: 100*/

//    public static Integer bestAverageGradeFaster(String[][] scores) {
//        int highestAve = Integer.MIN_VALUE;
//        Map<String, List<Integer>> map = new HashMap<>();
//        float currentAve = 0;
//
//        for (int i = 0; i < scores.length; i++) {
//            List<Integer> scoreList = map.get(scores[i][0]);
//            if (scoreList == null) {
//                List<Integer> currentScore = new ArrayList<>();
//                currentScore.add(Integer.valueOf(scores[i][1]));
//                currentScore.add(1);
//                map.put(scores[i][0], currentScore);
//                currentAve = fasterAvgCalculate(currentScore);
//                highestAve = (int) Math.max(highestAve, currentAve);
//            } else {
//                List<Integer> currentScore = map.get(scores[i][0]);
//                currentScore.set(0, currentScore.get(0) + Integer.parseInt(scores[i][1]));
//                currentScore.set(1, currentScore.get(1) + 1);
//                map.put(scores[i][0], currentScore);
//                currentAve = fasterAvgCalculate(currentScore);
//                highestAve = (int) Math.max(highestAve, currentAve);
//            }
//        }
//        return highestAve;
//
//    }
//
//    private static int fasterAvgCalculate(List<Integer> scores) {
//        float ave = scores.get(0) / scores.get(1);
//        return (int) ave;
//    }


        private static int aveCalculate(List<Integer> scores) {
        int len = scores.size();
        int sum = 0;
        float ave = 0;
        for (int score : scores) {
            sum += score;
            ave = sum / len;
        }
        return (int) ave;
    }
//    private static int aveCalculate(List<Integer> scores) {
        // scores = [-1, -1, -1]
        // sum = 3.0f
        // len = 3
        // sign = -1
        // absRes = 1
        // res = -1
//        float sum = 0;
//        int len = scores.size();
//        for (int score : scores) {
//            sum += score;
//        }
//
//        int sign = 1;
//        if (sum < 0) {
//            sign = -1;
//            sum *= -1;
//        }
//        int absRes = (int) (sum / len);
//        int res = sign * absRes;
//    }

//    Class Node
//
//    {
//        public int totalScore;
//        public int numExams;
//
//        public Node() {
//        totalScore = 0;
//        numExams = 0;
//    }
//
//        public int getAvg() {
//            int sign = 1;
//            float sum = totalScore;
//            if (sum < 0) {
//                sign = -1;
//                sum *= -1;
//            }
//            int absRes = (int)(sum / numExams);
//            return (int) sign * absRes;
//        }
//
//        public void add(int score) {
//            totalScore += score;
//            numExams++;
//        }
//    }
//
//    public static Integer bestAverageGradeFaster(String[][] scores) {
//        int highestAve = Integer.MIN_VALUE;
//        Map<String, Node> student2Node = new HashMap<String, Node>();
//
//        for (int i = 0; i < scores.length; i++) {
//            String name = scores[i][0];
//            int score = Integer.valueOf(scores[i][1]);
//            if (student2Node.get(name) == null) {
//                Node node = new Node();
//                student2Node.put(name, node);
//            }
//            Node node = student2Node.get(name);
//            node.add(score);
//        }
//
//        for (Node node : student2Node.valueSet()) {
//            highestAve = Math.max(highestAve, node.getAvg());
//        }
//
//        return highestAve;
//
//    }

    /*
     **  Returns true if the tests pass. Otherwise, returns false;
     */
    public static boolean doTestsPass()
    {
        // TODO: implement more test cases
        String[][] tc1 = { { "Bobby", "87" },
                { "Charles", "100" },
                { "Eric", "64" },
                { "Charles", "22" } };

        return bestAverageGrade(tc1) == 87;
        //return bestAverageGradeFaster(tc1) == 87;
    }

    /*
     **  Execution entry point.
     */
    public static void main(String[] args)
    {
        // Run the tests
        if(doTestsPass())
        {
            System.out.println("All tests pass");
        }
        else
        {
            System.out.println("Tests fail.");
        }
    }
}



