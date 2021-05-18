import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class KDintinct {
    //public static int findKDistinct(String s, int k) {
//    HashMap<Character, Integer> m = new HashMap<>();
//
//    HashSet<String> res = new HashSet<>();
//    int left = 0, right = 0;
//    int len = s.length();
//				while(left < right) {
//                    char cur = s.charAt(right);
//                    char lc = s.charAt(left);
//                    //之前没见过
//                    if (m.get(cur) == 0) {
//                        m.put(cur, m.get(cur) + 1);
//                        k--;
//                    } else {
//                        while (lc != cur) {
//                            m.put(lc, m.get(lc) - 1);
//                            left++;
//                            k++;
//                        }
//                        left++;
//                    }
//                    if (k == 0) {
//                        res.add(s.substring(left, right - left + 1));
//                        m.put(lc, m.get(lc) - 1);
//                        k++;
//                    }
//                    right++;
//                }
//        return res.size();
//        public static int findKDistinctString(String s, int k) {
//            if(s == null) return 0;
//            int len = s.length();
//            int res = 0;
//            for(int i = 0; i < len; i++) {
//                int count = k;
//                HashSet<Character> exist = new HashSet<>();
//                for(int j = i; j < len; j++) {
//                    if(!exist.contains(s.charAt(j))){
//                        exist.add(s.charAt(j));
//                        count--;
//                    }
//                    if(count == 0)
//                        res++;
//                    if(count < 0) break;
//                }
//            }
//            return res;
//        }
    public static long findKDistinctString(String s, int k) {
        if(s.length() == 0) {
            return 0;
        }
    int n = s.length();
    long numOfSubstrings = 0;
    int differentChars = 0;
    Map<Character, Integer> counter = new HashMap<>();
    int j = 0;

		for(int i = 0; i < n; i++) {
        while(j < n && differentChars < k) {
            int numOfThisChar = counter.getOrDefault(s.charAt(j), 0);
            counter.put(s.charAt(j), numOfThisChar + 1);
            if(counter.get(s.charAt(j)) == 1) {
                differentChars++;
            }
            j++;
        }
        if(differentChars == k){
            numOfSubstrings += n - j + 1;
        }

        //move left pointer out of this current sliding window
        counter.put(s.charAt(i), counter.get(s.charAt(i)) - 1);
        if(counter.get(s.charAt(i)) == 0) {
            differentChars--;
        }
    }
			return numOfSubstrings;
}

    public static void main(String args[]) {
        String input = "abcaac";
        int k = 2;
        long res = KDintinct.findKDistinctString(input, k);
        System.out.print(res);
    }
}
