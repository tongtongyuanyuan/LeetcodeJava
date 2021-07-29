import java.util.ArrayList;
import java.util.List;

/* eg1.
Input: words = ["This", "is", "an", "example", "of", "text", "justification."], maxWidth = 16
Output:
[
   "This    is    an",
   "example  of text",
   "justification.  "
]

eg2.
Input: words = ["What","must","be","acknowledgment","shall","be"], maxWidth = 16
Output:
[
  "What   must   be",
  "acknowledgment  ",
  "shall be        "
]
Explanation: Note that the last line is "shall be    " instead of "shall     be", because the last line must be left-justified instead of fully-justified.
Note that the second line is also left-justified becase it contains only one word.

Solution1.思路：
1.首先要做的就是确定每一行能放下的单词数，这个不难，就是比较n个单词的长度和加上n - 1个空格的长度跟给定的长度L来比较即可，
找到了一行能放下的单词个数，然后计算出这一行存在的空格的个数，是用给定的长度L减去这一行所有单词的长度和。
2.得到了空格的个数之后，就要在每个单词后面插入这些空格，这里有两种情况，比如某一行有两个单词"to" 和 "a"，给定长度L为6，
如果这行不是最后一行，那么应该输出"to   a"，如果是最后一行，则应该输出 "to a  "
3. 最后一行单独处理
4.难点：如果一行有三个单词，这时候中间有两个空，如果空格数不是2的倍数，那么左边的空间里要比右边的空间里多加一个空格
那么要用总的空间数除以空间数，能除尽最好，说明可以平均分配，如果除不尽就多加个空格放在左边的空间里*/


/*
Solution2.
findRight: Then we greedily try to go as far right as possible until we fill our current line.

        Then we justify one line at a time.

        justify: In all cases we pad the right side with spaces until we reach max width for the line;

        If it's one word then it is easy, the result is just that word.
        If it's the last line then the result is all words separated by a single space.
        Otherwise we calculate the size of each space evenly and if there is a remainder
        we distribute an extra space until it is gone.
 */


public class Text {

    public static List<String> fullJustify(String[] words, int maxWidth) {
        int left = 0;
        List<String> res = new ArrayList<>();

        while(left < words.length) {
            int right = findRight(left, words, maxWidth);
            res.add(justify(left, right, words, maxWidth));
            left = right + 1;
        }
        return res;
    }


    private static int findRight(int left, String[] words, int maxWidth) {
        int right = left;
        int sum = words[right++].length();

        while(right < words.length && (sum + 1 + words[right].length()) <= maxWidth)
            sum += 1 + words[right++].length();

        return right - 1;
    }

    private static String justify(int left, int right, String[] words, int maxWidth) {
        if(right - left == 0) return padResult(words[left], maxWidth);

        boolean isLastLine = right == words.length - 1;
        int numSpaces = right - left;
        int totalSpace = maxWidth - wordsLength(left, right, words);

        String space = isLastLine ? " " : blank(totalSpace / numSpaces);
        int remain = isLastLine ? 0 : totalSpace % numSpaces;

        StringBuilder result = new StringBuilder();
        for(int i = left; i <= right; i++) {
            result.append(words[i])
                    .append(space)
                    .append(remain-- > 0 ? " " : "");
        }
        return padResult(result.toString().trim(), maxWidth);
    }

    private static int wordsLength(int left, int right, String[] words) {
        int wordsLength = 0;
        for(int i = left; i <= right; i++) {
            wordsLength += words[i].length();
        }
            return wordsLength;
    }

    private static String padResult(String res, int maxWidth) {
        return res + blank(maxWidth - res.length());
    }
    private static String blank(int length) {
        return new String(new char[length]).replace('\0', ' ');
    }

    public static void main(String[] args) {
         String[] words = {"This",  "is", "an", "example", "of", "text", "justification."};
         int maxWidth = 16;
         List<String> res = Text.fullJustify(words, maxWidth);
         System.out.println(res);
    }
}



