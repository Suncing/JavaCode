package String;

public class b_StringBuffer {
    public static void main(String[] args) {
        String s = "Mircosoft";
        char[] a = {'a','b','c'};

        //1.添加
        StringBuffer sb1 = new StringBuffer(s);
        sb1.append('/').append("IBM").append("/").append("Sun");
        System.out.println(sb1);

        StringBuffer sb2 = new StringBuffer("数字:");
        for(int i=0;i<=9;i++){
            sb2.append(i);
        }
        System.out.println(sb2);

        //2.删除
        sb2.delete(8,sb2.length()).insert(0,a);
        System.out.println(sb2);

        //3.反转
        System.out.println(sb2.reverse());
    }
}
