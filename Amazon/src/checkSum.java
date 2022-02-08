/*
In this problem, you will build an application which calculates the checksum of a data set. The input comes in the form of a table. For each row in the table, determine the difference between the largest value and the smallest value; the checksum is the sum of all those differences.
Example
Input table:

5 1 9 5
7 5 3
2 4 6 8

The first row's largest and smallest values are 9 and 1. The difference is 8.
The second row's largest and smallest values are 7 and 3. The difference is 4.
The third row's largest and smallest values are 8 and 2. This row's difference is 6.
In this example, the checksum would be 8 + 4 + 6 = 18
checksum(("5 1 9 5\n7 5 3\n2 4 6 8");
*/
//import java.io.*;
//
//    /* Name of the class has to be "Main" only if the class is public. */
//    class Solution


public class checkSum {
        public static int getChecksum(String s) {
            if(s == null || s.isEmpty()) return 0;

//            String[] str = s.split("\n");//---> 5, 1, 9, 5 7,5,3,
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;
            long diff = 0;
            long checksum = 0;
            for(String line : s.split("\n")) {  //"5 1 9 5"--->注意得到的数字之间是有空格的，所以toCharArray()有空格
//                String nums = str.replaceAll("\\s", ""); //转完之后变为5195--->有两三位数就错了
//                for(char c : nums.toCharArray()) {
               // String[] c = str.split(" ");
                for(String number : line.split(" ")) {
                int num = Integer.parseInt(String.valueOf(number));
                //[       ]
                //[5,1,9,5]
                //[1,2,4, ]  //diff可能会溢出，要是没数字的话，max就是Integer.MIN_VALUE, min是Integer.MAX_VALUE;
                max = Math.max(max, num);
                min = Math.min(min, num);
                }
                diff = max - min;
                checksum += diff; //checksum一直累加diff,会有溢出的情况
            }
            return (int)checksum;
        }


        public static void main (String[] args)
        {
            String s ="5 1 9 5\n7 5 3\n2 4 6 8";
            int res = getChecksum(s);
            System.out.println(res);
        }
    }
