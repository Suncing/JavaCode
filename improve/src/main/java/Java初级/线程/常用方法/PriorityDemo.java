package Java初级.线程.常用方法;

class T1 implements Runnable{
    @Override
    public void run() {
        for(int i=0;i<100;i++){
            System.out.println("T1:"+i);
        }
    }
}

class T2 implements Runnable{
    @Override
    public void run() {
        for(int i=0;i<100;i++){
            System.out.println("T2:"+i);
        }
    }
}

public class PriorityDemo {
    public static void main(String[] args) {
        Thread t1 = new Thread(new T1());
        Thread t2 = new Thread(new T2());
        t1.setPriority(Thread.NORM_PRIORITY+3);//t1优先级高，所以获得cpu的时间片就会多
        t1.start();t2.start();
    }
}
