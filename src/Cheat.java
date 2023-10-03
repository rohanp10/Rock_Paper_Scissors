public class Cheat implements Strategy{
    @Override
    public String determineMove(String playerMove) {

        if (playerMove.equals("R")) {
            return "P";
        }
        else if (playerMove.equals("P")) {
            return "S";
        }
        else {
            return "R";
        }
    }
}
