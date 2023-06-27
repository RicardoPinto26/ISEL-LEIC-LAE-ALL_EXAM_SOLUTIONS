package ex6;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

import static ex6.Cojen.buildPeeker;

public class Main {
    public static void main(String[] args) throws InvocationTargetException, InstantiationException, IllegalAccessException {
        final var lst =
                Arrays.asList("ISEL", "LEIC", "LAE");

        final var peekerClazz = buildPeeker();

        final var peeker = (StringPeeker) peekerClazz.getConstructors()[0].newInstance();

        String first = peeker.peek(lst);

        System.out.println(first); // ISEL
    }
}
