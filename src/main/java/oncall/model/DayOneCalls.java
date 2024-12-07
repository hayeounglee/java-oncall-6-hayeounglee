package oncall.model;

import oncall.constant.Holidays;

import java.util.ArrayList;
import java.util.List;

public class DayOneCalls {
    private final List<DayOncall> monthOneCall;

    public DayOneCalls() {
        monthOneCall = new ArrayList<>();
    }

    public void calculate(Day day, Oncall oncall) {
        monthOneCall.add(new DayOncall(day.month(), day.day(), day.week(), Holidays.isHoliday(day), getOncall(monthOneCall, oncall)));
    }

    private String getOncall(List<DayOncall> monthOneCal, Oncall oncall) {
        String name = oncall.getName();

        if (monthOneCal.size() == 0) {
            return name;
        }

        if (monthOneCal.get(monthOneCal.size() - 1).name().equals(name)) {
            return oncall.changeOrder(name);
        }
        return name;
    }

    public List<DayOncall> getMonthOneCall() {
        return monthOneCall;
    }
}
