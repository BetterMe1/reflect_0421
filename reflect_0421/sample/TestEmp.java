package exercise.reflect_0421.sample;

import static exercise.reflect_0421.sample.BeanUtils.setXxx;

public class TestEmp {
    public static void main(String[] args) {
        //需求：将一个字符串的内容赋值给Emp对象的属性
        //描述
        //比如"name:张三|job:SoftDeveloper"
        //name -> Emp对象的name值九四张三
        //job -> Emp对象的job值九四SoftDeveloper
        //实现：
        String value = "name:张三|job:SoftDeveloper";
        String[] attributeNameAndValues = value.split("\\|");
        Emp emp = new Emp();
        for(String attributeNameAndValue : attributeNameAndValues){
           String[] nv = attributeNameAndValue.split(":");
           setXxx(emp,nv[0],nv[1]);
        }
        System.out.println(emp);
    }

}
