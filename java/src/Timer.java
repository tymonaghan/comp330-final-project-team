/* this class not used (yet)
public class Timer

{

    private int UPPER_BOUND = 0;
    Host minTime = new Host();
    private long currTime;

    public void setUpperBound()
    {
        UPPER_BOUND = minTime.getTime();
    }

    public void startTimer()
    {
        this.currTime = System.currentTimeMillis();
        if(currTime > UPPER_BOUND)
        {
            //player.stealTurn();
        }

        else if(currTime < UPPER_BOUND)
        {
            startTimer();
            //recursively counts seconds
        }
    }
}
 */