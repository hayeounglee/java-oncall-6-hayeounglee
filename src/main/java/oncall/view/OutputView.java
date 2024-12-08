package oncall.view;

import oncall.dto.DayOneCallDTO;
import oncall.model.DayOncall;
import oncall.model.DayOneCalls;


public class OutputView {
    public void printDayShift(DayOneCalls DayOnCalls) {
        for (DayOneCallDTO dayOneCallDTO : DayOnCalls.getMonthOneCall()) {
            if (dayOneCallDTO.getHoliday()) {
                System.out.printf("%s월 %s일 %s(휴일) %s%n", dayOneCallDTO.getMonth(), dayOneCallDTO.getDay(), dayOneCallDTO.getWeek(), dayOneCallDTO.getName());
                continue;
            }
            System.out.printf("%s월 %s일 %s %s%n", dayOneCallDTO.getMonth(), dayOneCallDTO.getDay(), dayOneCallDTO.getWeek(), dayOneCallDTO.getName());
        }
    }
}
