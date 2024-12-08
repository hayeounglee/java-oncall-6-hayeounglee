package oncall.model;

import oncall.constant.ErrorMessage;
import oncall.util.Parser;
import oncall.validator.MembersValidator;

import java.util.ArrayList;
import java.util.List;

public class Members {
    private List<Member> members;
    private int index;

    public Members(String input) {
        List<String> inputMembers = Parser.parseDelimiter(input, ",");
        validate(inputMembers);
        makeMembers(inputMembers);
        index = 0;
    }

    private void validate(List<String> inputMembers) {
        MembersValidator membersValidator = new MembersValidator();
        membersValidator.validate(inputMembers);
    }

    private void makeMembers(List<String> inputMembers) {
        members = new ArrayList<>();
        for (String name : inputMembers) {
            members.add(new Member(name));
        }
    }

    public String getName() {
        int targetIndex = index++ % members.size();
        return members.get(targetIndex).name();
    }

    public String changeOrder(String name) {
        int findNameIndex = getIndex(name);
        members.set(findNameIndex, members.get(findNameIndex + 1));
        members.set(findNameIndex + 1, new Member(name));
        return members.get(findNameIndex).name();
    }

    private int getIndex(String name) {
        int index = 0;
        for (Member member : members) {
            if (member.name().equals(name)) {
                return index;
            }
            index++;
        }
        throw new IllegalArgumentException(ErrorMessage.INVALID_MEMBER_CHANGE_ATTEMPT.getMessage());
    }
}
