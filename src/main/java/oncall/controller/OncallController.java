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
        DayOneCalls dayOneCalls = new DayOneCalls();
        List<Oncall> oncalls = askOnCall();

        makeOneCalls(calender, dayOneCalls, oncalls);

        outputView.printDayShift(dayOneCalls);
    }

    private void makeOneCalls(Calender calender, DayOneCalls dayOneCalls, List<Oncall> oncalls) {
        Oncall weekdays = oncalls.get(0);
        Oncall weekend = oncalls.get(1);

        for (Day day : calender.getCalender()) {
            if (Weeks.isWeekend(day) || Holidays.isHoliday(day)) {
                dayOneCalls.calculate(day, weekend);
                continue;
            }
            dayOneCalls.calculate(day, weekdays);
        }
    }

    private Calender askMonthAndWeek() {
        return Task.repeatUntilValid(() -> new Calender(inputView.getMonthAndWeek()));
    }

    private List<Oncall> askOnCall() {
        return Task.repeatUntilValid(() -> {
            Oncall weekdays = new Weekdays(inputView.getWeekdaysOnCall());
            Oncall weekend = new Weekend(inputView.getWeekendOnCall());
            return new ArrayList<>(List.of(weekdays, weekend));
        });
    }

}
