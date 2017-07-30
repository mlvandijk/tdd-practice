package ghanaianname;

/*
* In Ghana, you get a name based on the day of the week you were born (see table below)
* Create a program that takes a date and sex from the user, and returns their Ghanaian Name
*
* Week day  | Female    | Male
* SUNDAY 	| Akosua    | Kwasi
* MONDAY    | Adjoa     | Kodjo
* TUESDAY   | Abenaa    | Kwabena
* WEDNESDAY | Akua      | Kwaku
* THURSDAY  | Yaa       | Yaw
* FRIDAY    | Afia      | Kofi
* SATURDAY  | Amma      | Kwame
*
* Source (includes pronunciation): https://thisworldmusic.com/african-day-name-generator/
*/

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;

public class GhanaianNamesShould {

    @Test
    public void feb_25th_1977_is_a_friday(){
        Assert.assertEquals(GhanaianNames.getDayOfWeek(LocalDate.of(1977, 2, 25)), GhanaianNames.WeekDays.FRIDAY);
    }

    @Test
    public void jan_4th_2012_is_a_wednesday(){
        Assert.assertEquals(GhanaianNames.getDayOfWeek(LocalDate.of(2012, 1, 4)), GhanaianNames.WeekDays.WEDNESDAY);
    }


}
