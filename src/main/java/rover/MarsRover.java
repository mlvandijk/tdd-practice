package rover;


public class MarsRover {
    Location location;
    Direction direction;

    public MarsRover(Location startLocation, Direction startDirection){
        this.location = startLocation;
        this.direction = startDirection;
    }


    public Location getLocation() {
        return this.location;
    }

    public Direction getDirection() {
        return this.direction;
    }
}
