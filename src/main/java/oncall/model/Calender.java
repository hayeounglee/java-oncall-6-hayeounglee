package oncall.model;

import oncall.constant.DaysPerMonth;
import oncall.util.Parser;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Calender {
    private final int month;
    private List<Today> calender;
    List<String> weeks = new ArrayList<>(List.of("월", "화", "수", "목", "금", "토", "일"));

    public Calender(String monthAndWeek) {
        month = Parser.parseToInt(Parser.parseDelimiter(monthAndWeek, ",").get(0));// 일 수 가져오기
        String startWeek = Parser.parseDelimiter(monthAndWeek, ",").get(1);
        calender = new ArrayList<>();

        int weekIndex = weeks.indexOf(startWeek);
        int maxDay = DaysPerMonth.getMatchingDay(month);
        List<Integer> todayDay = IntStream.range(1, maxDay + 1)
                .boxed()
                .collect(Collectors.toList());

        for (Integer day : todayDay) {
            calender.add(new Today(month, day, weeks.get(weekIndex % 7)));
            weekIndex++;
        }
    }

    public List<Today> getCalender() {
        return calender;
    }

    public int getMonth() {
        return month;
    }
}
