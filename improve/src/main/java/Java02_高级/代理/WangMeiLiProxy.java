package Java02_高级.代理;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class WangMeiLiProxy implements InvocationHandler {
    private WGirl girl;//一定要把真实对象包含在代理里

    public WangMeiLiProxy(WGirl girl){
        super();
        this.girl=girl;
    }


    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        Object ret = method.invoke(girl,args);
        end();
        return ret;
    }

    private void before(){
        System.out.println("调查背景");
    }
    private void end(){
        System.out.println("人怎么样");
    }

    public Object getProxyInstance(){
        return Proxy.newProxyInstance(girl.getClass().getClassLoader(),girl.getClass().getInterfaces(),this);
    }
}
