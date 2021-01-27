package utils;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class MyInvocationHandler implements InvocationHandler {
    //MyInvocationHandler不是代理类，它可以创建代理类
    //接收委托对象
    private Object object=null;
    //返回代理对象
    public Object bind(Object object){
        this.object=object;
        //根据委托对象的所有接口，动态创建代理对象
        return Proxy.newProxyInstance(object.getClass().getClassLoader(),object.getClass().getInterfaces(),this);
    }

    /**
     *
     * @param proxy
     * @param method 方法
     * @param args   参数
     * @return
     * @throws Throwable
     */
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println(method.getName()+"方法的参数是"+ Arrays.toString(args));
        //委托对象执行真正的业务方法，反射机制可以理解为方法调对象
        Object result=method.invoke(this.object,args);
        System.out.println(method.getName()+"的结果是"+result);
        return result;
    }
}
