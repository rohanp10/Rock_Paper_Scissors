import java.util.Random;
public class LeastUsed implements Strategy{

    public LeastUsed() {}

    Random rnd = new Random();

    @Override
    public String determineMove(String playerMove) {

        int rockCount = RockPaperScissorsFrame.rockCount;
        int paperCount = RockPaperScissorsFrame.paperCount;
        int scissorsCount = RockPaperScissorsFrame.scissorsCount;

        if ((rockCount == paperCount) && (rockCount == scissorsCount)){
            return RockPaperScissorsFrame.moves[rnd.nextInt(RockPaperScissorsFrame.moves.length)];
        }
        else {
            int minimumCount = Math.min(rockCount, Math.min(paperCount, scissorsCount));

            if (minimumCount == rockCount) {
                return "R";
            }
            else if (minimumCount == paperCount) {
                return "P";
            }
            else {
                return "S";
            }
        }

    }
}
