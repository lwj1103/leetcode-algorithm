package alrorithm.queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class StackAndQueue {
    public static void main(String[] args) {
//        MyQueue myQueue = new MyQueue();
//        System.out.println(myQueue.empty());
//        myQueue.push(1);
//        myQueue.push(2);
//        myQueue.push(3);
//        myQueue.push(4);
//        System.out.println(myQueue.peek());
//        System.out.println(myQueue.pop());

//        String s = "(){}[]";
//        boolean valid = isValid2(s);
//        System.out.println(valid);

        String s = "abbaac";
        String s1 = removeDuplicates(s);
        System.out.println(s1);

    }
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            String s = tokens[i];
            if("+".equals(s)) {
                stack.push(stack.pop()+stack.pop());
            }
            else if ("-".equals(s)) {
                stack.push(-stack.pop()+stack.pop());
            } else if ("*".equals(s)) {
                stack.push(stack.pop()*stack.pop());
            } else if ("/".equals(s)) {
                int post = stack.pop();
                int pre = stack.pop();
                stack.push(pre/post);
            }
            else {
                stack.push(Integer.parseInt(s));
            }
        }
        return stack.peek();
    }
    public static boolean isValid(String s) {
        Stack<Character> stack= new Stack<>();
        for (int i = 0;i<s.length();i++){
            char ch = s.charAt(i);
            if(!stack.isEmpty()&&((stack.peek()=='('&&ch==')')||(stack.peek()=='{'&&ch=='}')||(stack.peek()=='['&&ch==']'))){
                stack.pop();
            }
            else {
                stack.push(ch);
            }
        }
        if(stack.isEmpty()) return true;
        else return false;
    }
    public static boolean isValid2(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(ch == '(') stack.push(')');
            else if (ch == '{') stack.push('}');
            else if (ch == '[') stack.push(']');
            else if (stack.isEmpty()|| ch!=stack.peek()) {
                return false;
            }
            else {
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
    public static  String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(!stack.isEmpty()&& ch == stack.peek()){
                stack.pop();
            }
            else {
                stack.push(ch);
            }
        }
        StringBuffer sb = new StringBuffer();
        while (!stack.empty()){
            sb.insert(0,stack.pop());
        }
        return sb.toString();
    }
}

class MyQueue {
    Stack<Integer> stackIn;
    Stack<Integer> stackOut;
    public MyQueue() {
        stackIn = new Stack<>();
        stackOut = new Stack<>();
    }

    public void push(int x) {
        stackIn.push(x);
    }

    public int pop() {
        dumpStackIn();
        return stackOut.pop();
    }



    public int peek() {
        dumpStackIn();
        return stackOut.peek();
    }

    public boolean empty() {
        return stackIn.isEmpty()&& stackOut.isEmpty();
    }
    private void dumpStackIn() {
        if(!stackOut.isEmpty()) return;
        while (!stackIn.isEmpty()){
            stackOut.push(stackIn.pop());
        }
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */

class MyStack {
    Queue<Integer> queue;
    public MyStack() {
        queue = new LinkedList<>();
    }

    public void push(int x) {
        queue.offer(x);
        int size = queue.size();
        while (size-- >1){
            queue.offer(queue.poll());
        }
    }

    public int pop() {
        return queue.poll();
    }

    public int top() {
        return queue.peek();
    }

    public boolean empty() {
        return queue.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
