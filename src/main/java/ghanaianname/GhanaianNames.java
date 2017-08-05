package ghanaianname;

import java.security.InvalidParameterException;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class GhanaianNames {

//    "Please enter your Date of Birth (yyyy-mm-dd):"

    public static String getDayOfWeek(LocalDate dateInput) {
        return dateInput.getDayOfWeek().name();
    }

    public static LocalDate getLocalDate(String dateInput) {
        boolean isValidInput = isValidDate(dateInput);

        if (isValidInput){
            List<Integer> tokens = transformStringToInts(dateInput);
            return LocalDate.of(tokens.get(0), tokens.get(1), tokens.get(2));
        } else {
            throw new DateTimeException("Date of Birth should have the format yyyy-mm-dd");
        }
    }


    public static boolean isValidDate(String dateInput) {
        try {
            List<Integer> tokens = transformStringToInts(dateInput);
            LocalDate.of(tokens.get(0), tokens.get(1), tokens.get(2));
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
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
