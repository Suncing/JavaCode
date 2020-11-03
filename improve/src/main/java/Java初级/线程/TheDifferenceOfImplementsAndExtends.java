package Java初级.线程;
class ExtendsTest extends Thread{
    private int apples=50;
    private String name;

    public ExtendsTest(String name){
        this.name = name;
    }

    public void run()
    {
        while(apples>0)
        {
            System.out.println(name+"吃了第"+(apples--)+"个苹果");
        }
    }
}

class ImplementsTest implements Runnable{
    private int apples=50;

    public void run() {
        while (apples>0){
            System.out.println(Thread.currentThread().getName()+"吃了第"+(apples--)+"个苹果");
        }
    }
}

public class TheDifferenceOfImplementsAndExtends {
    public static void main(String[] args) {

        ExtendsTest et1 = new ExtendsTest("A");
        ExtendsTest et2 = new ExtendsTest("B");
        ExtendsTest et3 = new ExtendsTest("C");
        et1.start();et2.start();et3.start();

        ImplementsTest it = new ImplementsTest();
        new Thread(it,"A").start();
        new Thread(it,"B").start();
        new Thread(it,"C").start();
        //从上面的运行结果可以看出:
        // 继承Thread实现的模式是定义多个线程,各自完成各自的任务
        // 实现Runnable实现的模式是定义多个线程,实现一个任务
    }
}
