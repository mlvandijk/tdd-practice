package ghanaianname;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class GhanaianNames {

    public static String getDayOfWeek(LocalDate dateInput) {
        return dateInput.getDayOfWeek().name();
    }

    public static LocalDate getLocalDate(String dateInput) {
        List<Integer> tokens = transformStringToInts(dateInput);
        return LocalDate.of(tokens.get(0), tokens.get(1), tokens.get(2));
    }

    private static List<Integer> transformStringToInts(String date) {
        String[] dateAsStrings = date.split("-");
        List<Integer> dateAsInts = new ArrayList<>();
        for (int i = 0; i < 3; i++){
            int integer = Integer.valueOf(dateAsStrings[i]);
            dateAsInts.add(integer);
        }
        return dateAsInts;
    }
}
