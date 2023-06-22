package ex2;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Map;

/**
 * MEGA LOUCO ESCREVER ISTO
 */
public class VarUtils {
    public static <T> Map<String, Method> getPublicVarGettersOf(T obj) {
        Method[] methods = obj.getClass().getMethods();
        return Map.ofEntries(
                Arrays.stream(methods).filter(method -> {
                    String methodName = method.getName();
                    DontRead anno = method.getAnnotation(DontRead.class);
                    return methodName.length() >= 4 &&
                            methodName.startsWith("get") &&
                            anno == null &&
                            Arrays.stream(methods).anyMatch(method1 -> {
                                String method1Name = method1.getName();
                                if (method1Name.length() < 4) return false;
                                return method1Name.startsWith("set") && method1Name.substring(3).equals(methodName.substring(3));
                            });
                }).map(method -> Map.entry(method.getName().substring(3), method)).toArray(Map.Entry[]::new));
    }

    public static void showVars(Object obj) {
        System.out.println(obj.getClass().getSimpleName() + " {");

        getPublicVarGettersOf(obj).forEach((key, value) -> {
            try {
                System.out.println("    var " + key + " : " + value.getReturnType().getSimpleName() + " = " + value.invoke(obj));
            } catch (IllegalAccessException | InvocationTargetException e) {
                throw new RuntimeException(e);
            }
        });

        System.out.println("}");
    }
}


