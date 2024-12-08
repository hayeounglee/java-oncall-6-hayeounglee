package oncall.constant;

import oncall.model.Day;

public enum Weeks {
    MON("월", 0),
    TUE("화", 1),
    WED("수", 2),
    THU("목", 3),
    FRI("금", 4),
    SAT("토", 5),
    SUN("일", 6);
    private final String week;
    private final int index;

    Weeks(String week, int index) {
        this.week = week;
        this.index = index;
    }

    public static boolean isWeekend(Day day) {
        if (day.week().equals(SAT.week) || day.week().equals(SUN.week)) {
            return true;
        }
        for (Weeks weeks : Weeks.values()) {
            if (weeks.getWeek().equals(day.week())) {
                return false;
            }
        }
        throw new IllegalArgumentException(ErrorMessage.INVALID_WEEK.getMessage());
    }

    public static int getIndex(String week) {
        for (Weeks weeks : Weeks.values()) {
            if (weeks.getWeek().equals(week)) {
                return weeks.index;
            }
        }
        throw new IllegalArgumentException(ErrorMessage.INVALID_FORM.getMessage());
    }

    public static String getWeek(int index) {
        for (Weeks weeks : Weeks.values()) {
            if (weeks.getIndex() == index) {
                return weeks.week;
            }
        }
        throw new IllegalArgumentException(ErrorMessage.INVALID_FORM.getMessage());
    }

    public String getWeek() {
        return week;
    }

    public int getIndex() {
        return index;
    }
}
