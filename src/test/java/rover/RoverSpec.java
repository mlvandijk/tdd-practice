package rover;


import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by maritvandijk on 4/4/17.
 */

/*
Source: http://dallashackclub.com/rover
Develop an api that moves a marsrover around on a grid.
* You are given the initial starting point (x,y) of a marsrover and the direction (N,S,E,W) it is facing.
* - The marsrover receives a character array of commands.
* - Implement commands that move the marsrover forward/backward (f,b).
* - Implement commands that turn the marsrover left/right (l,r).
* - Implement wrapping from one edge of the grid to another. (planets are spheres after all)
* - Implement obstacle detection before each move to a new square.
*   If a given sequence of commands encounters an obstacle, the marsrover moves up to the last possible point and reports the obstacle.
*/
public class RoverSpec {

    private Rover rover;
    private Coordinates roverCoordinates;
    private final Direction direction = Direction.NORTH;
    private int x;
    private int y;
    private List<Obstacle> obstacles;

    @Before
    public void beforeRoverTest() {
        x = 2;
        y = 9;
        obstacles = new ArrayList<Obstacle>();
        roverCoordinates = new Coordinates(x, y, direction, obstacles);
        rover = new Rover(roverCoordinates);
    }

    @Test
    public void newInstanceShouldSetRoverCoordinatesAndDirection() {
        assertEquals(rover.getCoordinates(), roverCoordinates);
    }

    @Test
    public void receiveSingleCommandShouldMoveForwardWhenCommandIsF() throws Exception {
        int expected = y + 1;
        rover.receiveSingleCommand('F');
        assertTrue(rover.getCoordinates().getY() == expected);
    }

    @Test
    public void receiveSingleCommandShouldMoveBackwardWhenCommandIsB() throws Exception {
        int expected = y - 1;
        rover.receiveSingleCommand('B');
        assertTrue(rover.getCoordinates().getY() == expected);
    }

    @Test
    public void receiveSingleCommandShouldTurnLeftWhenCommandIsL() throws Exception {
        rover.receiveSingleCommand('L');
        assertEquals(rover.getCoordinates().getDirection(), Direction.WEST);
    }

    @Test
    public void receiveSingleCommandShouldTurnRightWhenCommandIsR() throws Exception {
        rover.receiveSingleCommand('R');
        assertEquals(rover.getCoordinates().getDirection(), Direction.EAST);
    }

    @Test
    public void receiveSingleCommandShouldIgnoreCase() throws Exception {
        rover.receiveSingleCommand('r');
        assertEquals(rover.getCoordinates().getDirection(), Direction.EAST);
    }

    @Test(expected = Exception.class)
    public void receiveSingleCommandShouldThrowExceptionWhenCommandIsUnknown() throws Exception {
        rover.receiveSingleCommand('X');
    }

    @Test
    public void receiveCommandsShouldBeAbleToReceiveMultipleCommands() throws Exception {
        int expected = x + 1;
        rover.receiveCommands("RFR");
        assertTrue(rover.getCoordinates().getX() == expected);
        assertEquals(rover.getCoordinates().getDirection(), Direction.SOUTH);
    }

//    @Test
//    public void receiveCommandShouldWhatFromOneEdgeOfTheGridToAnother() throws Exception {
//        int expected = x.getMaxLocation() + x.getLocation() - 2;
//        marsrover.receiveCommands("LFFF");
//        assertThat(marsrover.getCoordinates().getX().getLocation()).isEqualTo(expected);
//    }
//
//    @Test
//    public void receiveCommandsShouldStopWhenObstacleIsFound() throws Exception {
//        int expected = x.getLocation() + 1;
//        marsrover.getCoordinates().setObstacles(Arrays.asList(new Obstacle(expected + 1, y.getLocation())));
//        marsrover.getCoordinates().setDirection(Direction.EAST);
//        marsrover.receiveCommands("FFFRF");
//        assertThat(marsrover.getCoordinates().getX().getLocation()).isEqualTo(expected);
//        assertThat(marsrover.getCoordinates().getDirection()).isEqualTo(Direction.EAST);
//    }
//
//    @Test
//    public void positionShouldReturnXYAndDirection() throws Exception {
//        marsrover.receiveCommands("LFFFRFF");
//        assertThat(marsrover.getPosition()).isEqualTo("8 X 4 N");
//    }
//
//    @Test
//    public void positionShouldReturnNokWhenObstacleIsFound() throws Exception {
//        marsrover.getCoordinates().setObstacles(Arrays.asList(new Obstacle(x.getLocation() + 1, y.getLocation())));
//        marsrover.getCoordinates().setDirection(Direction.EAST);
//        marsrover.receiveCommands("F");
//        assertThat(marsrover.getPosition()).endsWith(" NOK");
//    }

}

