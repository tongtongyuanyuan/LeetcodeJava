//import java.util.HashSet;
//import java.util.Set;
//
//public class LongestSubstringWithoutSensitiveWords {
//
//    public static String findLongestSubstring(String S, Set<String> sensitiveWords) {
//        int n = S.length(); // 输入字符串的长度
//        int left = 0; // 滑动窗口的左边界
//        int right = 0; // 滑动窗口的右边界
//        int longestLength = 0; // 最长子字符串的长度
//        String longestSubstring = ""; // 最长子字符串
//
//        while (right < n) {
//            if (!isSensitive(S,left, right, sensitiveWords)) {
//                right++;
//            } else {
//                // 发现敏感词，更新滑动窗口的左边界，并比较当前子字符串的长度
//                int substringLength = right - left + 1;
//                if (substringLength > longestLength) {
//                    longestLength = substringLength;
//                    longestSubstring = S.substring(left, right + 1);
//                }
//
//                // 将滑动窗口的左边界移到当前敏感词的下一个位置
//                left = right + 1;
//                right = left;
//            }
//        }
//
//        // 处理最后一个子字符串
//        int substringLength = right - left;
//        if (substringLength > longestLength) {
//            longestLength = substringLength;
//            longestSubstring = S.substring(left, right);
//        }
//
//        return longestSubstring;
//    }
//
//    private boolean isSensitive(String S, int left, int right,Set<String> sensitiveWords) {
//        for(; right > 0; --right) {
//
//        }
//
//    }
//
//    public static void main(String[] args) {
//        String S = "This is a sample string.";
//        Set<String> sensitiveWords = new HashSet<>();
//        sensitiveWords.add("sample");
//        sensitiveWords.add("string");
//        String result = findLongestSubstring(S.replaceAll("\\s", ""), sensitiveWords);
//        System.out.println(result);
//    }
//}
//
//
