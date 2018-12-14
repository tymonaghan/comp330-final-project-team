/*
Player.java is the class for players of the game. Each player has a name, a count of questions asked and answered, and a boolean to say whether they are human or not.
 */

import java.util.Queue;

public class Player
{

    private int numPlayers;
    private int curPlayer;
    private int prevPlayer;
    private int questionsAttempted;
    private int questionsCorrect;
    private int roundsWon;
    private String playerName;
    private boolean isHuman;
    Queue players;


    public String getPlayerName() {
        return playerName;
    }

    public Player() //construct human playerOne (same every time)
    {
        isHuman = true;
        playerName = "Player Uno";
        questionsAttempted = 0;
        questionsCorrect=0;
        roundsWon = 0;
        //this.numPlayers = numPlayers;
    }
    public Player(int humanity){ //construct player two depending on 1 or 2-player game
        if (humanity==1){
            isHuman=false;
            playerName="computadora";
        } else {
            isHuman=true;
            playerName="Player Dos";
        }
        questionsAttempted = 0;
        questionsCorrect=0;
        roundsWon = 0;
    }

    void addPoint(){
        questionsCorrect++;
    }

    public void sayAnswer()
    {

    }

    public void stealTurn()
    {

    }

    public void skipTurn()
    {

    }

    public void leaveGame()
    {

    }






}