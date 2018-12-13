import java.util.Queue;



public class Player
{


    private int numPlayers;
    private int curPlayer;
    private int prevPlayer;
    Queue players;


    public Player(boolean isHuman)
    {
        //this.numPlayers = numPlayers;
    }


    public void instantiatePlayers()
    {
            for(int i = 0; i < numPlayers; i++)
            {
                players.add("Player " + Integer.toString(i));
            }
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