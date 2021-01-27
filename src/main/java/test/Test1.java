package test;

import utils.Cal;
import utils.Impl.CalImpl;
import utils.MyInvocationHandler;

public class Test1 {
    public static void main(String[] args) {
        //创建委托对象
        Cal cal=new CalImpl();
        /*cal.add(1,1);
        cal.sub(2,1);
        cal.mul(2,3);
        cal.div(6,2);*/
        MyInvocationHandler myInvocationHandler=new MyInvocationHandler();
        //将委托对象传入生成代理对象，代理对象具备委托对象所有的功能
        Cal cal1= (Cal) myInvocationHandler.bind(cal);
        //代理对象执行每个方法的时候进入invoke方法，cal1是第一个参数、add是第二个参数、1和1是第三个参数
        cal1.add(1,1);
        cal1.sub(2,1);
        cal1.mul(2,3);
        cal1.div(6,2);
    }
}
