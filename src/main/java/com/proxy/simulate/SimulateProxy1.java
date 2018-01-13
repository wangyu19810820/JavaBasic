package com.proxy.simulate;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 动态生成代理类，代理对象
 */
public class SimulateProxy1 extends SimulateProxy {
    protected static final String classPathPrefix = System.getProperty("user.dir") + "/target/classes/";
    protected static final String classSimpleName = "$Proxy1";
    protected static final String classPackage = "com.proxy.simulate";
    protected static final String classFullName = SimulateProxy1.classPackage + "." + SimulateProxy1.classSimpleName;

    public static Object newProxyInstance(Class targetInterface, InvocationHandler handler)
            throws Exception {
        // 获取动态代理类的文件位置
        String classPath = SimulateProxy.getJavaClassPath(SimulateProxy1.classPathPrefix, SimulateProxy1.classFullName);
        System.out.println(classPath);
        // 获取动态代理类的文件内容
        String classContent = SimulateProxy1.getJavaClassContent(targetInterface);

        // 动态创建java类
        SimulateProxy1.createJavaClass(classPath, classContent);
        // 载入java类
        SimulateProxy1.loadJavaClass(classPath);
        // 创建java对象
        return SimulateProxy1.loadJavaObject(handler);
    }

    protected static String getJavaClassContent(Class targetInterface) {
        String rt = "\r\n";
        String str = "package com.proxy.simulate;" + rt
                + "import java.lang.reflect.Method;" + rt
                + "public class " + SimulateProxy1.classSimpleName + " implements " + targetInterface.getName() + " {" + rt
                + "private " + targetInterface.getName() + " moveable;" + rt
                + "private " + InvocationHandler.class.getName() + " handler;" + rt
                + "public " + SimulateProxy1.classSimpleName + "(" + InvocationHandler.class.getName() + " handler)" + rt
                + "{this.moveable = moveable;" + rt
                + "this.handler = handler;}" + rt;
        for (Method method : targetInterface.getMethods()) {
            str = str + "public void " + method.getName() + "() {" + rt
                    + "try {"
                    + "Method m = " + targetInterface.getName() + ".class.getMethod(\"" + method.getName() + "\");" + rt
                    + "handler.invoke(this, m, null);" + rt
                    + "}catch(Throwable e){}"
                    + "}" + rt;
        }
        str = str + "}";
        return str;
    }

    protected static Object loadJavaObject(InvocationHandler handler)
            throws IllegalAccessException, InvocationTargetException,
            InstantiationException, ClassNotFoundException, NoSuchMethodException {
        ClassLoader cl = ClassLoader.getSystemClassLoader();
        Class c = cl.loadClass(classFullName);
        Constructor constructor = c.getConstructor(InvocationHandler.class);
        return constructor.newInstance(handler);
    }
}
