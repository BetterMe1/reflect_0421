package exercise.reflect_0421.ClassLoader;

import exercise.reflect_0421.Member;

public class TestMyClassLoader {
    public static void main(String[] args) {
        Class memberClass1 = Member.class;
        Class memberClass2 = new MyClassLoader().loadClassData("exercise.reflect_0421.Member");
        System.out.println("memberClass1:"+ memberClass1.getClassLoader());
        System.out.println("memberClass2:"+ memberClass2.getClassLoader());
        System.out.println("memberClass1 == memberClass2 ?  "+ (memberClass1 == memberClass2));
    }
}
