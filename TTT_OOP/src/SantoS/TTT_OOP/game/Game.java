package SantoS.TTT_OOP.game;

import javax.swing.*;

public class Game {
    private GameBoard board;
    private GamePlayer [] GamePlayers = new GamePlayer[2];
    private int playersTurn = 0;

    public Game(){
        this.board = new GameBoard(this);
    }

    public void initGame(){
        GamePlayers[0] = new GamePlayer(true,'X');
        GamePlayers[1] = new GamePlayer(false,'O');
    }

    void passTurn(){
        if(playersTurn == 0) playersTurn = 1;
        else playersTurn = 0;
    }

    GamePlayer getCurrentPlayer(){return  GamePlayers[playersTurn];}

    void showMessage(String textMessage){
        JOptionPane.showMessageDialog(board, textMessage);
    }
}
