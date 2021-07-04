//Input: maxTravelDist = 7000
//forwardRouteList = [[1,2000], [2,4000],[3,6000]];
//returnRouteList = [[1,2000]];
// combination:[1,1]: 4000, [2,1]:6000, [3,1]: 8000 > maxTravelDis(7000)
//so-> [2,1]: 6000 is the only optimal pair

//eg2.Input: maxTraverlDist= 10000
//forwardRouteList = [[1,3000],[2,5000],[3,7000],[4,10000]]
//returnRouteList = [[1,2000], [2,3000],[3,4000],[4,5000]]
//output: [[2,4], [3,2]]([2,4] 10000 , [3,2]: 10000)
//Two pointers:
import java.util.*;
import java.util.stream.Collectors;


// a str1 str2 str3
// b str4 str5 srt6

// {id} {version}
// {字母+数字} {用空格相连的字母串 或者 用空格相连的数字串}
// 排序规则
// 如果 version是数字串，保持当前顺序，放到所有字母串的后面
// 举例
// id3 a b c
// id1 6 2 3
// id2 3 4 5
// 如果两个字符串相比较的时候，一个是数字串，一个是字母串，那么 数字串 > 字母串
// 如果两个字符串都是数字串， 为了保持初始的顺序，那么就 数字串 = 数字串
// 如果两个字符串都是字母串，进行字典序比较 字母串 ？ 字母串
//      如果两个字母串相等，字典序比较id

// 符合要求的
// 123 abc dqwasd
// asd alq qwe
// 1a2 asd qwe
// asd 1 2 3

// 不符合要求的
// asd a1 b1


/*
max = 1001
go = [[1, 1000], [2, 500], [3, 1500]]
back = [[1, 3000], [2, 2000], [3, 2500]]

brute-force
1, 1000
1000+3000 = 4000
1000 + 2000 = 3000
max_res = 4000
4000: [1, 1]
3000: [1, 2]

1, 1
1000 + 3000 = 4000
第一次优化算法
把 back 排序后
back = [2, 2000], [3, 2500], [1, 3000]
1000 + 3000
最坏情况 当max很小的时候，还是要跑全部的n * m种情况


第二次优化算法
已知 1000 + 2500 > max = 1001
那么 1500 + 2500 必然也大于 max，没有必要再算一次了
为了避免多余的计算。我们把go也排序
go = [2, 500], [1, 1000], [3, 1500]
back = [2, 2001], [3, 2500], [1, 3000]
max_dist = 3002

cur_max = -1
1.500 + 3000 > 3000
那么500 之后的比500大的都没有必要看了
2. 500 + 2500 = 3000

3000 <= max_dist {
    3000 > cur_max
    [500 + 2500]
    cur_max = 3000
}

3. 1000 + 2500 > max_dist
1000 + 2001 = 3001 <= max_dist
3001 > cur_max
cur_max = 3001
[1000 + 2001]


go = [4, 1000], [2, 3000], [3, 4000], [5, 4000], [1, 5000]
back = [1, 2000], [2, 5000], [3, 5000], [4, 6000]
max_dist = 9000
cur_max = -1;

1. 1000 + 6000
cur_max = 7000
[1000, 6000]
2. 3000 + 6000
cur_max = 9000
[3000, 6000]
3. 4000 + 6000
cur_max = 9000
4. 4000 + 5000 <= max_dist
9000 == cur_max
[3000, 6000] [4000, 5000]

 */
public class PrimeMaxProfit {

    public static void main(String[] args) {
        int maxTravelDist = 9000;
        List<List<Integer>> forwardRouteList = Arrays.asList(
                Arrays.asList(4, 1000),
                Arrays.asList(2, 3000),
                Arrays.asList(3, 4000),
                Arrays.asList(5, 4000),
                Arrays.asList(1, 5000)
        );
        List<List<Integer>> returnRouteList = Arrays.asList(
                Arrays.asList(1, 2000),
                Arrays.asList(2, 5000),
                Arrays.asList(3, 5000),
                Arrays.asList(4, 6000)
        );
        System.out.println(routePairs(maxTravelDist, forwardRouteList, returnRouteList));
    }


    static class COM1 implements Comparator<List<Integer>> {
        public int compare(List<Integer> a, List<Integer> b) {
            return a.get(1) - b.get(1);
        }
    }

    public static List<List<Integer>> routePairs(int maxTravelDist, List<List<Integer>> forwardRouteList, List<List<Integer>> returnRouteList) {
        Collections.sort(forwardRouteList, new COM1());
        Collections.sort(returnRouteList, new COM1());
        List<List<Integer>> res = new ArrayList<>();
        int cur_max = -1;
        int i = 0;
        int j = returnRouteList.size() - 1;
        while (i < forwardRouteList.size() && j >= 0) {
            int go = forwardRouteList.get(i).get(1);
            int back = returnRouteList.get(j).get(1);
            if (go + back <= maxTravelDist) {
                if (go + back < cur_max) {
                    i++;
                    continue; //继续走go
                }
                if (go + back > cur_max) {
                    res.clear();
                    cur_max = go + back; //用go+back更新cur_max,都是在<=maxTravelDist的情况下
                }
                int next_j = j;
                while (next_j >= 0 && returnRouteList.get(next_j).get(1) == back) {
                    res.add(Arrays.asList(forwardRouteList.get(i).get(0), returnRouteList.get(next_j).get(0)));
                    next_j--;  //>=cur_max时，但是都<=maxTravelDist
                }
                i++;
            }
            else {
                j--; //移动back里的指针
            }
        }
        return res;

    }

}
