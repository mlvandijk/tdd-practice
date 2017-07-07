package marsrover;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

public class MarsRoverShould {
	/**
	 * Develop an api that moves a marsrover around on a grid.
	 * *
	 * You are given the initial starting point (x,y) of a marsrover and the direction (N,S,E,W) it is facing.
	 * The marsrover receives a character array of commands.
	 * Implement commands that move the marsrover forward/backward (f,b).
	 * Implement commands that turn the marsrover left/right (l,r).
	 * Implement wrapping from one edge of the grid to another. (planets are spheres after all)
	 * Implement obstacle detection before each move to a new square. If a given sequence of commands encounters an
	 * obstacle, the marsrover moves up to the last possible point and reports the obstacle.
	 *
	 */

	@Test
	public void stay_at_starting_location_and_direction_when_it_doesnt_move(){
		Location start = new Location(0,0);
		MarsRover rover = new MarsRover(start, Direction.NORTH);
		Assert.assertThat(rover.getLocation(), Matchers.is(new Location(0, 0)));
		Assert.assertThat(rover.getDirection(),Matchers.is(Direction.NORTH));
	}



}


