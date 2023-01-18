package ir.maktab.util.validation;

import ir.maktab.exception.NOVALIDATE;

@FunctionalInterface
public interface TriConsumer {
    void accept(String input, String regex, String errorMsg) throws NOVALIDATE;
}