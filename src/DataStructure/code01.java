package DataStructure;

public class code01 {
    public static void main(String[] args) {
        int num=6;
        print(num);

        System.out.println();
        int numMax=Integer.MAX_VALUE;
        System.out.println(numMax);
        print(numMax);
        System.out.println();
        print(-1);//反码
//        +1变成补码
        System.out.println();
        print(Integer.MIN_VALUE);//反码+1 变为补码时，会进位超过32位，进位被舍弃

//        相反数
        int x=5;
        System.out.println();
        print(x);
        System.out.println(~x+1);
//        int negX=-x;



    }
    public  static  void print(int args){
        for(int i=31; i>=0; i--){
            System.out.print((args&(1<<i))==0?"0":"1");
        }
    }
}
