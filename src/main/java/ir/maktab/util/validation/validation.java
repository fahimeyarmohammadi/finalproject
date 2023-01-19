package ir.maktab.util.validation;

import ir.maktab.exception.NOVALIDATE;

public class validation {
    public static TriConsumer validate = (s, r, m) -> {
        if (s.equals("") || !s.matches(r))
            throw new NOVALIDATE(m);
    };

    public static void validateName(String name) throws NOVALIDATE {
        validate.accept(name, "^[a-zA-Z ]{2,}", "Invalid Name(Only Alphabetic Characters Accepted)");
    }

    public static void validatePassword(String pass) throws NOVALIDATE {
        validate.accept(pass, "^(?=.*[0-9])(?=.*[A-z])).{8}$",
                "Invalid Password( 8 characters,composition of character and digit)");
    }

    public static void validateEmail(String email) throws NOVALIDATE {
        validate.accept(email,  "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
                + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$",
                "Invalid Email");
    }

}
