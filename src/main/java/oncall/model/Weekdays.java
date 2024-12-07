package oncall.model;

import oncall.util.Parser;

import java.util.List;

public class Weekdays implements Oncall {
    private final List<String> weekdaysOncall;
    private int index;

    public Weekdays(String member) {
        weekdaysOncall = Parser.parseDelimiter(member, ",");
        index = 0;
    }

    public String getName() {
        int targetIndex = index++ % weekdaysOncall.size();
        return weekdaysOncall.get(targetIndex);
    }

    public String changeOrder(String name) {
        int findNameIndex = weekdaysOncall.indexOf(name);
        weekdaysOncall.set(findNameIndex, weekdaysOncall.get(findNameIndex + 1));
        weekdaysOncall.set(findNameIndex + 1, name);
        return weekdaysOncall.get(findNameIndex);
    }
}
