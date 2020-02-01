public class Logic {
    private String [] players = {"X", "O"};
    private int index = 0;
    private String[][] stage = {
            {"", "", ""},
            {"", "", ""},
            {"", "", ""},
    };
    private String winner;
    private boolean gameOver;

    public void addMarker(int row, int column) {
        if (stage[row][column].equals("") && !gameOver) {
            stage[row][column] = currentPlayer();
        }

        String[] line = new String[8];
        line[0] = stage[0][0] + stage[1][0] + stage[2][0];
        line[1] = stage[0][1] + stage[1][1] + stage[2][1];
        line[2] = stage[0][2] + stage[1][2] + stage[2][2];

        line[3] = stage[0][0] + stage[0][1] + stage[0][2];
        line[4] = stage[1][0] + stage[1][1] + stage[1][2];
        line[5] = stage[2][0] + stage[2][1] + stage[2][2];

        line[6] = stage[0][0] + stage[1][1] + stage[2][2];
        line[7] = stage[0][2] + stage[1][1] + stage[2][0];

        for (String l : line) {
            if (l.equals("XXX")) {
                winner = "X";
                gameOver = true;
            } else if (l.equals("OOO")) {
                winner = "O";
                gameOver = true;
            }
        }

        if (gameOver) {
            winner = currentPlayer();
        } else {
            index = ++index % players.length;
        }
    }

    public String getWinner() {
        return winner;
    }

    public String getMarker(int row, int column) {
        return stage[row][column];
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }

    public void resetScore() {
        stage = new String[][]{
                {"", "", ""},
                {"", "", ""},
                {"", "", ""},
        };
        index = 0;
    }

    public String currentPlayer() {
        return players[index];
    }
}