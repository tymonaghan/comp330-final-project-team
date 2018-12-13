public class Host
{


    private String difficulty;
    private int time;
    private int level;
    private int questionNumber;

    public void incrementQuestionNumber() {
        this.questionNumber++;
    }

    public void resetQuestionNumber(){
        this.questionNumber=0;
    }

    public int getQuestionNumber() {
        return questionNumber;
    }



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

    public void explainDifficultyOptions(){
        System.out.println("\n\nTrivia-of-the-Union Difficulty Options:\n" +
                (char)27 + "[32mEasy" + (char)27 +"[0m provides 3 choices for each question and a generous timer. \n" +
                (char)27 + "[33mMedium" + (char)27 + "[0m provides 3 choices for each question and a short timer. \n" +
                (char)27 + "[31mHard" + (char)27 + "[0m requires users to type their answers (no multiple choice) and has a fast timer.");

    }

    public void askPlayerNumber(){
        //this currently has no effect on the game itself
        System.out.println("Select 1 or 2 players? (press 1 or 2 key)");
    }

    public void askQuestion(QuestionFiles qf, int lineNo){
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n"); //simulate clear console
        //hacky temporary way to show whether p1 or p2's turn - this currently isn't actually linked to anything in the Player class:
        if (this.getQuestionNumber()%2 == 0) {
            System.out.println("Player One, question #" + (this.getQuestionNumber() + 1) + " is for you:" + (char) 27 + "[33m");
        } else{
            System.out.println("Player Two, question #" + (this.getQuestionNumber() + 1) + " is for you:" + (char) 27 + "[33m");
        }
        qf.ReadFromFile(lineNo);
    }
    public void giveChoices(QuestionFiles choices, int lineNo){
        System.out.println((char)27 + "[0mSince level = easy, here are your choices:");
        String choicez = choices.ReadFromFile(lineNo);
    }

    public void playAgain()
    {
        //prompt second game
        System.out.println("Would you like to play again? Press 1 for yes, 2 to quit.");

    }

    public void evaluateQuestion(QuestionFiles af, int lineNo, QuestionFiles choices, int usersResponse) {
        System.out.println("\nyour response: " + usersResponse);
        //choices.ReadFromFile(lineNo); trying to use regex matching to print the actual WORD of the usersResponse, not the int (without switching everything over to HashMaps or something
        System.out.println("the correct answer is: " +(char)27 + "[32m");
        String answerLine = af.ReadFromFile(lineNo);

        //countdown to next question (should skip this when game is over):
        System.out.println((char)27 + "[0mNext question in");
        for (int i = 4; i > 0; i--) {
            System.out.print(i);
            for (int j = 0; j < 5; j++) {
                countdownToNextQuestion(j);
            }
        }
        //trying to get this regex matching business to work
        //final String regex = "(?<=(1. \"))[A-z]+(?=\")";
        //final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
        //final Matcher matcher = pattern.matcher(answerLine);
        //while(matcher.find()){
        //System.out.println(matcher.group(0));
    }
    private void countdownToNextQuestion(int i){
        try {
            Thread.sleep(i+200);
            System.out.print(" . ");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public void givePoint()
    {
        //assign point given correct answer
    }

    public void declareWinner()
    {
        //declare a winner given threshold is met
        System.out.println("\n\nThe game is over! I should declare a winner but I don't know how yet. It could even be a tie!");
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


    public void quitGame() {
        System.out.println("Thanks for playing! Goodbye.");
                System.exit(0);
    }
}