package com.mloine.stack;
/**
 * @Author mloine
 * @Description 利用栈 做简单表达式计算   char 和 int 互通的
 * @Date 3:24 下午 2020/2/26
 */
public class Calculator {

    public static void main(String[] args) {
        // 15
//        String expression = "70+2*6-4";
        // 18
        String expression = "7*2*2-5+1-5+3-4";

        //创建数栈
        ArrayStack2 numberStack = new ArrayStack2(10);
        //创建符号栈
        ArrayStack2 operStack = new ArrayStack2(10);

        // 定义 扫描字符串的索引
        int index = 0;

        int num1 = 0;
        int num2 = 0;
        int oper = 0;
        int res = 0;
        int ch = ' ';

        String keepNUm = "";// 用于拼接多位数

        while(true){
            ch = expression.substring(index,index + 1).charAt(0);
            //判断 是 数字 还是运算符号
            if(operStack.isOper((char)ch)){
                // 符号
                if(operStack.isEmpty()){
                    // 如果为空 直接入栈
                    operStack.push(ch);
                }else{
                    // 入栈运算符号 优先级小于栈顶优先级
                    if(operStack.priority(ch) <= operStack.priority(operStack.peek())){
                        // 数栈取出 两个数    符号栈取出两个数
                         num1 = numberStack.pop();
                         num2 = numberStack.pop();
                         oper = operStack.pop();
                         res = operStack.cal(num1, num2, oper);
                         // 计算结果 入栈
                         numberStack.push(res);
                         // 符号入栈
                         operStack.push(ch);
                    }else{
                        // 优先级大于
                        operStack.push(ch);
                    }
                }
            }else{
                // 数字
                // 处理多位数的时候不能立即入栈
                keepNUm += (char)ch;
                //如果是最后一位 直接入栈
                if(index == expression.length() - 1){
                    numberStack.push(Integer.parseInt(keepNUm));

                }else{
                    if(operStack.isOper(expression.substring(index+1,index+2).charAt(0))){
                        //如果后一位是运算符
                        numberStack.push(Integer.parseInt(keepNUm));
                        keepNUm = "";
                    }
                }
                // 直接入栈 ascil 码
//                numberStack.push(ch - 48);
            }
            index++;
            //判断是否扫描到最后 出循环
            if(index >= expression.length()){
                break;
            }
        }

        // 做最后运算
        while(true){
            if(operStack.isEmpty()){
                //计算结束
                break;
            }else{
                num1 = numberStack.pop();
                num2 = numberStack.pop();
                oper = operStack.pop();
                res = operStack.cal(num1, num2, oper);
                numberStack.push(res);
            }
        }

        // 将最后数栈数 pop出来 就是计算结果
        int result = numberStack.pop();
        System.out.printf("表达式 %s 计算结果为 %d \n",expression,result);
    }
}



// 模拟栈
class ArrayStack2{

    // 栈最大空间
    private int maxSize;

    // 数组模拟栈
    private int[] stack;

    // 栈顶
    private int top  = -1;


    private char c = '*';
    private char c1 = '/';
    private char c2 = '+';
    private char c3 = '-';

    public ArrayStack2(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[maxSize];
    }

    /**
     * 判断栈满
     * @return
     */
    public boolean isFull(){
        return maxSize - 1 == top;
    }

    /**
     * 判断栈空
     * @return
     */
    public boolean isEmpty(){
        return top == -1;
    }

    /**
     * 入栈 - push
     * @param value
     */
    public void push(int value){
        if(isFull()){
            System.out.println("栈满！！！");
            return;
        }
        top++;
        stack[top] = value;
    }

    /**
     * 出栈 - pop
     */
    public int pop(){
        if(isEmpty()){
            throw  new RuntimeException("栈空！！ 不能添加");
        }
        int result = stack[top];
        top--;
        return result;
    }

    /**
     * 遍历栈
     */
    public void list(){
        if(isEmpty()){
            System.out.println("栈空 没有数据");
            return;
        }
        for (int i = top; i >= 0; i--) {
            System.out.printf("stack[%d]=%d\n",i,stack[i]);
        }
    }


    /**
     * 返回运算符的优先级
     * 优先级越大 数字越大
     */
    public int priority(int opt){
        if(opt == c || opt == c1){
            return 1;
        }else if(opt == c2 || opt == c3){
                return 0;
        }else{
            return -1;
        }
    }

    /**
     * 判断是否是运算符号
     * @param val
     * @return
     */
    public boolean isOper(char val){
        return val == c || val == c1 || val == c2 || val == c3;
    }

    /**
     * 计算方法
     * @param num1  值1
     * @param num2  值2
     * @param oper  符号
     * @return
     */
    public int cal(int num1,int num2,int oper){
        int res = 0;
        switch (oper){
            case '+':res = num1 + num2;break;
            case '-':res = num2 - num1;break;
            case '*':res = num1 * num2;break;
            case '/':res = num2 / num1;break;
            default:break;
        }
        return res;
    }


    public int peek(){
//        if(isEmpty()){}
        return stack[top];
    }
}

