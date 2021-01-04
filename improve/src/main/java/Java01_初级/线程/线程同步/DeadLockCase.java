package Java01_初级.线程.线程同步;

class YangDi implements Runnable{
    @Override
    public void run() {
        System.out.print("我是杨迪：");
        try {
            while(true){
                synchronized (DeadLockCase.obj1){
                    System.out.println("有趣的灵魂");
                    Thread.sleep(3000);
                    synchronized (DeadLockCase.obj2){
                        System.out.println("Perfect");
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

class DiLiReBa implements Runnable{
    @Override
    public void run() {
        System.out.print("我是迪丽热巴:");
        try {
            while(true){
                synchronized (DeadLockCase.obj2){
                    System.out.println("好看的皮囊");
                    Thread.sleep(3000);
                    synchronized (DeadLockCase.obj1){
                        System.out.println("Perfect");
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

public class DeadLockCase {
    public static String obj1 = "有趣的灵魂";
    public static String obj2 = "好看的皮囊";
    public static void main(String[] args) {
        Thread t1 = new Thread(new YangDi());
        Thread t2 = new Thread(new DiLiReBa());
        t1.start();
        t2.start();
    }
}
