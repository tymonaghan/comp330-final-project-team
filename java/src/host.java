public class host
{

    private String difficulty;
    private int time;
    private int level;


    public void displayIntro()
    {
        //enter intro here
        System.out.println("Please Select a difficulty");
        System.out.println("1: easy");
        System.out.println("2: medium");
        System.out.println("3: hard");
    }



    public void playAgain()
    {
        //prompt second game

    }

    public void evaluateQuestion()
    {
        //evaluate question


    }

    public void givePoint()
    {
        //assign point given correct answer
    }

    public void declareWinner()
    {
        //declare a winner given threshold is met
        System.out.println("Would you like to play again(Y/N)");
    }

    public void setDifficulty(int level)
    {
        if(level == 1)
        {
            difficulty = "easy.txt";
            time = 100000;
        }
        else if(level == 2)
        {
            difficulty = "medium.txt";
            time = 30000;
        }
        else if(level == 3)
        {
            difficulty = "hard.txt";
            time = 30000;

        }
    }

    public String getDifficulty()
    {
        return difficulty;
    }

    public int getTime()
    {
        return time;
    }






}