package exercise.reflect_0421.sample;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class BeanUtils {
    public static void setXxx(Object object,String attributeName,Object attributeValue){
        Class classz = object.getClass();

        String methodName = "set"+attributeName.substring(0,1).toUpperCase() +
                (attributeName.length() >1 ?attributeName.substring(1) : "");
        try {
            Method setMethod = classz.getMethod(methodName,attributeName.getClass());
            setMethod.invoke(object,attributeValue);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
