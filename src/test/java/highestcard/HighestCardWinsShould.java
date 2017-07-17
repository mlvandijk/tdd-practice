package highestcard;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.util.*;
import static org.hamcrest.Matchers.*;

public class HighestCardWinsShould {
	/**
	 * Implement a simple cardgame of highest card wins
	 *
	 * Given two stacks of arbitrary but equal length it should determine the winner by comparing consecutive cards and
	 * - print the winner and the final score or tied at score
	 *
	 * Examples:
	 * 2,3,4 vs 3,2,5 should print "Player 2 wins 2 to 1"
	 * ace, queen vs 10, 2 should print "Player 1 wins 2 to 0
	 * 7 vs 7 should print "Tied at 1"
	 *
	 * You are free to choose the representation of the cards and stacks
	 */
	
    CardsGame game;
    List<Character> cardsPlayer1;
    List<Character> cardsPlayer2;

    @Before
    public void setupGame(){
        game = new CardsGame();
        cardsPlayer1 = new ArrayList<>();
        cardsPlayer2 = new ArrayList<>();
    }

    @Test
    public void game_with_same_card_is_tied(){
        cardsPlayer1.add('2');
        cardsPlayer2.add('2');
        Assert.assertThat(game.determineGameResult(cardsPlayer1, cardsPlayer2), is("Tie"));
    }

    @Test
    public void player1_wins_with_higher_card(){
        cardsPlayer1.add('3');
        cardsPlayer2.add('2');
        Assert.assertThat(game.determineGameResult(cardsPlayer1, cardsPlayer2), is("Player1 wins 1 to 0"));
    }

    @Test
    public void player2_wins_with_higher_card(){
        cardsPlayer1.add('2');
        cardsPlayer2.add('3');
        Assert.assertThat(game.determineGameResult(cardsPlayer1, cardsPlayer2), is("Player2 wins 1 to 0"));
    }

    @Test
    public void player1_wins_with_higher_cards(){
        cardsPlayer1.add('A');
        cardsPlayer1.add('7');
        cardsPlayer1.add('8');

        cardsPlayer2.add('K');
        cardsPlayer2.add('5');
        cardsPlayer2.add('9');
        Assert.assertThat(game.determineGameResult(cardsPlayer1, cardsPlayer2), is("Player1 wins 2 to 1"));
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void cannot_play_if_nr_of_cards_is_not_equal(){
        cardsPlayer1.add('A');
        game.determineGameResult(cardsPlayer1, cardsPlayer2);
    }
}
