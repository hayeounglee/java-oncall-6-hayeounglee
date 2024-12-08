package oncall.validator;

import oncall.constant.ErrorMessage;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MembersValidator {
    public void validate(List<String> members) {
        validateMemberSize(members);
    }

    private void validateMemberSize(List<String> onCall) {
        if (onCall.size() < 5) {
            throw new IllegalArgumentException(ErrorMessage.MIN_SIZE_MEMBER.getMessage());
        }
        if (onCall.size() > 35) {
            throw new IllegalArgumentException(ErrorMessage.MAX_SIZE_MEMBER.getMessage());
        }
    }
}
