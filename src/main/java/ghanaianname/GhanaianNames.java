package ghanaianname;

import java.time.LocalDate;

public class GhanaianNames {

    public static String getDayOfWeek(LocalDate date) {
        return date.getDayOfWeek().name();
    }

    public static LocalDate getLocalDate(String date) {
        String[] tokens = date.split("-");
        return LocalDate.of(Integer.valueOf(tokens[0]), Integer.valueOf(tokens[1]), Integer.valueOf(tokens[2]));
    }
}
