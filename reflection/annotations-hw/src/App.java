import java.lang.annotation.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
@interface Action {
    String desctiption() default "default description of an action";
}

class Service {

    public Service() {}

    public void printInfo() {
        System.out.println("Printing info of a service");
    }

    @Action
    public void defaultAction() {
        System.out.println("default action");
    }

    @Action(desctiption = "Description of an action in Service class")
    public void anotherAction() {
        System.out.println("another action");
    }

    public void actionWithoutAnnotation() {
        System.out.println("action without annotation");
    }
}

public class App {
    public static void main(String[] args) throws Exception {
        Class<?> serviceClass = Service.class;
        
        Constructor<?> serviceConstructor = serviceClass.getConstructor();
        Service service = (Service) serviceConstructor.newInstance();

        Method[] methods = serviceClass.getMethods();

        for (Method method : methods) {
            if (method.isAnnotationPresent(Action.class)) {
                System.out.println(method.getName());
                System.out.println(method.getAnnotation(Action.class).desctiption());
                method.invoke(service);
            }
        }
    }
}
