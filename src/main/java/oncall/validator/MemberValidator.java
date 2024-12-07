package oncall.validator;

import oncall.constant.ErrorMessage;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MemberValidator {
    public void validate(List<String> onCall) {
        validateMemberSize(onCall);
        validateName(onCall);
    }

    private void validateMemberSize(List<String> onCall) {
        if (onCall.size() < 5) {
            throw new IllegalArgumentException(ErrorMessage.MIN_SIZE_MEMBER.getMessage());
        }
        if (onCall.size() > 35) {
            throw new IllegalArgumentException(ErrorMessage.MAX_SIZE_MEMBER.getMessage());
        }
    }

    private void validateName(List<String> onCall) {
        Set<String> uniqueOrders = new HashSet<>();
        for (String name : onCall) {
            validateNameSize(name);
            validateDuplicateName(name, uniqueOrders);
        }
    }

    private void validateNameSize(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_SIZE_NAME.getMessage());
        }
    }

    private void validateDuplicateName(String name, Set<String> uniqueOrders) {
        if (!uniqueOrders.add(name)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_DUPLICATE_NAME.getMessage());
        }
    }
}
