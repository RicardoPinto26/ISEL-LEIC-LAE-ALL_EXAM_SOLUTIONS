package ex3;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class CopyTo {
    void copyTo(Object from, Object to) {
        var fClass = from.getClass();
        var anno = fClass.getAnnotation(Copy.class);

        var fMethods = Arrays.stream(fClass.getMethods()).filter(method -> {
            var name = method.getName();

            return (name.length() >= 4 && name.startsWith("get") &&
                    Arrays.stream(anno.properties()).anyMatch(p -> p.equals(name.substring(3))));
        });

        var tMethods = Arrays.stream(to.getClass().getMethods()).filter(method -> {
            var name = method.getName();

            return (name.length() >= 4 && name.startsWith("set") &&
                    Arrays.stream(anno.properties()).anyMatch(p -> p.equals(name.substring(3))));
        });

        fMethods.forEach(fmethod -> {
            Method tMethod = tMethods.filter(m ->
                    m.getName().substring(3).equals(fmethod.getName().substring(3))
            ).findFirst().get();

            try {
                tMethod.invoke(to, fmethod.invoke(from));
            } catch (IllegalAccessException | InvocationTargetException e) {
                throw new RuntimeException(e);
            }
        });
    }
}

