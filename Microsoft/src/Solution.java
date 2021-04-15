//A method that will reverse the words in a sentence
//eg. input: The dog runs REALLY fast
//    output: fast REALLY runs the dog   leetcode-151

import java.util.*;
//solution1
public class Solution {
//    public static String ReverseString (String str) {
//            int n = str.length();
//            String tmp = "";
//
//            //trim the space between the str
//            int j = 0;
//            String[] arr = new String[n];
//            for(int i = 0; i < n; i++) {
//                if(str.charAt(i) !=' ' && str.charAt(i) != '.') {
//                    tmp +=str.charAt(i);
//                }else if(str.charAt(i) == '.' || str.charAt(i) == ' '){
//                    arr[j] = tmp;
//                    tmp = "";
//                    j++;
//                }
//            }
//            String ans = "";
//            //System.out.print(arr);
//
//            //reverse the string word by word
//        for(int i = arr.length - 1; i >= 0;i--) {
//            if(arr[i] == null) continue;
//            else{
//                ans = ans + " " + arr[i];
//            }
//        }
//        return ans + ".";
//    }

    //解法二
    public static String ReverseString (String str) {
        if(str == null || str.length() == 0) return null;

        int left = 0, right = str.length() - 1;

        //trim the leading space
        while(left <= right && str.charAt(left) == ' ') left++;
        //trim the trailing space
        while(left <= right && str.charAt(right) == ' ') right--;

        //traverse the str and put each word in the front of previous word when meet the space by using the deque
        Deque<String> d = new ArrayDeque<>();
        StringBuilder word = new StringBuilder(); //use the StringBuilder to append each words to get the word
        while(left <= right) {
            char c = str.charAt(left);

            if(word.length() != 0 && c == ' ') {
                d.offerFirst(word.toString());
                word.setLength(0);
            }else if(c != ' ') {
                word.append(c);
                //left++; 不然得到一个字符后一直在这个条件里面left++直到跳出这个字符串
            }
            left++;
        }
        d.offerFirst(word.toString());
        return String.join(" ", d);

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String str = "The dog runs REALLY fast ";

        System.out.println(solution.ReverseString(str));
    }
}
