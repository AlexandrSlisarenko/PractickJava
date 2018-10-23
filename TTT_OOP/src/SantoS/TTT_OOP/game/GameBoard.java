package SantoS.TTT_OOP.game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameBoard extends JFrame{
    static int dimension = 3;
    static int cellSize = 150;
    private char[][] gameField;
    private GameButton [] gameButtons;
    private Game game;
    static char nullSymbol = '\u0000';
    private int [] coordinata = new int[2];

    GameButton getButton (int cell){return  gameButtons[cell];}
    public GameBoard(Game currentGame){
        this.game = currentGame;
        initField();
    }

    private void initField(){
        setBounds(cellSize*dimension, cellSize*dimension, 400, 400);
        setTitle("Крестики-нолики");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        setLayout(new BorderLayout());

        JPanel controlPanel = new JPanel(new BoxLayout(this, BoxLayout.Y_AXIS));
        JButton newGameButton = new JButton("Новая игра");
        newGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                emptyField();
            }
        });

        controlPanel.setLayout(new BoxLayout(controlPanel, BoxLayout.Y_AXIS));
        controlPanel.setSize(cellSize*dimension, cellSize);
        controlPanel.add(newGameButton);
        JPanel gameFieldPanel = new JPanel(new GridLayout(dimension,dimension));
        gameFieldPanel.setSize(cellSize*dimension,cellSize*dimension);

        gameField = new char [dimension][dimension];
        gameButtons = new GameButton[dimension * dimension];

        for (int i = 0; i < (dimension * dimension); i++) {
            GameButton  gameButton = new GameButton(i, this);
            gameFieldPanel.add(gameButton);
            gameButtons[i] = gameButton;
        }

        getContentPane().add(controlPanel,BorderLayout.NORTH);
        getContentPane().add(gameFieldPanel,BorderLayout.CENTER);
        setVisible(true);

    }
    void emptyField(){
        for (int i = 0; i < GameBoard.dimension * GameBoard.dimension; i++ ){
            gameButtons[i].setText("");

            int x = i / GameBoard.dimension;
            int y = i % GameBoard.dimension;

            gameField[x][y] = nullSymbol;
        }
    }

    Game getGame(){return game;}

    boolean isTurnable(int x, int y){
        boolean result = false;

        if(gameField[x][y] == nullSymbol) result = true;

        return result;
    }

    void updateGameField(int x, int y){
        gameField[x][y] = game.getCurrentPlayer().getPlayerSing();
    }
    //получение координат из одномерного массива
    void getCoordinat(int i){

        coordinata[0] = i / GameBoard.dimension;
        coordinata[1] = i % GameBoard.dimension;
    }

    boolean findWinDiagonal(int i, int ink){
        boolean res = false;
        i +=ink;
        getCoordinat(i);
        if(gameField[coordinata[0]][coordinata[1]] == game.getCurrentPlayer().getPlayerSing()){
            i +=ink;
            getCoordinat(i);
            if(gameField[coordinata[0]][coordinata[1]] == game.getCurrentPlayer().getPlayerSing()){
                res = true;
            }
        }
        return res;
    }

    boolean checkWin(){
        boolean result = false;

        for (int i = 0;i < gameField.length;i++)
        {
            getCoordinat(i);
            if(gameField[coordinata[0]][coordinata[1]] == game.getCurrentPlayer().getPlayerSing()){
                switch (i){
                    case 0:
                        if(findWinDiagonal(i,1)){
                            result = true;
                            i = gameField.length;
                            break;
                        }
                        if(findWinDiagonal(i,3)){
                            result = true;
                            i = gameField.length;
                            break;
                        }
                        if(findWinDiagonal(i,4)){
                            result = true;
                            i = gameField.length;
                            break;
                        }
                        break;
                    case 1:
                        if(findWinDiagonal(i,3)){
                            result = true;
                            i = gameField.length;
                            break;
                        }
                        break;
                    case 2:
                        if(findWinDiagonal(i,2)){
                            result = true;
                            i = gameField.length;
                            break;
                        }
                        if(findWinDiagonal(i,3)){
                            result = true;
                            i = gameField.length;
                            break;
                        }
                        break;
                    case 6:
                        if(findWinDiagonal(i,1)){
                            result = true;
                            i = gameField.length;
                            break;
                        }
                        break;
                }
            }
        }

        return result;
    }
    boolean isFull(){
        boolean result = true;
        for(int i = 0;i<gameField.length;i++){
            for(int j = 0;j<gameField.length;j++){
                if(gameField[i][j] == nullSymbol) result = false;
            }
        }
        return result;
    }
}
