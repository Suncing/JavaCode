package Java初级.线程.常用方法;

import java.util.Date;

//此方法暴力打断，不推荐。stop()更过分
class InterruptTest2 extends Thread{
    boolean flag = true;
    @Override
    public void run() {
        while (flag){
            System.out.println("==="+new Date()+"===");
            try {
                sleep(500);
            } catch (InterruptedException e) {
                return;
            }
        }

    }
}

public class InterruptDemo2 {
    public static void main(String[] args) throws InterruptedException {
        InterruptTest it = new InterruptTest();
        it.start();
        Thread.sleep(5000);//主线程睡觉
        System.out.println("醒来了");
        it.interrupt();
    }
}
