package stack;

import java.util.Stack;

//Given a string containing just the characters '(' and ')',
// find the length of the longest valid (well-formed) parentheses substring.
//Time complexity is O(n)
public class LongestValidParanthesis{

    public int longestParent(String s){

        if (s.length()==1){
            return 1;
        }
        int maxans=0;
        Stack<Integer> st = new Stack<>();
        st.push(-1);
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                st.push(i);
            }else {
                st.pop();
            }
            if (st.isEmpty()){
                st.push(i);
            }else {
                maxans = Math.max(maxans,i-st.peek());
            }
        }
        return maxans;
    }
}
