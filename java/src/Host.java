/*
If Trivia of the Union were a game show, Host.java would be the host. Welcomes contestants, gathers names and other preferences, asks the questions, declares a winner, and says goodbye when the game is over.
 */

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Host
{
    private String difficulty;
    private int time;
    private int level;
    private int questionNumber;
    private String userMatchedAnswer;

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
        //user's response controls how playerTwo is instantiated
        System.out.println("Select 1 or 2 players? (press 1 or 2 key)");
    }

    public void askQuestion(QuestionFiles qf, int lineNo, Player player){
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n"); //simulate clear console
        System.out.println(player.getPlayerName() + ", question #" + (this.getQuestionNumber() + 1) + " is for you:" + (char) 27 + "[33m");
        String question=qf.ReadFromFile(lineNo);
        System.out.println(question);
    }
    public void giveChoices(QuestionFiles choices, int lineNo){
        String choicez = choices.ReadFromFile(lineNo);
        System.out.println((char)27+"[0m" + choicez.replaceAll("\\*","\n"));
    }

    public void evaluateQuestion(QuestionFiles af, int lineNo, QuestionFiles choices, int usersResponse) {
        String answerLine = af.ReadFromFile(lineNo);
        String choiceLine = choices.ReadFromFile(lineNo);
        final String regex ="(?<="+usersResponse+". )[^,\\n]+(?=[,\\n])";
        final Pattern regexPattern = Pattern.compile(regex);
        final Matcher matcher = regexPattern.matcher(choiceLine);

        while (matcher.find()) {
            this.userMatchedAnswer=matcher.group(0);
        }

        /*
            System.out.println("Full match: " + matcher.group(0));
            for (int i = 1; i <= matcher.groupCount(); i++) {
                System.out.println("Group " + i + ": " + matcher.group(i));
            }
*/

        System.out.println("\nyour response: " + userMatchedAnswer);

        System.out.println("the correct answer is: " +(char)27 + "[32m");
        System.out.print(answerLine);

        //countdown to next question (should skip this when game is over):
        System.out.println((char)27 + "[0m\nNext question in");
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

    public void playAgain()
    {
        //prompt second game
        System.out.println("Would you like to play again? Press 1 for yes, 2 to quit.");

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