package Java初级.线程.常用方法;

class JoinTest extends Thread{
    JoinTest(String s){
        super(s);
    }
    public void run() {
        for(int i =1;i<=10;i++){
            System.out.println("i am "+getName());
        }
    }
}

public class JoinDemo {
    public static void main(String[] args) throws InterruptedException {
        JoinTest jt = new JoinTest("abcde");
        jt.start();
        jt.join();//让jt加入主线程，等jt执行完了
        for(int i =1;i<=10;i++){
            System.out.println("i am main thread");
        }
    }
}
