package bowling;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

public class BowlingScoreShould {
	/**
	 * A bowling game consists of ten turns in which the player can throw a ball to knock down up to ten pins.
	 * If he does not knock down all the ten pins, he is allowed a second throw to knock down some or all of the remaining pins.
	 *
	 * The score is calculated as follows:
	 * - If all ten pins are knocked down in one throw, it is called a strike.
	 * The score is the pins of this throw (10) plus the total number of pins knocked down in the next two throws.
	 * (Thus, these next two throws are calculated twice).
	 *
	 * - If all ten pins are knocked down in two throws, it is called a spare.
	 * The score of a spare is the total number of pins of the two throws, plus the number of pins of the next throw
	 * (Thus, the next throw is calculated twice).
	 *
	 * - Otherwise the score is caluculated by adding the number of pins knocked down in both throws
	 *
	 * If the last turn is a spare or a strike, extra balls are allowed to calculate the extra score granted by the
	 * spare or strike. These extra throws are ONLY counted for the extra points awarded by the strike or spare,
	 * these are NOT turns in themselves
	 *
	 * Implement a score calculator that calculates the score of a single player by registering all the throws and adding
	 * them using the rules above.
	 */
}
