package cardsgame;

import java.util.ArrayList;
import java.util.List;

public class Player {
    List<Character> hand = new ArrayList<>();
    int score;

    Player(List<Character> handDealt){
        this.hand = handDealt;
    }

    int getScore(){
        return this.score;
    }

    void scorePoint(){
        this.score += 1;
    }

    char getCard(int index){
        return this.hand.get(index);
    }
}
