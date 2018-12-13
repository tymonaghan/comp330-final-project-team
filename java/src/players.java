import java.util.Queue;



public class players
{


    private int numPlayers;
    private int curPlayer;
    private int prevPlayer;
    private String answer;
    Queue players;


    public void players(int numPlayers)
    {
        this.numPlayers = numPlayers;
    }



    public void instantiatePlayers()
    {
            for(int i = 0; i < numPlayers; i++)
            {
                players.add("Player " + Integer.toString(i));
            }
    }


    public void sayAnswer(String answer)
    {
            this.answer = answer;
    }

    public String getAnswer()
    {
        return answer;
    }


    public void stealTurn()
    {
        //1.happens iff previous player gets answer incorrect 2.next player decides to steal the question

    }

    public void skipTurn()
    {
        //happens iff 1.previous player gets question wrong 2.next player both steals the question and gets it wrong

    }

    public void leaveGame()
    {
        //happens iff players drops below a predefined threshold of incorrect answered

    }






}