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

import java.time.DateTimeException;
import java.time.LocalDate;

public class GhanaianNamesShould {

    @Test
    public void feb_25th_1977_is_a_friday(){
        Assert.assertEquals(GhanaianNames.getDayOfWeek(LocalDate.of(1977, 2, 25)), "FRIDAY");
    }

    @Test
    public void jan_4th_2012_is_a_wednesday(){
        Assert.assertEquals(GhanaianNames.getDayOfWeek(LocalDate.of(2012, 1, 4)), "WEDNESDAY");
    }



    @Test
    public void input_20170731_is_mon_31st_juli_2017(){
        Assert.assertEquals(GhanaianNames.getLocalDate("2017-07-31"), LocalDate.of(2017, 07, 31) );
    }


    // Validate date input is correct
    // non-digits
    @Test (expected = DateTimeException.class)
    public void input_containing_non_digits_gives_error_message(){
        Assert.assertEquals(GhanaianNames.getLocalDate("a"), "Date of Birth should have the format yyyy-mm-dd" );
    }
    
    // TO DO list:

    // eg contains non-digits, wrong length, no -, etc.
    // (Give error message if date input is incorrect)

    // Get day of week from correct date input

    // Provide correct Ghanaian name/names for day of the week

    // Select name based on gender

    // Validate gender input
    // Should be 'male' or female'
    // (Give error message if gender input is incorrect)
    // Note: Make it case insensitive? Accept M/F and Male/Female?

    // Provide correct name for gender & day of the week
    // Test cases: Afia (F/Friday), Kwaku(M/Wednesday), Kodjo(M/Monday)
    // Test all options, keep some


}
