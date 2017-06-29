package passwordchecker;

import encryptor.passwordchecker.PasswordChecker;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PasswordCheckerShould {

	/**
	 * Write a checker that validates input Strings to be either valid or invalid for use as a password.
	 *
	 * A valid password should be of sufficient strength, thus it should:
	 * - be at least 8 characters long
	 * - contain at least one of the characters from 0 upto including 9
	 * - contain at least one uppercase character
	 * - contain at least one lowercase character
	 * - contain at least one character from the list !@#$%^&*()_+-;:[]{}
	 * - be safe to persist, so no escape characters may be present "'\/~`
	 * - not contain whitespace (\n \t and spaces)
	 *
	 * Example of a valid password
	 * abAB12!@
	 */

	private PasswordChecker passwordChecker;

	@Before
	public void given_a_passwordchecker() {
		passwordChecker = new PasswordChecker();
	}

	@Test
	public void return_true_for_valid_example_password(){ // abAB12!@
		Assert.assertEquals(passwordChecker.isValid("abAB12!@"), true);
	}

	@Test
	public void return_false_for_password_less_than_8_chars(){
		Assert.assertEquals(passwordChecker.isValid("abAB12!"), false);
	}

	@Test
	public void return_false_for_password_without_numbers(){
		Assert.assertEquals(passwordChecker.isValid("abABvX!@"), false);

	}

	@Test
	public void return_false_for_password_without_capital() {
		Assert.assertEquals(passwordChecker.isValid("abab12!@"), false);
	}

}
