package rover;

/**
 * Created by maritvandijk on 4/4/17.
 */
public class Rover {

    private Coordinates coordinates;

    public Rover(Coordinates coordinates){
        this.coordinates = coordinates;
    }

    public Coordinates getCoordinates(){
        return this.coordinates;
    }

    public void receiveSingleCommand(char c) throws Exception {
        switch (c) {
            case 'F':
                // TODO
                break;
            case 'B':
                // TODO
                break;
            case 'L':
            case 'l':
                turnLeft();
                break;
            case 'R':
            case 'r':
                turnRight();
                break;
            default:
                throw new Exception();
        }
    }

    public void receiveCommands(String commands){
        for (int i = 0; i < commands.length(); i++){
            try {
                receiveSingleCommand(commands.charAt(i));
            } catch (Exception e) {
                System.out.println("Exception caught");
                e.printStackTrace();
            }
        }
    }

    public void turnLeft(){
        if (this.coordinates.getDirection().equals(Direction.NORTH)){
            this.coordinates.direction = Direction.WEST;
        } else if (this.coordinates.getDirection().equals(Direction.WEST)){
            this.coordinates.direction = Direction.SOUTH;
        } else if (this.coordinates.getDirection().equals(Direction.SOUTH)){
            this.coordinates.direction = Direction.EAST;
        } else if (this.coordinates.getDirection().equals(Direction.EAST)) {
            this.coordinates.direction = Direction.NORTH;
        }
    }

    public void turnRight(){
        if (this.coordinates.getDirection().equals(Direction.NORTH)){
            this.coordinates.direction = Direction.EAST;
        } else if (this.coordinates.getDirection().equals(Direction.EAST)){
            this.coordinates.direction = Direction.SOUTH;
        } else if (this.coordinates.getDirection().equals(Direction.SOUTH)){
            this.coordinates.direction = Direction.WEST;
        } else if (this.coordinates.getDirection().equals(Direction.WEST)) {
            this.coordinates.direction = Direction.NORTH;
        }
    }
}

