package oncall.view;

import oncall.model.DayOncall;
import oncall.model.DayOneCalls;


public class OutputView {
    public void printDayShift(DayOneCalls DayOnCalls) {
        for (DayOncall dayOncall : DayOnCalls.getMonthOneCall()) {
            if (dayOncall.isHoliday()) {
                System.out.printf("%s월 %s일 %s(휴일) %s%n", dayOncall.month(), dayOncall.day(), dayOncall.week(), dayOncall.name());
                continue;
            }
            System.out.printf("%s월 %s일 %s %s%n", dayOncall.month(), dayOncall.day(), dayOncall.week(), dayOncall.name());
        }
    }
}
