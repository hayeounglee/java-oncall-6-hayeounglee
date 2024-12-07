package oncall.util;

import oncall.constant.ErrorMessage;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Parser {
    public static int parseToInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_FORM.getMessage());
        }
    }

    public static List<String> parseDelimiter(String input, String delimiter) {
        return Arrays.stream(input.split(delimiter))
                .collect(Collectors.toList());
    }
}
