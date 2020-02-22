package com.xyj.leetcode;


import com.xyj.zhanPackage.Stack;

public class 有效的括号 {
    //｛【】｝有效 ([)]无效
    //只有这三种括号 【】｛｝（）
    public static void main(String[] args) {
        String s = "{{sda}}[]";
        System.out.println(okStringz(s));
    }

    //用栈结构数据解决
    public static boolean okStringz(String s) {
        int len = s.length();
        Stack<Character> stack = new Stack<>();
        for(int a = 0;a<len;a++){
            char c = s.charAt(a);
            if('{'==c || '['==c ||c == '('){
                    stack.push(c);
            }
            if('}'==c || ']'==c ||c == ')'){
                    if(stack.isEmpty()){return false;}
                Character left = stack.pop();
                    if(left == '('&&  c!= ')'){return false;}
                    if(left == '{'&&  c!= '}'){return false;}
                    if(left == '['&&  c!= ']'){return false;}
            }
        }
        return stack.isEmpty();
    }
    //效率实在太低了,完全用不了
    public static boolean okString(String s){
        while (s.contains("{}")||
                s.contains("[]")||
                s.contains("()")){
            s.replace("{}","");
            s.replace("[]","");
            s.replace("()","");
        }
        return s.isEmpty();
    }
}
