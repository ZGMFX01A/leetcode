package Algorithm;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class IsValid{
    public boolean isValid(String s) {
        int len = s.length();
        if (len%2==1){
            return false;
        }
        Map<Character,Character> map = new HashMap<Character,Character>(){{
            //后遇到的左括号要先闭合，因此我们可以将这个左括号放入栈顶
            put(')','(');
            put(']','[');
            put('}','{');
        }};
        Deque<Character> deque = new LinkedList<Character>();
        for (int i=0; i <len; i++) {
            char c =s.charAt(i);
            //map中是否有这个键
            if (map.containsKey(c)){
                //栈是否为空，栈的第一个元素是否等于map的s.charAt(i)键的值(value)
                if (deque.isEmpty()||deque.peek()!=map.get(c)){
                return false;
                }
                //删除第一个元素
                deque.pop();
            }else{
                deque.push(c);
            }
        }
        return deque.isEmpty();
    }
    public boolean isValid2(String s) {
        int len = s.length();
        if (len%2==0) {
            Deque<Character> deque = new LinkedList<>();
            for (int i = 0; i < len; i++) {
                char c = s.charAt(i);
                if (c == '(' || c == '[' || c == '{') {
                    //如果是左括号就放入栈
                    deque.push(c);
                } else if (c == ')') {
                    if (!deque.isEmpty() && deque.peek() == '(') {
                        deque.pop();
                    } else {
                        return false;
                    }
                } else if (c == ']') {
                    if (!deque.isEmpty() && deque.peek() == '[') {
                        deque.pop();
                    } else {
                        return false;
                    }

                } else if (c == '}') {
                    if (!deque.isEmpty() && deque.peek() == '{') {
                        deque.pop();
                    } else {
                        return false;
                    }
                }
            }
            return deque.isEmpty();
        }
        return false;
    }
}
