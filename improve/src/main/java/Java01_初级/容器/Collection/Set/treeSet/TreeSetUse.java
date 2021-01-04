package Java01_初级.容器.Collection.Set.treeSet;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * Set 无序的,不可以重复元素
 *  |--HashSet: 底层数据结构是哈希表, 线程不同步
 *          hashSet是如何保证元素唯一性呢?
 *           是通过元素的两个方法, hashCode 和  equals 来完成的
 *           如果元素的hashCode值相同,才会判断equals 是否为true
 *           如果元素的hashCode值不同,不会调用 equals.
 *
 *           注意: 对于判断元素是否存在,以及删除等操作,依赖的方法是元素的hashCode和equals方法.
 *
 *  |--TreeSet: 可以对Set集合中的元素进行排序
 *              底层数据结构式是二叉树
 *              保证元素唯一性的依据
 *              compareTo 方法 return 0  TreeSet 中就只会有一个 元素
 *
 *              TreeSet排序的第一种方式,让元素自身具备比较性,
 *              元素需要实现Comparable接口,覆盖compareTo 方法
 *              这种方式 也成为元素的自然顺序,或者叫默认顺序.
 *
 *              TreeSet的第二种排序方式.
 *              当元素自身不具备比较性时,或者具备的比较性不是所需要的 .
 *              这是就需要让集合自身具备比较性.
 *              在集合初始化时,就有了比较方式.
 *
 *
 *  需求:
 *  往TreeSet集合中存储自定义对象学生
 *  想按照学生的年龄进行排序.
 *
 *  记住:排序时,当主要条件相同时,一定要判断一下次要条件.
 *
 */

public class TreeSetUse {
    public static void main(String[] args) {
        //1.常用方法
        TreeSetMethod.use();

        //2.自然排序
        TreeSet<Student2> tree = new TreeSet<>();
        //向集合中添加元素
        tree.add(new Student2("孙悟空",16));
        tree.add(new Student2("孙悟空",17));
        tree.add(new Student2("孙悟空",16));
        tree.add(new Student2("唐僧",16));
        tree.add(new Student2("沙悟净",23));
        tree.add(new Student2("唐僧",30));
        //遍历
        System.out.println(tree);
       /*[Student{name='唐僧', age=16},
       Student{name='孙悟空', age=16},
       Student{name='孙悟空', age=17},
       Student{name='沙悟净', age=23},
       Student{name='唐僧', age=30}]
        */

        //3.定制排序
        /**
         * TreeSet的自然排序是根据集合元素的大小，TreeSet将它们以升序排列。
         * 如果需要实现定制排序，例如降序排序，则可通过Comparator接口的帮助。
         * 该接口里包含一个int compare(T o1,T o2)方法，用于比较o1和o2的大小。
         * 由于Comparator是一个函数式接口，因此还可以使用Lambda表达式来代替Comparator子类对象。
         */
        TreeSet<Integer> nums = new TreeSet<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return -(o1-o2);
            }
        });
        //向集合中添加元素
        nums.add(5);
        nums.add(2);
        nums.add(15);
        nums.add(-4);
        //输出集合，可以看到元素已经处于排序状态
        System.out.println(nums);//[15, 5, 2, -4]

    }
}

class Student2 implements Comparable<Student2> {
    /**
     * TreeSet会调用集合元素的compareTo(Objec obj)方法来比较元素之间的大小关系，
     * 然后将集合元素按升序排列，这就是自然排序。
     *
     * Java提供了一个Comparable接口，该接口里定义了一个compareTo(Object obj)方法，
     * 该方法返回一个整数值，实现该接口的类必须实现该方法，实现了该接口的类必须实现该方法，实现接口的类就可以比较大小了。当调用一个一个对象调用该方法与另一个对象进行比较时，obj1.compareTo(obj2)如果返回0表示两个对象相等；如果返回正整数则表明obj1大于obj2,如果是负整数则相反。
     *
     * 案例：
     * 实现存储学生类的集合，排序方式，按年龄大小，如果年龄相等，则按name字符串长度，如果长度相等则比较字符。
     * 如果name和age都相等则视为同一对象。
     */
    private String name;
    private int age;

    public Student2(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student2{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public int compareTo(Student2 student2) {
        int num=this.age-student2.age;
        //如果age相等则比较name长度
        int num1=num==0?this.name.length()-student2.name.length():num;
        //如果前两者都相等则比较name字符串
        int num2=num1==0?this.name.compareTo(student2.name):num1;
        return num2;
    }
}

class TreeSetMethod{
    static void use(){
        TreeSet<Integer> nums = new TreeSet<>();
        //向集合中添加元素
        nums.add(5);
        nums.add(2);
        nums.add(15);
        nums.add(-4);
        //输出集合，可以看到元素已经处于排序状态
        System.out.println(nums);//[-4, 2, 5, 15]

        System.out.println("集合中的第一个元素：" + nums.first());//集合中的第一个元素：-4
        System.out.println("集合中的最后一个元素：" + nums.last());//集合中的最后一个元素：15
        System.out.println("集合小于4的子集，不包含4：" + nums.headSet(4));//集合小于4的子集，不包含4：[-4, 2]
        System.out.println("集合大于5的子集：" + nums.tailSet(2));//集合大于5的子集：[2, 5, 15]
        System.out.println("集合中大于等于-3，小于4的子集：" + nums.subSet(-3, 4));//集合中大于等于-3，小于4的子集：[2]

    }
}