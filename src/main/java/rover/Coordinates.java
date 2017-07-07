package rover;

import rover.Direction;

import java.util.List;

/**
 * Created by maritvandijk on 4/4/17.
 */
public class Coordinates {
    private int x;
    private int y;
    Direction direction;
    List<Obstacle> obstacles;


    public Coordinates(int x, int y, Direction direction, List<Obstacle> obstacles){
        this.x = x;
        this.y = y;
        this.direction = direction;
        this.obstacles = obstacles;
    }

    public int getY(){
        return this.y;
    }

    public int getX(){
        return this.x;
    }

    public Direction getDirection(){
        return this.direction;
    }
}
