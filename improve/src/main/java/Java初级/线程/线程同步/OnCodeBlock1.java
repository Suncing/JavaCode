package Java初级.线程.线程同步;

class SyncThread implements Runnable {
    private static int count;

    public SyncThread() {
        count = 0;
    }

    public int getCount() {
        return count;
    }

    public void run() {
        synchronized(this) {
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName() + ":" + (count++));
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}


public class OnCodeBlock1 {
    public static void main(String[] args) {
        /**1.
        当两个并发线程访问同一个对象中的synchronized代码块时。在同一时刻只能有一个线程得到执行，另一个线程受阻塞
        必须等待当前线程执行完这个代码块以后才能执行该代码块。
        Thread1和thread2是互斥的，因为在执行synchronized代码块时会锁定当前的对象
        只有执行完该代码块才能释放该对象锁，下一个线程才能执行并锁定该对象*/
        SyncThread syncThread = new SyncThread();
        Thread t1 = new Thread(syncThread, "Thread1");
        Thread t2 = new Thread(syncThread, "Thread2");
        t1.start();t2.start();

        /**2.
        这时创建了两个SyncThread的对象
        线程t3执行的是第一个对象中的synchronized代码(run)
        线程t3执行的是第二个对象中的synchronized代码(run)
        synchronized锁定的是对象，这时会有两把锁分别锁定，而这两把锁是互不干扰的，不形成互斥
        所以两个线程可以同时执行。*/
        Thread t3 = new Thread(new SyncThread(), "SyncThread1");
        Thread t4 = new Thread(new SyncThread(), "SyncThread2");
        t3.start();t4.start();
    }
}

