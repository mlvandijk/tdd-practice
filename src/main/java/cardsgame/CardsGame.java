import java.util.List;

public class CardsGame {
    private Player player1;
    private Player player2;

    private void play(){
        for (int i = 0; i < player1.hand.size(); i++){
            String cards = "23456789TJKA";
            int rankCardPlayer1 = cards.indexOf(player1.getCard(i));
            int rankCardPlayer2 = cards.indexOf(player2.getCard(i));
            if (rankCardPlayer1 > rankCardPlayer2){
                player1.scorePoint();
            } else if (rankCardPlayer1 < rankCardPlayer2){
                player2.scorePoint();
            }
        }
    }

    public String determineGameResult(List<Character> hand1, List<Character> hand2) {
        player1 = new Player(hand1);
        player2 = new Player(hand2);
        this.play();

        if (player1.getScore() > player2.getScore()){
            return "Player1 wins " + player1.getScore() + " to " + player2.getScore();
        } else if (player1.getScore() < player2.getScore()){
            return "Player2 wins " + player2.getScore() + " to " + player1.getScore();
        }
        return "Tie";
    }
}
