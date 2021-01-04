package Java03_面试;

import org.junit.Test;

import java.util.concurrent.TimeUnit;

/**
 * 加上volatile关键字后，主内存种的值被一个线程改了之后，另一个线程会得知此消息
 */
class MyData{
    int number = 0;
    public void addTo60(){
        this.number=60;
    }
}

class MyData2{
    volatile int number = 0;
    public void addTo60(){
        this.number=60;
    }
}

public class VolatileDemo {
    @Test
    public void testNoVolatile(){
        MyData myData = new MyData();
        new Thread(() ->{
            System.out.println(Thread.currentThread().getName()+" come in");
            try {
                TimeUnit.SECONDS.sleep(3);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            myData.addTo60();
            System.out.println(Thread.currentThread().getName()+" update number value"+myData.number);
        },"AAA").start();//AAA线程

        while(myData.number==0){

        }
        System.out.println(Thread.currentThread().getName()+" mission is over");
    }

    @Test
    public void testVolatile(){
        MyData2 myData = new MyData2();
        new Thread(() ->{
            System.out.println(Thread.currentThread().getName()+" come in");
            try {
                TimeUnit.SECONDS.sleep(3);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            myData.addTo60();
            System.out.println(Thread.currentThread().getName()+" update number value"+myData.number);
        },"AAA").start();//AAA线程

        while(myData.number==0){

        }
        System.out.println(Thread.currentThread().getName()+" mission is over "+ myData.number);
    }
}
