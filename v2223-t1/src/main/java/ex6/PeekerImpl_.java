package ex6;

import java.util.List;

public class PeekerImpl_ implements StringPeeker {
    public PeekerImpl_() {
    }

    @Override
    public String peek(List a) {
        return (String) a.get(0);
    }
}
