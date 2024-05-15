import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class ColorPanel extends JPanel {
    private Color defaultBackground = new Color(128,128,128);

    private JButton startButton = new JButton("Start");
    private JButton stopButton = new JButton("Stop");
    private JButton sequenceCheckerButton = new JButton("Sequence Checker");
    private JButton redButton = new JButton("Red");
    private JButton blueButton = new JButton("Blue");
    private JButton greenButton = new JButton("Green");
    private Timer timer = new Timer( 2000, new BackgroundListener());

    private JPanel colourPanel = new JPanel();
    private JLabel resultLabel = new JLabel ("Result: ");
    private ArrayList<Color> shownSequence = new ArrayList<>();
    private ArrayList<Color> inputSequence = new ArrayList<>();

    private JLabel showCount = new JLabel("Counts");
    private ArrayList<Color> colors = new ArrayList<>();



    public ColorPanel() {
        super();


        // default background which separate game phases
        colourPanel.setBackground(defaultBackground);

        // define playing colors to arraylist
        colors.add(Color.blue);
        colors.add(Color.red);
        colors.add(Color.green);

        // start button definition
        add(startButton);
        ActionListener start = new StartButtonListener();
        startButton.addActionListener(start);

        // shows how many times the background has changed
        add(showCount);

        // stop button definition
        add(stopButton);
        ActionListener stop = new StopButtonListener();
        stopButton.addActionListener(stop);

        // sequence checker button definition
        add(sequenceCheckerButton);
        ActionListener check = new CheckerButtonListener();
        sequenceCheckerButton.addActionListener(check);


        // playing input colors definitions
        add(redButton);
        add(blueButton);
        add(greenButton);
        ActionListener r = new AnyColorListener(Color.red);
        redButton.addActionListener(r);
        ActionListener b = new AnyColorListener(Color.blue);
        blueButton.addActionListener(b);
        ActionListener g = new AnyColorListener(Color.green);
        greenButton.addActionListener(g);


        // result of the game
        add(resultLabel);
    }

    private class CheckerButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (SequenceChecker.sequenceChecker(shownSequence, inputSequence)) {
                System.out.println("yes");
                resultLabel.setText("You won");
            }
            else {
                System.out.println("no");
                resultLabel.setText("You lost");
            }
            // as we know whether actor wins or lost, the program should start over again, so input sequence must be cleared
            inputSequence.clear();
        }
    }
    private class StartButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            timer.start();
            System.out.println("Start-Button pressen");
            // here we clean the shown sequence, in case if person just stopped the sequence without submitting the answers
            shownSequence.clear();
        }
    }

    private class StopButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            timer.stop();
            System.out.println("Stop-Button pressen");
            setBackground(defaultBackground);
        }
    }

    private class BackgroundListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            // random index from the arrayList of colors
            int colorIndex = (int) (Math.random() * colors.size());

            // save the Color on the random index
            Color shownColor = colors.get(colorIndex);
            setBackground(shownColor);

            // new arrayList to save the sequence of shown colors
            shownSequence.add(shownColor);
            showCount.setText("Count: " + shownSequence.size());
            System.out.println(shownSequence);
        }
    }


    private class AnyColorListener implements ActionListener {
        private Color myColor;

        public AnyColorListener(Color myColor) {
            this.myColor = myColor;
        }

        public void actionPerformed(ActionEvent e) {
            // the input colors will be saved in new inputSequence-arrayList
            inputSequence.add(myColor);
            System.out.println(inputSequence);
        }
    }

}
