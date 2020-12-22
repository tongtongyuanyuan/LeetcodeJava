//Solution1. Sorting Based
//1. Sort the array in non-decreasing order.
//2. Initialize two index variables to find the candidate
//   elements in the sorted array.
//       (a) Initialize first to the leftmost index: l = 0
//       (b) Initialize second  the rightmost index:  r = ar_size-1
//3. Loop while l < r.
//       (a) If (A[l] + A[r] == sum)  then return 1
//       (b) Else if( A[l] + A[r] <  sum )  then l++
//       (c) Else r--
//4. No candidates in whole array - return 0
// T = O(nlogn)

//Solution2. Hahsing Based
//1. Maintain HashMap for all Integer with Key as B-A[i] and Value as Index i.
//2. Before insert, check that number is already present in Map.
//   If YES, Return current index as index2 and index1 from Map entry.
//   If NO, Insert new entry to the map.
//T = O(n) S = O(n)

import java.util.*;

public class TwoSumZero {

    public ArrayList<Integer> twoSum(final List<Integer> A, int B) {


        ArrayList<Integer> result=new ArrayList<Integer>();  //result list for index1 and index2

        Map<Integer,Integer> map=new HashMap<Integer,Integer>();

        if(A.size()<2) return result;


        for(int i=0;i<A.size();i++){

            if(map.containsKey(A.get(i))){     // Check if number is already present in Map
                result.add(map.get(A.get(i)));  //Get index1 from Map entry value.
                result.add(i+1);                //Current index will be index2
                break;
            }

            if(!map.containsKey(B-A.get(i)))map.put(B-A.get(i),i+1); //Insert new entry
        }
        return result;
    }
    public static void main(String[] args) {

        Integer [] a= { 2, 7, 11, 15 };

        System.out.println(new TwoSumZero().twoSum(Arrays.asList(a), 9));
    }

}

//https://codenuclear.com/two_sum_problem/