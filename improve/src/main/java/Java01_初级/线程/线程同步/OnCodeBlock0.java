package Java01_初级.线程.线程同步;

/**锁前：
 *t2,你是第2个使用timer的线程
 *t1,你是第2个使用timer的线程
 */
class Timer{
    private static int num = 0;
    public void add(String name){
            num++;
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(name+",你是第"+num+"个使用timer的线程");
        }
    }

public class OnCodeBlock0 implements Runnable{
    Timer timer = new Timer();
    public void run() {
        timer.add(Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        OnCodeBlock0 sd = new OnCodeBlock0();
        Thread t1 = new Thread(sd,"t1");
        Thread t2 = new Thread(sd,"t2");
        t1.start();t2.start();
    }
}
