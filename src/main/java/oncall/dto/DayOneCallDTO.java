package oncall.dto;

import oncall.model.DayOncall;

public class DayOneCallDTO {
    private final int month;
    private final int day;
    private final String week;
    private final Boolean isHoliday;
    private final String name;

    public DayOneCallDTO(DayOncall oncall) {
        this.month = oncall.month();
        this.day = oncall.day();
        this.week = oncall.week();
        this.isHoliday = oncall.isHoliday();
        this.name = oncall.name();
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public String getWeek() {
        return week;
    }

    public Boolean getHoliday() {
        return isHoliday;
    }

    public String getName() {
        return name;
    }
}
