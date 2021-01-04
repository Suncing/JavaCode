package Java02_高级.代理;

public class Wang {
    public static void main(String[] args) {
        WGirl girl = new WangMeiLi();
        WangMeiLiProxy family = new WangMeiLiProxy(girl);
        WGirl mother = (WGirl)family.getProxyInstance();
        mother.date();
        mother.watchMoive();
    }
}
