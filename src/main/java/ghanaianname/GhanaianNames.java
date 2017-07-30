package ghanaianname;

import java.time.LocalDate;

public class GhanaianNames {


    public static WeekDays getDayOfWeek(LocalDate of) {
        return WeekDays.FRIDAY;
    }

    public enum WeekDays{
        SUNDAY,
        MONDAY,
        TUESDAY,
        WEDNESDAY,
        THURSDAY,
        FRIDAY,
        SATURDAY
    }
}
