import java.io.File;

public class Test {
    Integer[] i = new Integer[1];
    String string = "qweqw.qeqw";
    String string2;

    @org.junit.Test
    public void test(){
        System.out.println(i.length);
        System.out.println(File.separator);
        System.out.println("${geology.file.root:D:\\zjzy\\meteorology}");
        System.out.println(string.lastIndexOf("."));
        System.out.println(string.substring(string.lastIndexOf(".")).toLowerCase());
    }
}
