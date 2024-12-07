package oncall.view;

import oncall.model.Calender;
import oncall.model.DayOncall;

import java.util.List;

public class OutputView {
    public void printDayShift(Calender calender, List<DayOncall> DayOnCalls) {
        for (DayOncall dayOncall : DayOnCalls) {
            if (dayOncall.isHoliday()) {
                System.out.printf("%s월 %s일 %s(휴일) %s%n", calender.getMonth(), dayOncall.day(), dayOncall.week(), dayOncall.name());
                continue;
            }
            System.out.printf("%s월 %s일 %s %s%n", calender.getMonth(), dayOncall.day(), dayOncall.week(), dayOncall.name());
        }
    }
}
