package oncall.constant;

import java.util.List;

public enum DaysPerMonth {
    HAVE_28_DAYS(28, List.of(2)),
    HAVE_30_DAYS(30, List.of(4, 6, 9, 11)),
    HAVE_31_DAYS(31, List.of(1, 3, 5, 7, 8, 10, 12));

    private final int maxDay;
    private final List<Integer> months;

    DaysPerMonth(int maxDay, List<Integer> months) {
        this.maxDay = maxDay;
        this.months = months;
    }

    public static int getMatchingDay(int inputMonth) {
        for (DaysPerMonth daysPerMonth : DaysPerMonth.values()) {
            if (daysPerMonth.months.contains(inputMonth)) {
                return daysPerMonth.maxDay;
            }
        }
        throw new IllegalArgumentException(ErrorMessage.INVALID_MONTH.getMessage());
    }
}
