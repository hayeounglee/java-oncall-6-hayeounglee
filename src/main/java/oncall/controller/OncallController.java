package oncall.controller;

import oncall.constant.Holidays;
import oncall.constant.Weeks;
import oncall.model.*;
import oncall.util.Task;
import oncall.view.InputView;
import oncall.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class OncallController {
    private final InputView inputView;
    private final OutputView outputView;

    public OncallController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        Calender calender = askMonthAndWeek();
        List<Members> oncalls = askOnCall();

        DayOneCalls dayOneCalls = makeOneCalls(calender, oncalls);
        outputView.printDayShift(dayOneCalls);
    }

    private DayOneCalls makeOneCalls(Calender calender, List<Members> oncalls) {
        DayOneCalls dayOneCalls = new DayOneCalls();
        Members weekdays = oncalls.get(0);
        Members weekend = oncalls.get(1);

        for (Day day : calender.getCalender()) {
            if (Weeks.isWeekend(day) || Holidays.isHoliday(day)) {
                dayOneCalls.calculate(day, weekend);
                continue;
            }
            dayOneCalls.calculate(day, weekdays);
        }
        return dayOneCalls;
    }

    private Calender askMonthAndWeek() {
        return Task.repeatUntilValid(() -> new Calender(inputView.getMonthAndWeek()));
    }

    private List<Members> askOnCall() {
        return Task.repeatUntilValid(() -> {
            Members weekdays = new Members(inputView.getWeekdaysOnCall());
            Members weekend = new Members(inputView.getWeekendOnCall());
            return new ArrayList<>(List.of(weekdays, weekend));
        });
    }

}
