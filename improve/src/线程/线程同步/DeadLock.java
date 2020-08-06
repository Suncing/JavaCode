package 线程.线程同步;
class DeadLock implements Runnable{
    int flag;
    Object o1 = new Object(), o2 = new Object();

    public void run() {
        if(flag==1){
            synchronized (o1){
                System.out.println("锁住o1");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (o2){
                    System.out.println("我可以继续执行了！");
                }
            }
        }
        if(flag==0){
            synchronized (o2){
                System.out.println("锁住o2");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (o1){
                    System.out.println("我可以继续运行了！");
                }
            }
        }
    }

    public static void main(String[] args) {
        DeadLock d1 = new DeadLock();
        DeadLock d2 = new DeadLock();
        d1.flag=1;d2.flag=0;

        Thread t1 = new Thread(d1);
        Thread t2 = new Thread(d2);
        t1.start();t2.start();
    }
}

