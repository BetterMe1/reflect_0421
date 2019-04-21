package exercise.reflect_0421;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestClassPart2 {
    public static void code1() {
        Class classz = Person.class;
        //获取所有方法
       /*
       Method[] methods = classz.getMethods();
        for(Method method : methods){
            System.out.println(method.getName()+" "+ Arrays.toString(method.getParameterTypes()));
        }
        */

        //获取指定方法
        try {
           /* //Method method = classz.getMethod("printPersonInfo");//null
            Method method = classz.getMethod("greetInfo");//欢迎Jack
            Person person = new Person("Jack",22);
            Object returnValue = method.invoke(person);
            System.out.println(returnValue);*/
            Method method = classz.getMethod("setName", String.class);
            Person person = new Person("Jack",22);
            System.out.println("before:"+person);
            Object returnValue = method.invoke(person,"Tom");
            System.out.println("after:"+person);
            System.out.println(returnValue);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }


    }

    public static void main(String[] args) {
        //获取属性（字段）
        Student student = new Student();
        student.setName("Jack");
        student.setAge(22);
        student.setSkill("C++,PHP,Java");

        Class studentClass = student.getClass();
        /*
        //获取父类的公开的属性
        //获取所有
        Field[] fields = studentClass.getFields();
        for(Field field : fields){
            System.out.println(field.getName()+" "+field.getType());//age class java.lang.Integer
        }
        //获取指定
        try {
            Field nameField = studentClass.getField("age");
            System.out.println(nameField.getName()+" "+nameField.getType());//age class java.lang.Integer
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        */

        ///获取本类的属性(私有或者公开）
        //所有
        Field[] fields = studentClass.getDeclaredFields();
        for(Field field : fields){
            System.out.println(field.getName()+" "+field.getType());
            //skill class java.lang.String
            //mobilePhone class java.lang.String
            //gender class java.lang.Boolean
        }
        //指定
        try {
            Field field =  studentClass.getDeclaredField("skill");
            System.out.println(field.getName()+" "+field.getType());//skill class java.lang.String
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

        //获取student对象的skill属性
        System.out.println("skill=" + student.getSkill());
        try {
            Field skillField = studentClass.getDeclaredField("skill");
            //private修饰的不能直接访问,需要打破封装性
            skillField.setAccessible(true);//打破封装性
            Object skillValue =  skillField.get(student);
            System.out.println(skillValue);//C++,PHP,Java
            skillField.set(student,"JavaScript");
            System.out.println(student.getSkill());//JavaScript
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}

class Person{
    private  String name;
    public   Integer age;
    public Person(){

    }
    public Person(String name,Integer age){
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String greetInfo(){
        return "欢迎"+this.getName();
    }
    public void printPersonInfo(){
        System.out.println(this.toString());
    }
    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

class Student extends Person {
    private  String skill;
    private String mobilePhone;
    public Boolean gender;
    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    @Override
    public String toString() {
        return "Student{" +
                "skill='" + skill + '\'' +
                '}';
    }
}