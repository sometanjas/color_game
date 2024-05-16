import java.awt.*;
import java.util.ArrayList;

public class SequenceChecker {

    public boolean sequenceChecker(ArrayList<Color> shownSequence, ArrayList<Color> inputSequence) {
        if (shownSequence.size() != inputSequence.size()) {
            return false;
        }
        return shownSequence.equals(inputSequence);
    }
}
