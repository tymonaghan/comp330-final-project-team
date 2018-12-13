public class host
{

    private String difficulty;
    private int time;
    private int level;
    private int threshold;


    public void displayIntro()
    {
        //enter intro here
        System.out.println("\n\n\n\n\n\n\n\n\n\n\nWelcome to 'Trivia of the Union,' the State of the Union quiz game.");
        System.out.println("Questions will cover State of the Union Addresses from 1981-2017.");
        System.out.println("\nPlease Select a difficulty");
        System.out.println("1: easy");
        System.out.println("2: medium");
        System.out.println("3: hard");
    }

    public void askQuestion(QuestionFiles qf, int lineNo){
        System.out.println("Player X, here is your question:");
        qf.ReadFromFile(lineNo);
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
            threshold = 7;
        }
        else if(level == 2)
        {
            difficulty = "medium.txt";
            time = 30000;
            threshold = 5;
        }
        else if(level == 3)
        {
            difficulty = "hard.txt";
            time = 30000;
            threshold = 3;
        }
    }

    public String getLevel()
    {

        return difficulty;
    }


    public int getthreshold()
    {
        return threshold;
    }

    public int getTime()
    {
        return time;
    }






}