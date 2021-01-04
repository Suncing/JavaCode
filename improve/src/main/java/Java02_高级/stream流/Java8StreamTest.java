package Java02_高级.stream流;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Java8StreamTest {

    /**
     * fiter：过滤集合中不符合条件的元素
     */
    @Test
    public void filter(){
        List<String> strings = Arrays.asList("abc","","bc","bc","efg","abcd","jkl","jkl");
        List<String> filtered = strings.stream().filter(str->str.contains("f")).collect(Collectors.toList());
        //.collect(Collectors.toList())将结果再封装成一个集合
        System.out.println(filtered);
    }

    /**
     * distinct：去重
     */
    @Test
    public void distinct(){
        List<String> strings = Arrays.asList("abc","","bc","bc","efg","abcd","jkl","jkl");
        List<String> distincted = strings.stream().distinct().collect(Collectors.toList());
        //.collect(Collectors.toList())将结果再封装成一个集合
        System.out.println(distincted);
    }

    /**
     * limit：分页
     */
    @Test
    public void limit(){
        List<String> strings = Arrays.asList("abc","","bc","bc","efg","abcd","jkl","jkl");
        List<String> limit = strings.stream().limit(2).collect(Collectors.toList());
        //.collect(Collectors.toList())将结果再封装成一个集合
        System.out.println(limit);
    }

    /**
     * skip：跳过
     */
    @Test
    public void skip(){
        List<String> strings = Arrays.asList("abc","","bc","bc","efg","abcd","jkl","jkl");
        List<String> skip = strings.stream().skip(2).collect(Collectors.toList());
        //.collect(Collectors.toList())将结果再封装成一个集合
        System.out.println(skip);
    }

    /**
     * map：对l流中所有元素做统一处理
     */
    @Test
    public void map(){
        List<String> strings = Arrays.asList("abc","","bc","bc","efg","abcd","jkl","jkl");
        List<String> map = strings.stream().skip(2).map(str->str+"_Jay").collect(Collectors.toList());
        //.collect(Collectors.toList())将结果再封装成一个集合
        System.out.println(map);
    }

   @Test
   public void foreach(){
       List<String> strings = Arrays.asList("abc","","bc","bc","efg","abcd","jkl","jkl");
       strings.parallelStream().forEach(str-> System.out.println(str));
   }

   @Test
    public void sorted(){
        List<String> strings = Arrays.asList("abc","","bc","bc","efg","abcd","jkl","jkl");
        List<String> collect = strings.stream().sorted().collect(Collectors.toList());
        System.out.println(collect);
    }

    //工具类，=：字符串转化成字符数组
    public static Stream<Character> getCharacterByString(String str){
        List<Character> characterList = new ArrayList<>();
        for(Character character:str.toCharArray()){
            characterList.add(character);
        }
        return characterList.stream();
    }
}
















