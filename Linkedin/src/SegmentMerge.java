import java.util.TreeMap;

//To improve file transfer speed, a file is split up into different portions and sent from multiple servers.
// The receiver downloads the file segments and recombine parts into the single file requested
class Segment {
    int start;
    int end;
}

//segments sent from different servers are not fully integrated. As a result segments can be overlapping,
// like [1, 3] and [2, 4] should be merged and considered as [1, 4] with a total length 3 in getFileSize().


public class SegmentMerge {

    TreeMap<Integer, Integer> map = new TreeMap<>(); //start->end

    public static void main(String[] args) {
        SegmentMerge obj = new SegmentMerge();
        Segment s = new Segment();

        s.start=4;
        s.end=6;
        obj.add(s);

        s.start=1;
        s.end=5;
        obj.add(s);

        System.out.println(obj.getFileSize() + " map size->" + obj.map.size());
//
//        s.start=10;
//        s.end=20;
//        obj.add(s);
//
//        s.start=25;
//        s.end=30;
//        obj.add(s);
//
//        System.out.println(obj.getFileSize() + " map size->" + obj.map.size());
//
//        s.start=19;
//        s.end=29;
//        obj.add(s);
//
//        System.out.println(obj.getFileSize() + " map size->" + obj.map.size());
//
//        s.start=2;
//        s.end=50;
//        obj.add(s);
//
//        System.out.println(obj.getFileSize() + " map size->" + obj.map.size());
    }

    private Integer fileSize=new Integer(0);

    public void add(Segment segment) {
        Integer start = segment.start;
        Integer end = segment.end;
        Integer key = map.floorKey(start); //map里less than or equal to start,比当前start小的

        if(key!=null) {  //首先这个key要存在，比如key = 4, [1,5][4,6]
            if(map.get(key)>start) {
                fileSize-=(map.get(key)-key); //对应的end大于key, 减掉2（6-4）然后算新的start, end,
                map.remove(key);
                start=key;
            }
        }

        key  = map.floorKey(end); //key比当前end小的值，key=4就是上一个的start
        while(key!=null && key > start) {
            fileSize-=(map.get(key)-key);
            end=map.get(key)>end?map.get(key):end;  //取一个大的作为end
            map.remove(key);
            key  = map.floorKey(end);
        }

        fileSize+=end-start;
        map.put(start, end);
    }

    public int getFileSize() {
        return fileSize;
    }
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
//class Solution {
//    public boolean isNumber(String s) {
//        boolean seenDigit = false;
//        boolean seenExponent = false;
//        boolean seenDot = false;
//
//        for (int i = 0; i < s.length(); i++) {
//            char curr = s.charAt(i);
//            if (Character.isDigit(curr)) {
//                seenDigit = true;
//            } else if (curr == '+' || curr == '-') {
//                if (i > 0 && s.charAt(i - 1) != 'e' && s.charAt(i - 1) != 'E') {
//                    return false;
//                }
//            } else if (curr == 'e' || curr == 'E') {
//                if (seenExponent || !seenDigit) {
//                    return false;
//                }
//                seenExponent = true;
//                seenDigit = false;
//            } else if (curr == '.') {
//                if (seenDot || seenExponent) {
//                    return false;
//                }
//                seenDot = true;
//            } else {
//                return false;
//            }
//        }
//
//        return seenDigit;
//    }
//}