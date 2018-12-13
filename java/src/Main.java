import java.util.Scanner;

public class Main {

    //private int difficulty;
    public static void main(String[] args) {
        int questionLimit = 4;
        int numPlayers;

        /* print working path:
        Path currentRelativePath = Paths.get("");
        String s = currentRelativePath.toAbsolutePath().toString();
        System.out.println("Current path is: " + s);
        */

        // instantiate host, scanner
        Host myHost = new Host();
        Scanner scanner = new Scanner(System.in);

        //interactive setup tasks:
        myHost.displayWelcome(); //welcome/intro message with game name, etc.
        myHost.askDifficulty(); //ask user to select difficulty 1-3
        int ans = scanner.nextInt(); //accept user's input as int
        if (ans == 4){ //handle user pressing 4 to learn more about difficulty options
            myHost.explainDifficultyOptions();
            myHost.askDifficulty();
            scanner.nextLine();
            ans = scanner.nextInt();
        }
        myHost.setDifficulty(ans); //set difficulty according to user response
        System.out.println("Difficulty set to " + myHost.getDifficulty().replace(".txt","")); //print back to user, omitting ".txt"

        myHost.askPlayerNumber(); //ask 1 or 2 players?
        scanner.nextLine();
        ans = scanner.nextInt();
        Player playerOne = new Player (true); //instantiate gamePlayers with 1 or 2 numPlayers
        if (ans == 1){ //if 1-player game, playerTwo is not human (false)
            Player playerTwo = new Player(false);
        }else if (ans ==2){ //if it's a 2-player game, playerTwo is human (true)
            Player playerTwo = new Player(true);
        }
        numPlayers=(ans);
        System.out.println("you selected " + numPlayers + " players"); //print back to user

        //while there are still questions left to ask, ask them in sequence:
        while(myHost.getQuestionNumber()<questionLimit) {
            //create qf questionFile and start asking:
            QuestionFiles qf = new QuestionFiles("src/content/questions/" + myHost.getDifficulty());
            QuestionFiles af = new QuestionFiles("src/content/answers/" + myHost.getDifficulty());
            myHost.askQuestion(qf, myHost.getQuestionNumber()); // myHost asks the question on line number questionNumber


            if (myHost.getLevel() == 0) { // if difficulty is easy, show 3x multiple choice options
                QuestionFiles choices = new QuestionFiles("src/content/easyChoices/choices.txt");
                myHost.giveChoices(choices, myHost.getQuestionNumber());
                //accept and evaluate user response: EASY and MEDIUM
                scanner.nextLine();
                int userResponse = scanner.nextInt();

            /*
            //trying to return the string that follows the user's selected # with regex, but having trouble
            String filePath = "src/content/easyChoices/choices.txt";
            File choicesFile = new File(filePath);
            Scanner answerPickerOuter = null;
            try {
                answerPickerOuter = new Scanner(choicesFile);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            final String regex1 = System.lineSeparator();
            final String regex = "[0-9]";
            answerPickerOuter.useDelimiter(regex1);
            System.out.println(answerPickerOuter.next());
            answerPickerOuter.close();
            */

                myHost.evaluateQuestion(af, myHost.getQuestionNumber(), choices, userResponse);
                myHost.incrementQuestionNumber();
            } //end if-easy block
        } // end while(questionNumber < questionLimit) loop

        //handle end-of-game (not working yet)
        while (myHost.getQuestionNumber() == questionLimit) {
            myHost.declareWinner();
            myHost.playAgain();
            //scanner.nextLine();
            int userResponse = scanner.nextInt();
            if (userResponse == 1) { //if user wants to play again, reset questionNumber
                myHost.resetQuestionNumber(); // this doesn't work, exits with code 0
            } else {
                myHost.quitGame(); //but this does work, shows message and then exits with code 0
            }
        } // end while-loop for questionLimit reached (questionNum == questionLimit)

        //accept and evaluate user response: HARD

    }
}


