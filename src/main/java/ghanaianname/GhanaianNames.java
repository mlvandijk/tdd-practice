package ghanaianname;

import java.time.LocalDate;

public class GhanaianNames {

    public static String getDayOfWeek(LocalDate date) {
        return date.getDayOfWeek().name();
    }
}
