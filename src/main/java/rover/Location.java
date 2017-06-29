package rover;

import lombok.EqualsAndHashCode;
import lombok.ToString;

@EqualsAndHashCode
@ToString

public class Location{
    private final int x;
    private final int y;

    public Location(int x, int y){
        this.x = x;
        this.y = y;
    }
}
