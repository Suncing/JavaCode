package Java初级.字符和字符串;

import org.junit.Test;

public class 判断字符 {

    @Test
    public void test1(){
        System.out.println(Character.isLetter('a'));
    }

    @Test
    public void test2(){
        System.out.println(Character.isDigit(1));
    }

    @Test
    public void test3(){
        String str = "Naru.to";
        int idx = str.indexOf(".");//indexOf返回字符所在位置，没有该字符返回-1
        System.out.println(str.substring(idx).toLowerCase());
    }
    /**
     * 1、isLetter()方法用于判断指定字符是否为字母
     * boolean isLetter(char ch)
     *
     * System.out.println(Character.isLetter('c'));
     *
     * 2.isDigit()方法用于判断指定字符是否为数字
     * boolean isDigit(char ch)
     *
     * System.out.println(Character.isDigit('5'));
     *
     * 3.isWhitespace()方法用于判断指定字符是否为空白字符，空白字符包括：空格、tab键、换行符。
     * boolean isWhitespace(char ch)
     *
     * System.out.println(Character.isWhitespace(' '))
     * System.out.println(Character.isWhitespace('\n'))
     * System.out.println(Character.isWhitespace('　　'))
     *
     * 4.isUpperCase()方法用于判断指定字符是否为大写字母。
     *   isLowerCase()方法用于判断指定字符是否为小写字母。
     * 　boolean isUpperCase(char ch)
     * 　boolean isLowerCase(char ch)
     *
     * System.out.println(Character.isUpperCase('C'));
     * System.out.println(Character.isLowerCase('c'));
     *
     * 5.toUpperCase()方法用于将小写字符转换为大写
     *   toLowerCase()方法用于将大写字符转换为小写
     * char toUpperCase(char ch)
     * char toLowerCase(char ch)
     *
     * System.out.println(Character.toUpperCase('a'));//A
     * System.out.println(Character.toLowerCase('A'));//a
     *
     * 6.toString()方法用于返回一个表示指定char值的String对象。
     * String toString(char ch);
     * System.out.println(Character.toString('a'));//a
     */
}
