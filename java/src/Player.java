/*
Player.java is the class for players of the game. Each player has a name, a count of questions asked and answered, and a boolean to say whether they are human or not.
 */

import java.util.Scanner;

class Player
{
    private int questionsAttempted;
    private int questionsCorrect;
    private int roundsWon;
    private String playerName;
    private boolean isHuman;

    Player() {
        //construct human playerOne (same every time)
        isHuman = true;
        playerName = "Player Uno";
        questionsAttempted = 0;
        questionsCorrect=0;
        roundsWon = 0;
    }

    Player(int humanity){ //construct player two depending on 1 or 2-player game
        if (humanity==1){
            isHuman=false;
            playerName="Computadora (CPU)";
        } else {
            isHuman=true;
            playerName="Player Dos";
        }
        questionsAttempted = 0;
        questionsCorrect=0;
        roundsWon = 0;
    }

    String getPlayerName() {
        return playerName;
    }

    void promptForName(String num, Scanner scanner){
        System.out.println((char)27 + "[33mPlayer " + num + " please enter your name:" + (char)27 +"[0m");
        playerName=scanner.next();
    }

    void printScore(){
        System.out.println(playerName + "'s score: "+ questionsCorrect + " (out of " + questionsAttempted +" attempted)");
    }

    int getScore(){
        return questionsCorrect;
    }

    void addAttempt(){
        questionsAttempted++;
    }

    void addPoint(){
        questionsCorrect++;
    }

    void addRoundWin(){
        roundsWon++;
    }

    boolean getHumanity(){
        return isHuman;
    }

    void reset(){
        questionsAttempted=0;
        questionsCorrect=0;
    }

    int getRoundsWon(){
        return roundsWon;
    }
}