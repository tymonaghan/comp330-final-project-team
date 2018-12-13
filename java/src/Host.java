public class Host
{

    private String difficulty;
    private int time;
    private int level;


    public void displayWelcome(){
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n"); //simulate clear console
        System.out.println("Welcome to 'Trivia of the Union,' the State of the Union quiz game.");
        System.out.println("Questions will cover State of the Union Addresses from 1981-2017.");
    }
    public void askDifficulty()
    {

        System.out.println("\nPlease Select a difficulty");
        System.out.println((char)27 + "[32m1: easy");
        System.out.println((char)27 + "[33m2: medium");
        System.out.println((char)27 + "[31m3: hard" + (char)27 + "[0m");
        System.out.println("4: Explain the difficulty options");
    }

    public void askPlayerNumber(){
        System.out.println("Select 1 or 2 players? (press 1 or 2 key)");
    }

    public void askQuestion(QuestionFiles qf, int lineNo){
        System.out.println("Player X, here is your question:");
        qf.ReadFromFile(lineNo);
    }
    public void giveChoices(QuestionFiles choices, int lineNo){
        System.out.println("Since level = easy, here are your choices:");
        String choicez = choices.ReadFromFile(lineNo);
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

    public int getLevel() { return level; }



}