package oncall.model;

import oncall.constant.DaysPerMonth;
import oncall.constant.Weeks;
import oncall.util.Parser;
import oncall.validator.FormValidator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Calender {
    private final List<Day> calender;

    public Calender(String monthAndWeek) {
        validate(monthAndWeek);
        calender = new ArrayList<>();
        makeCalender(monthAndWeek);
    }

    private void validate(String input) {
        FormValidator formValidator = new FormValidator();
        formValidator.validateForm(input);
    }

    private void makeCalender(String monthAndWeek) {
        int month = Parser.parseToInt(Parser.parseDelimiter(monthAndWeek, ",").get(0));
        String startWeek = Parser.parseDelimiter(monthAndWeek, ",").get(1);

        int weekIndex = Weeks.getIndex(startWeek);
        List<Integer> days = makeDays(month);

        for (Integer day : days) {
            calender.add(new Day(month, day, Weeks.getWeek(weekIndex % 7)));
            weekIndex++;
        }
    }

    private List<Integer> makeDays(int month) {
        int maxDay = DaysPerMonth.getMatchingDay(month);
        return IntStream.range(1, maxDay + 1)
                .boxed()
                .toList();
    }

    public List<Day> getCalender() {
        return calender;
    }
}
