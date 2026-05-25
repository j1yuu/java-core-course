import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void printInfo() {
        System.out.println("Person " + name + " is " + age + " years old");
    }

    private void intrustiveThought() {
        System.out.println("i wanna buy humburger and go to the shower");
    }
}

public class App {
    public static void main(String[] args) throws Exception {
        Class<?> personClass = Person.class;

        Constructor<?> personConstructor = personClass.getDeclaredConstructor(String.class, int.class);
        Constructor<?>[] personConstructors = personClass.getDeclaredConstructors();
        Field[] fields = personClass.getDeclaredFields();
        Method[] methods = personClass.getDeclaredMethods();

        System.out.println("\n--------CONSTRUCTORS--------");
        for (Constructor<?> constructor : personConstructors) {
            System.out.println(constructor.getName());
        }

        System.out.println("\n--------FIELDS--------");
        for (Field field : fields) {
            System.out.println(field.getName());
        }

        System.out.println("\n--------METHODS--------");
        for (Method method : methods) {
            System.out.println(method.getName());
        }
 
        try {
            personConstructor.setAccessible(true);
            Person person = (Person) personConstructor.newInstance("Jake", 20);

            System.out.println("\n------UPDATING PRIVATE FIELD------");
            Field privateField = personClass.getDeclaredField("name");

            privateField.setAccessible(true);
            System.out.println("Old person's name: " + privateField.get(person));
            privateField.set(person, "John");
            System.out.println("Updated person's name: " + privateField.get(person));

            System.out.println("\n------INVOKING PUBLIC METHOD------");
            Method publicMethod = personClass.getMethod("printInfo");
            publicMethod.invoke(person);

            System.out.println("\n------INVOKING PRIVATE METHOD------");
            Method privateMethod = personClass.getDeclaredMethod("intrustiveThought");
            privateMethod.setAccessible(true);
            privateMethod.invoke(person);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
