package ir.maktab.util.validation;

import ir.maktab.exception.NOVALIDATE;

@FunctionalInterface
public interface ValidateInterface {
    void accept(String input, String regex, String errorMsg) throws NOVALIDATE;
}
