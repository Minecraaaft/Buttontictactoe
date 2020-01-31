import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.File;

public class GameView extends JFrame{
    private JButton buttons[] = new JButton[9];
    private ImageIcon img, x, o;

    public GameView() {
        setTitle("tic tac toe");
        JPanel panel = new JPanel();
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

        add(panel);
        pack();
        setVisible(true);
        setResizable(false);
        setSize(600, 600);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public void gameEndMenu() {
        setVisible(true);

    }

    public void addButton(ActionListener listenForButtons) {
        for (int i = 0; i < buttons.length; i++) {
            buttons[i].addActionListener(listenForButtons);
        }
    }

    public void addMarker(int row, int column, String player) {
        JButton[][] buttonGrid = {
                {buttons[0], buttons[1], buttons[2]},
                {buttons[3], buttons[4], buttons[5]},
                {buttons[6], buttons[7], buttons[8]}
        };

        if (player.equals("x")) {
            buttonGrid[row][column].setIcon(x);
        } else {
            buttonGrid[row][column].setIcon(o);
        }


    }

}
