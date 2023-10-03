import java.util.Random;
public class MostUsed implements Strategy{

    public MostUsed() {}

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
            int maximumCount = Math.max(rockCount, Math.max(paperCount, scissorsCount));

            if (maximumCount == rockCount) {
                return "R";
            }
            else if (maximumCount == paperCount) {
                return "P";
            }
            else {
                return "S";
            }
        }

    }
}
