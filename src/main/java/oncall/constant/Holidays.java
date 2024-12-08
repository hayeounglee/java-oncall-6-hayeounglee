package oncall.constant;

import oncall.model.Day;

public enum
Holidays {
    SINGUNG(1, 1),
    SAMILGUAL(3, 1),
    ARININALL(5, 5),
    HAUNCHUNGIL(6, 6),
    GAUNGBOCKJUAL(8, 15),
    GACUANJUAL(10, 3),
    HANGUALNAL(10, 9),
    SAUNGTANGUAL(12, 25);


    private final int month;
    private final int day;

    Holidays(int month, int day) {
        this.month = month;
        this.day = day;
    }

    public static boolean isHoliday(Day day) {
        for (Holidays holidays : Holidays.values()) {
            if (day.month() == holidays.month && day.day() == holidays.day) {
                return true;
            }
        }
        return false;
    }
}
