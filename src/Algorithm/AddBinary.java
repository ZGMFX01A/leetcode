package Algorithm;

public class AddBinary {

    static String addBinary(String a, String b) {
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        while (i >= 0 && j >= 0) {
            int sum = carry;
            sum += a.charAt(i--) - '0';
            sum += b.charAt(j--) - '0';
            carry = sum / 2;
            sb.append(sum % 2);
        }
        while (i >= 0) {
            int sum = carry + a.charAt(i--) - '0';
            carry = sum / 2;
            sb.append(sum % 2);
        }
        while (j >= 0) {
            int sum = carry + b.charAt(j--) - '0';
            carry = sum / 2;
            sb.append(sum % 2);
        }
        if (carry == 1) {
            sb.append(carry);
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        String a = "1011";
        int i = a.charAt(0) - '0';
        System.out.println(addBinary("a", "1011"));
        System.out.println(i);
    }
}
