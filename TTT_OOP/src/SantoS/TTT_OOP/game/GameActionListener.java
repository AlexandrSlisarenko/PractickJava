package SantoS.TTT_OOP.game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class GameActionListener implements ActionListener {
    private int row;
    private int cell;
    private GameButton button;


    public GameActionListener(int row, int cell, GameButton gButton){
        this.button = gButton;
        this.cell = cell;
        this.row = row;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       GameBoard board = button.getGameBoard();

       if(board.isTurnable(row,cell)){
            updateByPlayersData(board);
            if(board.isFull()){
                board.getGame().showMessage("Ничья!");
                board.emptyField();
            }
            else {
                updateByAIData(board);
            }
       }else{
           board.getGame().showMessage("Не корректный ход");
       }

    }

    private void updateByAIData(GameBoard board) {
        int x,y;
        Random ran = new Random();
        do{
            x = ran.nextInt(GameBoard.dimension);
            y = ran.nextInt(GameBoard.dimension);
        }
        while(!board.isTurnable(x,y));

        board.updateGameField(x,y);
        int callIndex = GameBoard.dimension * x * y;
        board.getButton(callIndex).setText(Character.toString(board.getGame().getCurrentPlayer().getPlayerSing()));
        //button.setText(Character.toString(board.getGame().getCurrentPlayer().getPlayerSing()));
        if(board.checkWin()){
            board.getGame().showMessage("Победили "+board.getGame().getCurrentPlayer().getPlayerSing()+"!!!  Ура");
            board.emptyField();
        }else{
            board.getGame().passTurn();
        }
    }

    private void updateByPlayersData(GameBoard board) {
        board.updateGameField(row,cell);
        //button.setText(Character.toString(board.getGame().getCurrentPlayer().getPlayerSing()));

        if(board.checkWin()){
            board.getGame().showMessage("Победили "+board.getGame().getCurrentPlayer().getPlayerSing()+"!!!  Ура");
            board.emptyField();
        }else{
            board.getGame().passTurn();
        }
    }
}
