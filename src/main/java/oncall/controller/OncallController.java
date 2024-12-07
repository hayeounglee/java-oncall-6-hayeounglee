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
        List<DayOncall> monthOneCall = new ArrayList<>();

        List<Oncall> oncalls = askOnCall();
        Oncall weekdays = oncalls.get(0);
        Oncall weekend = oncalls.get(1);

        for (Day day : calender.getCalender()) {
            if (Weeks.isWeekend(day) || Holidays.isHoliday(day)) {
                monthOneCall.add(new DayOncall(day.month(), day.day(), day.week(), Holidays.isHoliday(day), getOncall(monthOneCall, weekend)));
                continue;
            }
            monthOneCall.add(new DayOncall(day.month(), day.day(), day.week(), Holidays.isHoliday(day), getOncall(monthOneCall, weekdays)));
        }
        outputView.printDayShift(calender, monthOneCall);
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
