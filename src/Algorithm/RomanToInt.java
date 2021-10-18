package Algorithm;

import java.util.HashMap;
import java.util.Map;

public class RomanToInt {
    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        int number = 0;
        int length = s.length();
        int high=1;
        for (int i = 0; i < length; i++) {
            int value=map.get(s.charAt(i));
            if(i<length-1&&value<map.get(s.charAt(i+1))){
                number-=value;
            }else{
                number+=value;
            }
        }
        return number;
    }
    public int romanToInt2(String s) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        int number = 0;
        int length = s.length();
        int high=1;

        for (int i = length-1; i >=0; i--) {
            int value=map.get(s.charAt(i));
            if (value>=high){
                number+=value;
                high=value;
            }else{
                number-=value;
            }
        }
        return number;
    }

}
