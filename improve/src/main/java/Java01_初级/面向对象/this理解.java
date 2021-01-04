package Java01_初级.面向对象;

class this理解{
    /**
     * this指针指向的是本对象，this(a,b) 相当于 对象(a,b)，所以就会进入下一个构造函数内
     * @param a
     */
    public this理解(String a){
        this(a,"BBB");
        System.out.println(a);
    }

    public this理解(String a,String b){
        this(a,b,"ccc");
        System.out.println(a+" "+b);
    }

    public this理解(String a,String b,String c){
        System.out.println(a+" "+b+" "+c);
    }

    public static void main(String[] args) {
        this理解 i = new this理解("AAA");
    }
}
