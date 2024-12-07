package oncall.model;

import oncall.util.Parser;

import java.util.List;

public class Weekend implements Oncall {
    List<String> weekendOncall;
    private int index;

    public Weekend(String member) {
        weekendOncall = Parser.parseDelimiter(member, ",");
        index = 0;
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
