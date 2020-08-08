package 容器.Collection.List;

import java.util.ArrayList;
import java.util.Iterator;

//数组的所有功能通过ArrayList容器都可以实现，只是实现的方式不同
public class ArrayListUse
{
    public static void main(String[] args)
    {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        arrayList.add(12);
        arrayList.add(10);
        arrayList.add(35);
        arrayList.add(100);

        Iterator<Integer> iterator = arrayList.iterator();//获取容器的迭代器
        while(iterator.hasNext())
        {
            Integer value = iterator.next();//获取当前游标右边的元素，同时游标右移-->
            System.out.println(value);
        }
        System.out.println("通过ArrayList容器获取一个数组arr：");
        Object[] arr = arrayList.toArray();
        for(int i=0;i<arr.length;i++)
        {
            System.out.println(arr[i]);
        }
        ArrayListMethod.use();
    }
}

class ArrayListMethod{
    static void use(){
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        arrayList.add(12);
        arrayList.add(10);
        arrayList.add(35);
        arrayList.add(100);
        System.out.println("原容器中的元素为:");
        System.out.println(arrayList);
        System.out.println("\n");

        /*******重置set（int index,Object element）*******/
        System.out.println("将下标为1位置的元素置为20,将下标为2位置的元素置为70");
        arrayList.set(1, 20);
        arrayList.set(2, 70);
        System.out.println("重置之后容器中的元素为:");
        System.out.println(arrayList);
        System.out.println("\n");

        /*******中间插队add（int index,Object element）*******/
        System.out.println("在下标为1的位置插入一个元素,-----插入元素：此时容器后面的元素整体向后移动");
        arrayList.add(1, 80);//在下标为1的位置插入一个元素,此时容量加1,-----位置后面的元素整体向后移动
        System.out.println("插入之后容器中的元素为:");
        System.out.println(arrayList);
        System.out.println("插入之后容器中的容量为:");
        System.out.println(arrayList.size());
        System.out.println("\n");


        /*******中间删除元素remove（int index）*******/
        System.out.println("将下标为3位置的元素70删除,-----删除元素:此时容器位置后面的元素整体向前移");
        arrayList.remove(3);
        System.out.println("删除之后容器中的元素为:");
        System.out.println(arrayList);
        System.out.println("删除之后容器中的容量为:");
        System.out.println(arrayList.size());


    }
}