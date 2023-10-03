import java.util.Random;

public class RandomMove implements Strategy{

    Random rnd = new Random();

    @Override
    public String determineMove(String playerMove) {
        return RockPaperScissorsFrame.moves[rnd.nextInt(RockPaperScissorsFrame.moves.length)];
    }
}
