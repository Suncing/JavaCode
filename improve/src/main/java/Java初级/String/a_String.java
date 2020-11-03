package Java初级.String;

public class a_String {
    public static void s1(){
        String s1 = "hello";
        String s2 = "word";
        String s3 = "hello";
        System.out.println(s1==s3);//true
    }
    public static void s2(){
        String s1,s2;
        s1 = new String("hello");
        s2 = new String("hello");
        System.out.println(s1==s2);//false
        System.out.println(s1.equals(s2));//true
    }
    public static void s3(){
        char c[] = {'s','u','n',' ','j','a','v','a'};
        String s4 = new String(c);
        String s5 = new String(c,4,4);
        System.out.println(s4);//sun java
        System.out.println(s5);//java
    }
    public static void s4(){
        String s6 ="sun java",s7="Sun java";
        System.out.println(s6.charAt(1));//u
        System.out.println(s7.length());//8
        System.out.println(s6.indexOf("java"));//4
        System.out.println(s6.indexOf("Java"));//-1
        System.out.println(s6.equals(s7));//false
        System.out.println(s6.equalsIgnoreCase(s7));//true

        String s8 = "I'm a programmer and I'm learning Java";//You'm a programmer and You'm learning Java
        String s9 = s8.replace("I","You");
        System.out.println(s9);
    }
    public static void s5(){
        String s10 = "Welcome to Java World!";
        String s11 = "   sun java   ";
        System.out.println(s10.startsWith("Welcome"));//true
        System.out.println(s10.endsWith("Word"));//false
        System.out.println(s10.toLowerCase());//welcome to java world
        System.out.println(s10.toUpperCase());//WELCOME TO JAVA WORLD
        System.out.println(s10.substring(11));//Java World
        System.out.println(s11.trim());//sun java
    }
    public static void s6(){
        int j = 1234567;
        String sNumber = String.valueOf(j);
        System.out.println("j是"+sNumber.length()+"位数");

        String s12 = "Mary,F,1976";
        String[] sPlits = s12.split(",");//按照，开始分割
        for(String sPlit:sPlits){
            System.out.println(sPlit);
        }
    }
    public static void main(String[] args) {
        s1();
        System.out.println("---------------------------");
        s2();
        System.out.println("---------------------------");
        s3();
        System.out.println("---------------------------");
        s4();
        System.out.println("---------------------------");
        s5();
        System.out.println("---------------------------");
        s6();
    }
}
