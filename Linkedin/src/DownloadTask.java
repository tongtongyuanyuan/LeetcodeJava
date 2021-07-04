//To improve file transfer speed, a file is split up into different portions and sent from multiple servers.
// The receiver downloads the file segments and recombine parts into the single file requested
class Segment {
    int start;
    int end;
}

//egments sent from different servers are not fully integrated. As a result segments can be overlapping,
// like [1, 3] and [2, 4] should be merged and considered as [1, 4] with a total length 3 in getFileSize().
class DownloadTask {
    // add a segment into recombined file
    public void add(Segment segment) {}

    // find total length of downloaded segments
    public int getFileSize() {}
}

// 下面我们开始正式分开头中间结尾三个位置来讨论情况：

// 1. 在讨论三个位置之前做预处理，去掉字符串首尾的空格，可以采用两个指针分别指向开头和结尾，遇到空格则跳过，分别指向开头结尾非空格的字符。

// 2. 对首字符处理，首字符只能为数字或者正负号 '+/-"，我们需要定义三个flag在标示我们是否之前检测到过小数点，自然数和正负号。首字符如为数字或正负号，则标记对应的flag，若不是，直接返回false。

// 3. 对中间字符的处理，中间字符会出现五种情况，数字，小数点，自然数，正负号和其他字符。

// 若是数字，标记flag并通过。

// 若是自然数，则必须是第一次出现自然数，并且前一个字符不能是正负号，而且之前一定要出现过数字，才能标记flag通过。

// 若是正负号，则之前的字符必须是自然数e，才能标记flag通过。

// 若是小数点，则必须是第一次出现小数点并且自然数没有出现过，才能标记flag通过。e之前不能有小数点

// 若是其他，返回false。

// 4. 对尾字符处理，最后一个字符只能是数字或小数点，其他字符都返回false。

// 若是数字，返回true。
class Solution {
    public boolean isNumber(String s) {
        boolean seenDigit = false;
        boolean seenExponent = false;
        boolean seenDot = false;

        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            if (Character.isDigit(curr)) {
                seenDigit = true;
            } else if (curr == '+' || curr == '-') {
                if (i > 0 && s.charAt(i - 1) != 'e' && s.charAt(i - 1) != 'E') {
                    return false;
                }
            } else if (curr == 'e' || curr == 'E') {
                if (seenExponent || !seenDigit) {
                    return false;
                }
                seenExponent = true;
                seenDigit = false;
            } else if (curr == '.') {
                if (seenDot || seenExponent) {
                    return false;
                }
                seenDot = true;
            } else {
                return false;
            }
        }

        return seenDigit;
    }
}