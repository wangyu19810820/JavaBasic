package com.proxy.simulate;

import com.proxy.Car1;
import com.proxy.Moveable;
import org.apache.commons.io.FileUtils;

import javax.tools.JavaCompiler;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * 动态生成代理类，代理对象
 */
public class SimulateProxy {

    protected static final String classPathPrefix = System.getProperty("user.dir") + "/target/classes/";
    protected static final String classSimpleName = "$Proxy";
    protected static final String classPackage = "com.proxy.simulate";
    protected static final String classFullName = classPackage + "." + classSimpleName;

    public static Object newProxyInstance(Class targetInterface) throws Exception {
        // 获取动态代理类的文件位置
        String classPath = getJavaClassPath(classPathPrefix, classFullName);
        System.out.println(classPath);
        // 获取动态代理类的文件内容
        String classContent = getJavaClassContent(targetInterface);

        // 动态创建java类
        createJavaClass(classPath, classContent);
        // 载入java类
        loadJavaClass(classPath);
        // 创建java对象
        return loadJavaObject(classFullName);
    }

    protected static String getJavaClassContent(Class targetInterface) {
        String rt = "\r\n";
        String str = "package " + classPackage + ";" + rt
                + "public class " + classSimpleName + " implements " + targetInterface.getName() + " {" + rt
                + "private " + targetInterface.getName() + " moveable;" + rt
                + "public $Proxy(" + targetInterface.getName() + " moveable) {this.moveable = moveable;}" + rt;
        for (Method method : targetInterface.getMethods()) {
            str = str + "public void " + method.getName() + "() {" + rt
                    + "long starttime = System.currentTimeMillis();" + rt
                    + "System.out.println(\"($Proxy)开始计时。。。\");" + rt
                    + "moveable.move();" + rt
                    + "long endtime = System.currentTimeMillis();" + rt
                    + "System.out.println(\"($Proxy)计时结束。。。所用时间：\" + (endtime - starttime) + \"毫秒\");" + rt
                    + "}" + rt;
        }

        str = str + "}";
        return str;
    }

    protected static String getJavaClassPath(String prefix, String classFullName) {
        String[] strArr = classFullName.split("\\.");
        String classPath = Arrays.stream(strArr).collect(Collectors.joining("/"));
        String filename = prefix + classPath + ".java";
        return filename;
    }

    protected static void createJavaClass(String filename, String content) throws IOException {
        File file = new File(filename);
        FileUtils.writeStringToFile(file, content);
    }

    protected static void loadJavaClass(String fileName) throws IOException {
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        StandardJavaFileManager fileManager = compiler.getStandardFileManager(null, null, null);
        Iterable units = fileManager.getJavaFileObjects(fileName);
        JavaCompiler.CompilationTask t = compiler.getTask(null, fileManager, null, null, null, units);
        t.call();
        fileManager.close();
    }

    protected static Object loadJavaObject(String classFullName)
            throws IllegalAccessException, InvocationTargetException,
            InstantiationException, ClassNotFoundException, NoSuchMethodException {
        ClassLoader cl = ClassLoader.getSystemClassLoader();
        Class c = cl.loadClass(classFullName);
        Constructor constructor = c.getConstructor(Moveable.class);
        return constructor.newInstance(new Car1());
    }
}
