package Java01_初级;

public class 递归算法和非递归比较 {
    long recursionTime=0;
    long noRecursionTime=0;

    @org.junit.Test
    public void test(){
        int i=10000;
        long startTime = System.nanoTime();;
        System.out.println("递归算法开始时间："+startTime);
        recursion(i);
        long endTime = System.nanoTime();;
        System.out.println("递归算法结束时间："+endTime);
        recursionTime=endTime-startTime;
        System.out.println("递归算法执行时间："+(endTime-startTime)+"纳秒");
        System.out.println("-------------------------------------------------------");
        long startTime2 = System.nanoTime();;
        System.out.println("非递归算法开始时间："+startTime);
        int j = 10000;
        while(j>0){
            j--;
        }
        long endTime2 = System.nanoTime();;
        System.out.println("非递归算法结束时间："+endTime2);
        noRecursionTime=endTime2-startTime2;
        System.out.println("非递归算法执行时间："+(endTime2-startTime2)+"纳秒");
        System.out.println("-------------------------------------------------------");
        if(noRecursionTime > recursionTime){
            System.out.println("递归时间短");
        }else{
            System.out.println("非递归时间短");
        }
    }

    public void recursion(int i){
        i--;
        if(i>0){
            recursion(i);
        }
    }

}
