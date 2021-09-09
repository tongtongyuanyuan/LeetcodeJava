/*
A cafeteria table ocnsists of a row of N seats, numners from 1 to N from left to right.
Social distancing require that every diner be seated such that K seats their left and K seats to their
right remain empty

There are currently M diners seated at the table, detemine the maximum number of additional diners who can potentially
sit at the table without social distancing guidelines being violoated for any new or existing diners
https://leetcode.com/discuss/interview-question/1376859/Facebook-Puzzle
 */


import java.util.Arrays;

public class Cafeteria {

    public long getMaxAdditionalDinersCount(long N, long K, int M, long[] S) {

        Arrays.sort(S);
        long guests = 0;
        long start = 1;
        long range = 0;
        for(long seatedDiner : S) {
            range = seatedDiner - start;
            guests += (long)(Math.floor(range/(K+1)));
            start = seatedDiner + K + 1;
        }
        range = N - start + 1;
        guests += Math.ceil(range / (K + 1));


        return guests;
    }

}
