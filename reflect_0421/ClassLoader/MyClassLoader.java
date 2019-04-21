package exercise.reflect_0421.ClassLoader;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class MyClassLoader extends ClassLoader {
    String classpath = "E:\\workspace2Eclipse\\untitled\\out\\production\\exercise\\";
    public Class loadClassData(String className){
        byte[] data = loadData(className);
        return super.defineClass(className,data,0,data.length);
    }
    private  byte[] loadData(String className){
        String classFile = classpath + className.replace(".","\\") +".class";
        try(ByteArrayOutputStream out = new ByteArrayOutputStream();
            FileInputStream in = new FileInputStream(classFile)
        ){
            byte[] buff = new byte[1024];
            int len = -1;
            while((len = in.read(buff))!=-1){
                out.write(buff,0,len);
            }
            out.flush();
            return out.toByteArray();
        }catch (IOException e){

        }
        throw new RuntimeException("Class file load data filed.");
    }
}
