package Algorithm;

public class IntegerInversion {
    public int reverse(int x) {
        int res = 0;
        while (x != 0) {
            int tmp = res * 10 + x % 10;
            if (tmp / 10 != res) { // 溢出!!!
                return 0;
            }
            res = tmp;
            x /= 10;
        }
        return res;
    }
}
