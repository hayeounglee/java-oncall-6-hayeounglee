package oncall.model;

import oncall.util.Parser;
import oncall.validator.MemberValidator;

import java.util.List;

public class Weekend implements Oncall {
    List<String> weekendOncall;
    private int index;

    public Weekend(String member) {
        weekendOncall = Parser.parseDelimiter(member, ",");
        validate();
        index = 0;
    }

    private void validate() {
        MemberValidator memberValidator = new MemberValidator();
        memberValidator.validate(weekendOncall);
    }

    public String getName() {
        int targetIndex = index++ % weekendOncall.size();
        return weekendOncall.get(targetIndex);
    }

    public String changeOrder(String name) {
        int findNameIndex = weekendOncall.indexOf(name);
        weekendOncall.set(findNameIndex, weekendOncall.get(findNameIndex + 1));
        weekendOncall.set(findNameIndex + 1, name);
        return weekendOncall.get(findNameIndex);
    }
}
