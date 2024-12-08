package oncall.model;

import oncall.constant.Holidays;

import java.util.ArrayList;
import java.util.List;

public class DayOneCalls {
    private final List<DayOncall> monthOneCall;

    public DayOneCalls() {
        monthOneCall = new ArrayList<>();
    }

    public void calculate(Day day, Members members) {
        monthOneCall.add(new DayOncall(day.month(), day.day(), day.week(), Holidays.isHoliday(day), getOncall(members)));
    }

    private String getOncall(Members members) {
        String name = members.getName();

        if (monthOneCall.size() == 0) {
            return name;
        }

        if (monthOneCall.get(monthOneCall.size() - 1).name().equals(name)) {
            return members.changeOrder(name);
        }
        return name;
    }

    public List<DayOncall> getMonthOneCall() {
        return monthOneCall;
    }
}
