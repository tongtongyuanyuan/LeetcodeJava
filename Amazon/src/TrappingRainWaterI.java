import java.util.Stack;

// 解放这个算法需要 left 和 right 两个指针分别指向数组的首尾位置，从两边向中间扫描，在当前两指针确定的范围内，先比较两头找出较小值，如果较小值是 left 指向的值，则从左向右扫描，如果较小值是 right 指向的值，则从右向左扫描，若遇到的值比当较小值小，则将差值存入结果，如遇到的值大，则重新确定新的窗口范围，以此类推直至 left 和 right 指针重合
class TrappingRainWaterI {
    public int trap(int[] height) {
        int l = 0, r = height.length - 1;
        int res = 0;
        while(l < r) {
            int mn = Math.min(height[l], height[r]);
            if(height[l] == mn) {
                ++l;  //先加
                while(l < r && height[l] < mn) {
                    res += mn - height[l];
                    l++;
                }
            }else {
                --r;
                while(l < r && height[r] < mn) {
                    res += mn - height[r];
                    r--;
                }
            }
        }
        return res;
    }
}
//Monotonous Stack
//class TrappingRainWaterI{
//    public int trap(int[] height) {
//        int l = 0, r = height.length, res = 0; //r不是height.length - 1
//        Stack <Integer> s = new Stack<>();
//        while(l < r) {
//            if(s.isEmpty() || height[l] <= height[s.peek()]) {
//                s.push(l);
//                l++;
//            }else{
//                int t = s.pop();
//                if(s.isEmpty()) continue;
//                int maxDiff = Math.min(height[l], height[s.peek()]) - height[t];
//                res += maxDiff * (l - s.peek() - 1);
//            }
//        }
//        return res;
//    }
//}
