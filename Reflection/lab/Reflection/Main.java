package Reflection.lab.Reflection;

import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException,
            InstantiationException, IllegalAccessException {

        Class reflection = Reflection.class;
        System.out.println(reflection);

        Class superclass = reflection.getSuperclass();
        System.out.println(superclass);

        Class[] interfaces = reflection.getInterfaces();
        for (Class i : interfaces) {
            System.out.println(i);
        }

        Object reflectionObject = reflection.getDeclaredConstructor().newInstance();
        System.out.println(reflectionObject);

    }
}
