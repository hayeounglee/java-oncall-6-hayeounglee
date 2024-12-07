package oncall.model;

public record DayOncall(
        int month,
        int day,
        String week,
        Boolean isHoliday,
        String name
) {
}
