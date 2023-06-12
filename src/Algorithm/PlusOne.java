package Algorithm;

class PlusOne {
    static int[] plusOne(int[] digits) {

        for (int i = digits.length-1; i >= 0 ; i--) {
            ++digits[i];
            digits[i]=digits[i]%10;
            if(digits[i]!=0){
                return digits;
            }
        }
        digits=new int[digits.length+1];
        digits[0]=1;
        return digits;

    }

    public static void main(String[] args) {
        int[] result ={9,9};
        int[] ints = plusOne(result);
        for(int i = 0; i < ints.length; i++){
            System.out.println(ints[i]);
        }
    }
}
