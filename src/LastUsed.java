public class LastUsed implements Strategy{


    @Override
    public String determineMove(String playerMove) {
        return RockPaperScissorsFrame.lastMove;
    }
}
