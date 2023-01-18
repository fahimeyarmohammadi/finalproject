package ir.maktab.validation;

@FunctionalInterface
public interface TriConsumer {
    void accept(String input, String regex, String errorMsg);
}
