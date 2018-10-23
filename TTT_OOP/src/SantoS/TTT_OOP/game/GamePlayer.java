package SantoS.TTT_OOP.game;

public class GamePlayer {
    private char playerSing;
    private boolean realPlayer;

    public GamePlayer(boolean isRealPlayer, char playerSing){
        this.playerSing = playerSing;
        this.realPlayer = isRealPlayer;

    }

    public boolean getRealPlayer(){
        return this.realPlayer;
    }
    public char getPlayerSing(){
        return this.playerSing;
    }
}
