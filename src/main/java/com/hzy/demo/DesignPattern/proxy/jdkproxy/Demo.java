package com.hzy.demo.DesignPattern.proxy.jdkproxy;



import java.lang.reflect.*;

public class Demo {

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        // 保存生成的代理类的字节码文件
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");

        // jdk动态代理测试
/*        Subject subject = (Subject) new JDKDynamicProxy(new RealSubject()).getProxy();
        subject.doSomething();*/


        //1.0 获取代理类的类对象，主要设置相同的ClassLoader去加载目标类实现的接口Subject类
        Class<?> proxyClass = Proxy.getProxyClass(Subject.class.getClassLoader(), new Class[]{Subject.class});
        //2.0 得到代理类后，就可以通过代理类的处理器句柄来得到构造器

        final Constructor<?> con = proxyClass.getConstructor(InvocationHandler.class);
        // 3.0 反射创建代理实例

        Subject subject = (Subject) con.newInstance(new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                RealSubject realSubject = new RealSubject();
                System.out.println("Do something before");
                Object result = method.invoke(realSubject, args);
                System.out.println("Do something after");
                return result;
            }
        });
        subject.doSomething();


/*        //3.0 获取具体执行方法的句柄处理器，目的通过构造器传入被代理目标类对象，注入到代理类处理器句柄中进行代理调用
        final InvocationHandler handler = new JDKDynamicProxy(new RealSubject());
        //4.0 通过构造器创建代理类对象
        Subject subject = (Subject)con.newInstance(handler);
        //5.0 最后调用方法
        subject.doSomething();*/



    }
}
