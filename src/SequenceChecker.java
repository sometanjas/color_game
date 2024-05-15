import java.awt.*;
import java.util.ArrayList;

public class SequenceChecker {

    private ArrayList<Color> shownSequence;

    private ArrayList<Color> inputSequence;

    public static boolean sequenceChecker(ArrayList<Color> shownSequence, ArrayList<Color> inputSequence) {
        if (shownSequence.size() != inputSequence.size()) {
            return false;
        }
        return shownSequence.equals(inputSequence);
    }
}
