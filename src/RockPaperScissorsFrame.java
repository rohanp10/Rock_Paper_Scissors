import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Random;
import java.util.ArrayList;

public class RockPaperScissorsFrame extends JFrame {

    JPanel mainPnl;
    JPanel topPnl;
    JPanel middlePnl;
    JPanel bottomPnl;

    JPanel titlePnl;
    JPanel buttonPnl;

    JTextArea displayTA;
    JScrollPane scroller;

    JLabel titleLbl;
    JLabel playerWinsText;
    JLabel computerWinsText;
    JLabel tiesText;

    JTextField playerWinsField;
    JTextField computerWinsField;
    JTextField tiesField;

    ImageIcon rockIcon;
    ImageIcon paperIcon;
    ImageIcon scissorsIcon;
    ImageIcon quitIcon;

    JButton rock;
    JButton paper;
    JButton scissors;
    JButton quit;

    public static int playerWinsCounter = 0;
    public static int computerWinsCounter = 0;
    public static int tiesCounter = 0;

    public static int rockCount = 0;
    public static int paperCount = 0;
    public static int scissorsCount = 0;

    public static String lastMove = "R";

    public static String[] moves = {"R", "P", "S"};

    Random rnd = new Random();


    public RockPaperScissorsFrame()
    {
        mainPnl = new JPanel();

        mainPnl.setLayout(new BorderLayout());

        createTopPnl();
        mainPnl.add(topPnl, BorderLayout.NORTH);

        createMiddlePnl();
        mainPnl.add(middlePnl, BorderLayout.CENTER);

        createBottomPnl();
        mainPnl.add(bottomPnl, BorderLayout.SOUTH);

        add(mainPnl);

    }

    private void createTopPnl()
    {

        topPnl = new JPanel();

        topPnl.setLayout(new BorderLayout());

        titlePnl = new JPanel();
        titleLbl = new JLabel("Rock Paper Scissors Game", JLabel.CENTER);

        titleLbl.setFont(new Font("Roboto", Font.PLAIN, 36));

        titleLbl.setVerticalTextPosition(JLabel.TOP);
        titleLbl.setHorizontalTextPosition(JLabel.CENTER);

        titlePnl.setBackground(new Color(198,226,255));

        titlePnl.add(titleLbl);

        buttonPnl = new JPanel();

        buttonPnl.setLayout(new GridLayout(1, 4));

        rockIcon = new ImageIcon("src/rock.png");
        Image rockImg = rockIcon.getImage() ;
        Image rockScaled = rockImg.getScaledInstance(50, 50,  java.awt.Image.SCALE_SMOOTH ) ;
        rockIcon = new ImageIcon(rockScaled);

        paperIcon = new ImageIcon("src/paper.png");
        Image paperImg = paperIcon.getImage() ;
        Image paperScaled = paperImg.getScaledInstance(50, 50,  java.awt.Image.SCALE_SMOOTH ) ;
        paperIcon = new ImageIcon(paperScaled);

        scissorsIcon = new ImageIcon("src/scissors.png");
        Image scissorsImg = scissorsIcon.getImage() ;
        Image scissorsScaled = scissorsImg.getScaledInstance(50, 50,  java.awt.Image.SCALE_SMOOTH ) ;
        scissorsIcon = new ImageIcon(scissorsScaled);

        quitIcon = new ImageIcon("src/quit.png");
        Image quitImg = quitIcon.getImage() ;
        Image quitScaled = quitImg.getScaledInstance(50, 50,  java.awt.Image.SCALE_SMOOTH ) ;
        quitIcon = new ImageIcon(quitScaled);

        rock = new JButton("Rock", rockIcon);
        rock.addActionListener((ActionEvent ae) ->
        {
            String result = playGame("R");
            displayTA.append(result + "\n");
            rockCount += 1;
            lastMove = "R";
        });

        paper = new JButton("Paper", paperIcon);
        paper.addActionListener((ActionEvent ae) ->
        {
            String result = playGame("P");
            displayTA.append(result + "\n");
            paperCount += 1;
            lastMove = "P";
        });

        scissors = new JButton("Scissors", scissorsIcon);
        scissors.addActionListener((ActionEvent ae) ->
        {
            String result = playGame("S");
            displayTA.append(result + "\n");
            scissorsCount += 1;
            lastMove = "S";
        });

        quit = new JButton("Quit", quitIcon);
        quit.addActionListener((ActionEvent ae) -> System.exit(0));


        buttonPnl.add(rock);
        buttonPnl.add(paper);
        buttonPnl.add(scissors);
        buttonPnl.add(quit);


        rock.setFont(new Font("Sans Serif", Font.PLAIN, 15));
        paper.setFont(new Font("Sans Serif", Font.PLAIN, 15));
        scissors.setFont(new Font("Sans Serif", Font.PLAIN, 15));
        quit.setFont(new Font("Sans Serif", Font.PLAIN, 15));

        topPnl.setBorder(new EmptyBorder(10, 10, 10, 10));

        titlePnl.setBorder(new EmptyBorder(10, 10, 10, 10));

        buttonPnl.setBorder(BorderFactory.createLineBorder(Color.black));

        buttonPnl.setBackground(new Color(198,226,255));

        topPnl.setBackground(new Color(198,226,255));

        topPnl.add(titlePnl, BorderLayout.NORTH);
        topPnl.add(buttonPnl, BorderLayout.CENTER);


    }

    private void createMiddlePnl()
    {
        middlePnl = new JPanel();

        middlePnl.setLayout(new BorderLayout());

        middlePnl.setBorder(new EmptyBorder(10, 10, 10, 10));

        playerWinsText = new JLabel("Player Wins: " + playerWinsCounter, JLabel.CENTER);

        playerWinsText.setFont(new Font("Montserrat", Font.PLAIN, 20));
        playerWinsText.setVerticalTextPosition(JLabel.TOP);
        playerWinsText.setHorizontalTextPosition(JLabel.CENTER);
        playerWinsText.setForeground(new Color(24, 119, 242));

        computerWinsText = new JLabel("Computer Wins: " + computerWinsCounter, JLabel.CENTER);

        computerWinsText.setFont(new Font("Montserrat", Font.PLAIN, 20));
        computerWinsText.setVerticalTextPosition(JLabel.CENTER);
        computerWinsText.setHorizontalTextPosition(JLabel.CENTER);
        computerWinsText.setForeground(new Color(24, 119, 242));

        tiesText = new JLabel("Ties: " + tiesCounter, JLabel.CENTER);

        tiesText.setFont(new Font("Montserrat", Font.PLAIN, 20));
        tiesText.setVerticalTextPosition(JLabel.BOTTOM);
        tiesText.setHorizontalTextPosition(JLabel.CENTER);
        tiesText.setForeground(new Color(24, 119, 242));

        middlePnl.add(playerWinsText, BorderLayout.NORTH);
        middlePnl.add(computerWinsText, BorderLayout.CENTER);
        middlePnl.add(tiesText, BorderLayout.SOUTH);

        middlePnl.setBackground(new Color(198,226,255));


    }

    private void createBottomPnl()
    {
        bottomPnl = new JPanel();
        bottomPnl.setLayout(new BorderLayout());

        bottomPnl.setBorder(new EmptyBorder(10, 10, 10, 10));

        displayTA = new JTextArea(10, 40);

        displayTA.setFont(new Font("Verdana", Font.PLAIN, 20));

        displayTA.setEditable(false);
        scroller = new JScrollPane(displayTA);
        bottomPnl.add(scroller);

        bottomPnl.setBackground(new Color(198,226,255));

    }

    private String playGame(String playerMove) {

        String result = "";
        String strategy = "";

        String computerMove;

        int initialProbability = new Random().nextInt(10);

        if (!(initialProbability == 0)) {
            String[] strategies = {"Least Used", "Most Used", "Last Used", "Random"};

            strategy = strategies[rnd.nextInt(strategies.length)];
        }
        else {
            strategy = "Cheat";
        }

        Strategy playStrategy;

        if (strategy.equals("Least Used")) {
            playStrategy = new LeastUsed();
        }
        else if (strategy.equals("Most Used")) {
            playStrategy = new MostUsed();

        }
        else if (strategy.equals("Last Used")) {
            playStrategy = new LastUsed();

        }
        else if (strategy.equals("Random")) {
            playStrategy = new RandomMove();
        }
        else {
            playStrategy = new Cheat();
        }

        computerMove = playStrategy.determineMove(playerMove);


        if (playerMove.equals("R")) {

            if (computerMove.equals("R"))
            {
                tiesCounter += 1;
                result = "Both players choose Rock (Tie, " + strategy + ")";
            }
            else if (computerMove.equals("P"))
            {
                computerWinsCounter += 1;
                result = "Paper covers Rock (Computer Wins, " + strategy + ")";
            }
            else {
                playerWinsCounter += 1;
                result = "Rock breaks Scissors (Player Wins, " + strategy + ")";
            }
        }
        else if (playerMove.equals("P")) {

            if (computerMove.equals("R"))
            {
                playerWinsCounter += 1;
                result = "Paper covers Rock (Player Wins, " + strategy + ")";
            }
            else if (computerMove.equals("P"))
            {
                tiesCounter += 1;
                result = "Both players choose Paper (Tie, " + strategy + ")";
            }
            else {
                computerWinsCounter += 1;
                result = "Scissors covers Paper (Computer Wins, " + strategy + ")";
            }

        }
        else {

            if (computerMove.equals("R"))
            {
                computerWinsCounter += 1;
                result = "Rock breaks Scissors (Computer Wins, " + strategy + ")";
            }
            else if (computerMove.equals("P"))
            {
                playerWinsCounter += 1;
                result = "Scissors covers Paper (Player Wins, " + strategy + ")";
            }
            else {
                tiesCounter += 1;
                result = "Both players choose Scissors (Tie, " + strategy + ")";
            }

        }

        playerWinsText.setText("Player Wins: " + playerWinsCounter);
        computerWinsText.setText("Computer Wins: " + computerWinsCounter);
        tiesText.setText("Ties: " + tiesCounter);

        return result;

    }
}