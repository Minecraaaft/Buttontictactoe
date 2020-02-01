import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller {
    Logic logic;
    GameView gameView;

    public Controller(Logic logic, GameView gameView) {
        this.logic = logic;
        this.gameView = gameView;
        gameView.addButtonListener(new TicTacToeListener());
    }

    public class TicTacToeListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            switch (e.getActionCommand()) {
                // e.getActionComman() returns the text on the button
                case "0":
                    if (logic.getMarker(0, 0).equals("")) {
                        gameView.addMarker(0, 0, logic.currentPlayer());
                        logic.addMarker(0, 0);
                    }
                    break;
                case "1":
                    if (logic.getMarker(0, 1).equals("")) {
                        gameView.addMarker(0, 1, logic.currentPlayer());
                        logic.addMarker(0, 1);
                    }
                    break;
                case "2":
                    if (logic.getMarker(0, 2).equals("")) {
                        gameView.addMarker(0, 2, logic.currentPlayer());
                        logic.addMarker(0, 2);
                    }
                    break;
                case "3":
                    if (logic.getMarker(1, 0).equals("")) {
                        gameView.addMarker(1, 0, logic.currentPlayer());
                        logic.addMarker(1, 0);
                    }
                    break;
                case "4":
                    if (logic.getMarker(1, 1).equals("")) {
                        gameView.addMarker(1, 1, logic.currentPlayer());
                        logic.addMarker(1, 1);
                    }
                    break;
                case "5":
                    if (logic.getMarker(1, 2).equals("")) {
                        gameView.addMarker(1, 2, logic.currentPlayer());
                        logic.addMarker(1, 2);
                    }
                    break;
                case "6":
                    if (logic.getMarker(2, 0).equals("")) {
                        gameView.addMarker(2, 0, logic.currentPlayer());
                        logic.addMarker(2, 0);
                    }
                    break;
                case "7":
                    if (logic.getMarker(2, 1).equals("")) {
                        gameView.addMarker(2, 1, logic.currentPlayer());
                        logic.addMarker(2, 1);
                    }
                    break;
                case "8":
                    if (logic.getMarker(2, 2).equals("")) {
                        gameView.addMarker(2, 2, logic.currentPlayer());
                        logic.addMarker(2, 2);
                    }
                    break;
            }

            if (logic.isGameOver()) {
                gameView.gameEndMenu(logic.getWinner());
                if (e.getActionCommand().equals("Play again")) {
                    logic.setGameOver(false);
                    logic.resetScore();

                    gameView.startGameAgain();
                }

            }

        }
    }

}
