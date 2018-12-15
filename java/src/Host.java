/*
If Trivia of the Union were a game show, Host.java would be the host. Welcomes contestants, gathers names and other preferences, asks the questions, declares a winner, and says goodbye when the game is over.
 */

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.Thread.sleep;

public class Host
{
    private String difficulty;
    private String regex;
    private int time;
    private int level;
    private int questionNumber;
    private int rightAnswer;
    private String userMatchedAnswer;

    public void incrementQuestionNumber(){
        //increment questionNumber to control game flow
        this.questionNumber++;
    }

    public int getQuestionNumber(){
        //questionNumber getter function
        return questionNumber;
    }

    public void displayWelcome(){
        //welcome the users, introduce game, set console size
        String banner=
                "_______     _         _                  __   _    _             _    _         _\n" +
                "|__   __|   (_)       (_)                / _| | |  | |           | |  | |       (_)              \n" +
                "   | | _ __  _ __   __ _   __ _    ___  | |_  | |_ | |__    ___  | |  | | _ __   _   ___   _ __\n" +
                "   | || '__|| |\\ \\ / /| | / _` |  / _ \\ |  _| | __|| '_ \\  / _ \\ | |  | || '_ \\ | | / _ \\ | '_ \\\n" +
                "   | || |   | | \\ V / | || (_| | | (_) || |   | |_ | | | ||  __/ | |__| || | | || || (_) || | | |\n" +
                "   |_||_|   |_|  \\_/  |_| \\__,_|  \\___/ |_|    \\__||_| |_| \\___|  \\____/ |_| |_||_| \\___/ |_| |_|\n";

        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n"); //simulate clear console
        System.out.println((char)27 + "[7m "+ banner);
        System.out.println((char)27 + "[27mWelcome to 'Trivia of the Union,' the State of the Union quiz game.");
        System.out.println("Questions cover US Presidents' State of the Union Addresses from 1981-2017.");
        System.out.println("For the best experience, please adjust the size of your console so that the ascii art above displays fully.\n");
    }

    public void askPlayerNumber(){
        //user's response controls how playerTwo is instantiated
        System.out.println((char)27 + "[33mSelect 1 or 2 players? (press 1 or 2 key)" + (char)27 + "[0m");
    }

    public void askDifficulty(){
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

    public void askQuestion(QuestionFiles qf, int lineNo, Player player){
        //display the question to the user
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n"); //simulate clear console
        System.out.println(player.getPlayerName() + ", question #" + (this.getQuestionNumber() + 1) + " is for you:" + (char) 27 + "[33m");
        String question=qf.ReadFromFile(lineNo);
        System.out.println(question);
    }

    public void giveChoices(QuestionFiles choices, int lineNo){
        //give player multiple choices (for easy + medium difficulty only)
        String choicez = choices.ReadFromFile(lineNo); //read the line in choices file that corresponds to the question
        System.out.println((char)27+"[0m" + choicez.replaceAll("\\*","\n")); //print out the options, each on their own line
    }

    public void evaluateQuestion(QuestionFiles af, QuestionFiles choices, int usersResponse, Player activePlayer) {
        //for EASY and MEDIUM modes only - assesses multiple choice responses:

        //read in passed answers/choices
        String answerLine = af.ReadFromFile(this.questionNumber); //read in the answer
        String choiceLine = choices.ReadFromFile(this.questionNumber); // read in the user's choice

        //print back the user's selection/answer:
        if (usersResponse !=3){
            this.regex = "(?<=" + usersResponse + "\\. )[^,\\n]+(?=[,$])"; //regex for user responses 1-2
            //RegExplanation: positive lookbehind for "1. " or "2. " depending on user's choice, then match until comma or end of line
        } else if (usersResponse==3){
            this.regex= "(?<=3\\. ).+$"; //regex for user response 3 (not sure why one didn't work for all, possibly the way different EOL tokens are used in the 1-2 regex)
            //RegExplanation: positive lookbehind for "3. ", then match any character as many times as possible until end-of-line
        }
        final Pattern regexPattern = Pattern.compile(regex, Pattern.MULTILINE); // compile regex into pattern
        final Matcher matcher = regexPattern.matcher(choiceLine); //run the regex over the choiceLine
        while (matcher.find()) {
            this.userMatchedAnswer=matcher.group(0); //store users answer to userMatchesAnswer
        }
        System.out.println("\nyour response: \n" + (char)27 + "[33m" + userMatchedAnswer); //print back the user's answer

        //print the correct answer:
        System.out.println((char)27 + "[0mthe correct answer is: " +(char)27 + "[33m");
        System.out.println(answerLine + (char)27 + "[0m\n");

        try { //a short delay after showing the correct answer avoids a sudden flood of text faster than the user can read.
            sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //assess whether correct or incorrect:
        activePlayer.addAttempt();
        rightAnswer = Integer.parseInt(answerLine.substring(0, 1));
        if(rightAnswer == usersResponse){ //if correct, tell the user and award a point
            System.out.println((char)27 + "[032mYou are correct! One point for you.");
            activePlayer.addPoint();
        } else{ //if incorrect, tell the user and award no point
            System.out.println((char)27 + "[031mYour answer was incorrect. I award you no points, and may god have mercy on your soul.");
        }
        System.out.println((char)27 + "[0m");
    } //end evaluateQuestion EASY/MEDIUM mode

    // for HARD mode only - assesses string response
    public void evaluateQuestion(QuestionFiles af, String userResponse, Player activePlayer, QuestionFiles answerMatches){
        //read in answers and choices:
        String answerMatchString = answerMatches.ReadFromFile(this.questionNumber);
        String answerLine = af.ReadFromFile(this.questionNumber); //read in the answer

        //echo back the user's response:
        System.out.println(activePlayer.getPlayerName() + ", you answered: " + userResponse);

        //build regex matcher:
        this.regex=".?" + userResponse + ".?"; //regular expression built from user's response
        final Pattern regexPattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE); //compile into case-insensitive pattern
        final Matcher matcher = regexPattern.matcher(answerMatchString);  //build matcher from running regex pattern over answerMatchString (simplified answers file)

        //print correct answer
        System.out.println((char)27 + "[0mthe correct answer is: " +(char)27 + "[33m"); // print the correct answer
        System.out.println(answerLine);

        try { //a short delay after showing the correct answer avoids a sudden flood of text faster than the user can read.
            sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //assess response as correct/incorrect:
        if (matcher.find()){ //if user's response is a match (correct), let them know and award a point:
            System.out.println((char)27 + "[032mYou are correct! One point for you.");
            activePlayer.addPoint();
        } else { //if the user's response is incorrect, let them know and award no point
            System.out.println((char)27 + "[031mYour answer was incorrect. I award you no points, and may god have mercy on your soul.");
        }
        System.out.println((char)27 + "[0m"); //reset console color
        activePlayer.addAttempt(); //record an attempt, whether right or wrong.
    } //end evaluateQuestion HARD mode


    public void countdownToNextQuestion(){
        //countdown to next question (should skip this when game is over):
        System.out.println((char)27 + "[0m\n\nNext question in");
        //this nested for-loop simply counts down from 4-0 until the next question by calling countdownToNextQuestion
        for (int i = 4; i > 0; i--) {
            System.out.print(i);
            for (int j = 0; j < 5; j++) {
                try {
                    sleep(200);
                    System.out.print(" . ");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void declareWinner(Player playerOne, Player playerTwo){
        //declare a winner given threshold is met
        System.out.println("The game is over! Final score:");
        playerOne.printScore();
        playerTwo.printScore();
        if (playerOne.getScore() > playerTwo.getScore()){ //playerOne wins:
            System.out.println((char)27 + "[32m" + playerOne.getPlayerName() + " wins!");
        } else if (playerOne.getScore() < playerTwo.getScore()){ //playerTwo wins:
            System.out.println((char)27 + "[32m" + playerTwo.getPlayerName() + " wins!");
        } else { //a tie:
            System.out.println("Tie game!");
        }
    }//end declareWinner

    public void playAgain()
    {
        //prompt second game
        System.out.println("Would you like to play again? Press 1 for yes, or 2 to quit.");
    }

    public void setDifficulty(int level)
    {
        if(level == 1)
        {
            this.level=1;
            difficulty = "easy.txt";
            time = 100000;
        }
        else if(level == 2)
        {
            this.level=2;
            difficulty = "medium.txt";
            time = 30000;
        }
        else if(level == 3)
        {
            this.level=3;
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

    public void resetGame(Player playerOne, Player playerTwo){
        this.questionNumber=0;
        playerOne.reset();
        playerTwo.reset();
    }

    public void quitGame() {
        System.out.println("Thanks for playing! Goodbye.");
                System.exit(0);
    }
}