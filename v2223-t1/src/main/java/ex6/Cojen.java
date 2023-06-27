package ex6;

import org.cojen.maker.ClassMaker;
import org.cojen.maker.MethodMaker;
import org.cojen.maker.Variable;

import java.util.List;

public class Cojen {
    static Class<?> buildPeeker() {
        ClassMaker classMaker = ClassMaker
                .beginExternal("PeekerImpl")
                .implement(StringPeeker.class)
                .public_();
        classMaker
                .addConstructor()
                .public_();

        MethodMaker peekMaker = classMaker
                .addMethod(
                        String.class, "peek", List.class)
                .public_();
        Variable res = peekMaker
                .param(0)
                .invoke("get", 0);
        // O que faltava era o cast para String no retorno da função
        peekMaker.return_(res.cast(String.class));
        return classMaker.finish();
    }
}
