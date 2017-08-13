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
import java.time.DayOfWeek;
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

    @Test (expected = DateTimeException.class)
    public void input_containing_non_digits_gives_exception(){
        try {
            GhanaianNames.getLocalDate("a");
        } catch (DateTimeException e) {
            Assert.assertEquals(e.getMessage(), "Date of Birth should have the format yyyy-mm-dd");
            throw e;
        }
    }

    @Test(expected = DateTimeException.class)
    public void input_too_long_gives_error_message(){
        try {
            GhanaianNames.getLocalDate("012345678910");
        } catch (DateTimeException e) {
            Assert.assertEquals(e.getMessage(), "Date of Birth should have the format yyyy-mm-dd");
            throw e;
        }
    }

    @Test
    public void date19770225_returns_Friday(){
        Assert.assertEquals(DayOfWeek.FRIDAY, GhanaianNames.getLocalDate("1977-02-25").getDayOfWeek());
    }

    // TO DO list:


    // Validate gender input
    // Should be 'male' or female'
    @Test
    public void male_returns_male(){
        Assert.assertEquals("male", GhanaianNames.getGender("male"));
    }

    @Test
    public void Female_returns_female(){
        Assert.assertEquals("female", GhanaianNames.getGender("Female"));
    }

    @Test
    public void f_returns_female(){
        Assert.assertEquals("female", GhanaianNames.getGender("f"));
    }

    // (Give error message if gender input is incorrect)
    // Note: Make it case insensitive? Accept M/F and Male/Female?

    // Select name based on gender

    // Provide correct name for gender & day of the week
    @Test
    public void date19770225_Female_returns_Afia(){

    }

    @Test
    public void date20120104_Male_returns_Kwaku(){

    }

    @Test
    public void date20140224_Male_returns_Kodjo(){

    }

    @Test
    public void date20120118_Male_returns_Akua(){

    }
    // Note: Test all options, keep some?


}
