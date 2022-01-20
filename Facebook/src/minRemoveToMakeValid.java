// String s = "lee(t(c)o)de)"
// output: lee(t(c)o)de, lee(t(c)ode)
//count = 0, '(' count+=1, ')'  count == 0, (, left++, ) balance-- )
//         0 1 2 3 4 5 6 7 8 9 10 11 12
//         l e e ( t ( c ) o ) d  e  )
// count:  0 0 0 1 1 2 2 1 1 0 0  0
// sb      l e e ( t ( c ) o ) d  e

//left->right:   (()) balance = 0, left = 2, (())), balance == 0 ),
//
// (())) (()
// left - balance = val > 0, left
//           (())(()



//public class minRemoveToMakeValid {
//    //pass1. left->right ')'
//    public String minRemove(String s) {
//        StringBuilder sb = new StringBuilder();
//        int balance = 0;
//        int left = 0;
//        for(int i = 0; i < s.length(); i++) {
//            char ch = s.charAt(i);
//            if(ch == '(') {
//                left++;
//                balance++;
//            } else if(ch == ')'){
//                if(balance == 0) continue;
//                balance--;   //(()(()
//            }
//            sb.append(ch);
//        }
//    //Pass2. ((() left = 3, balance = 2, left - balance = 1 ， open:左括号个数，balance:多出来左括号个数，open - balance = 需要留下左括号个数





