import sun.jvm.hotspot.memory.SystemDictionary;
import java.time.Clock;
import java.time.Duration;

public class Timer
{


    private int UPPER_BOUND = 0;
    host minTime = new host();
    players player = new players();


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
            player.stealTurn();
        }

        else if(currTime < UPPER_BOUND)
        {
            startTimer();
            //recursively counts seconds
        }

    }






}