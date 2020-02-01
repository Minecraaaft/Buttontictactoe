import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

public class GameView extends JFrame{
    private JButton buttons[] = new JButton[9];
    private ImageIcon img, x, o;
    private JPanel panel = new JPanel();
    private JLabel label = new JLabel("press this");
    JPanel p2;
    JButton restartButton;
    public GameView() {
        setTitle("tic tac toe");

        panel.setLayout(new GridLayout(3, 3));
        try {
            img = new ImageIcon(ImageIO.read(new File("res/square.png")));
            x = new ImageIcon(ImageIO.read(new File("res/x.png")));
            o = new ImageIcon(ImageIO.read(new File("res/o.png")));
        } catch (Exception e) {
            System.out.println("failed reading image");
        }

        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = new JButton();
            buttons[i].setText(i+"");
            buttons[i].setIcon(img);

            panel.add(buttons[i]);
        }

        restartButton = new JButton("Play again");
        p2 = new JPanel(new FlowLayout());
        p2.add(label);

        p2.add(restartButton);

//        setContentPane(panel);
        add(panel);
        pack();
        setVisible(true);
        setResizable(false);
        setSize(550, 550);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public void startGameAgain() {
        for (int i = 0; i < buttons.length; i++) {
            buttons[i].setIcon(img);
        }
//        setContentPane(panel);
        panel.setVisible(true);

    }

    public void gameEndMenu(String winner){
       //panel.setVisible(false);
        panel.setVisible(false);
        label.setText(winner + " has Won!");

        add(p2);
//        setContentPane(p2);
    }

    public void addButtonListener(ActionListener listenForButtons) {
        for (int i = 0; i < buttons.length; i++) {
            buttons[i].addActionListener(listenForButtons);
        }
        restartButton.addActionListener(listenForButtons);
    }

    public void addMarker(int row, int column, String player) {
        JButton[][] buttonGrid = {
                {buttons[0], buttons[1], buttons[2]},
                {buttons[3], buttons[4], buttons[5]},
                {buttons[6], buttons[7], buttons[8]}
        };

        if (player.equals("X")) {
            buttonGrid[row][column].setIcon(x);
        } else {
            buttonGrid[row][column].setIcon(o);
        }


    }

}
