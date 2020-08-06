package 线程.线程同步;

class A implements Runnable{
    @Override
    public void run() {
        System.out.println("AAA");
        try {
            while(true){
                synchronized (Test.obj1){
                    Thread.sleep(3000);
                    synchronized (Test.obj2){
                        System.out.println("Perfect");
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

class B implements Runnable{
    @Override
    public void run() {
        System.out.println("BBB");
        try {
            while(true){
                synchronized (Test.obj2){
                    Thread.sleep(3000);
                    synchronized (Test.obj1){
                        System.out.println("Perfect");
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

public class Test {
    public static String obj1 = "1";
    public static String obj2 = "2";
    public static void main(String[] args) {
        Thread t1 = new Thread(new A());
        Thread t2 = new Thread(new B());
        t1.start();
        t2.start();
    }
}
