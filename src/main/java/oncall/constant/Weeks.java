package oncall.constant;

import oncall.model.Day;

public enum Weeks {
    MON("월"),
    TUE("화"),
    WED("수"),
    THU("목"),
    FRI("금"),
    SAT("토"),
    SUN("일");
    private final String week;

    Weeks(String week) {
        this.week = week;
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

    public String getWeek() {
        return week;
    }
}
