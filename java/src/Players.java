import java.util.Queue;



public class Players
{


    private int numPlayers;
    private int curPlayer;
    private int prevPlayer;
    Queue players;


    public Players(int numPlayers)
    {
        this.numPlayers = numPlayers;
    }

    public int getNumPlayers() { return numPlayers; }

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