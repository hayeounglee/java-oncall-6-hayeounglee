package oncall.validator;

import oncall.constant.ErrorMessage;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FormValidator {
    public static final Pattern ORDER_PATTERN = Pattern.compile("(\\d+),(.)");

    public void validateForm(String input) {
        Matcher matcher = ORDER_PATTERN.matcher(input);
        if (!matcher.matches()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_FORM.getMessage());
        }
    }
}
