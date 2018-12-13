import java.util.Scanner;

public class Main {
    private int difficulty;
    public static void main(String[] args) {
        int questionNumber=0;
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
        if (ans == 4){
            System.out.println((char)27 + "[32mEasy" + (char)27 +"[0m provides 3 choices for each question and a generous timer. \n" +
                    (char)27 + "[33mMedium" + (char)27 + "[0m provides 3 choices for each question and a short timer. \n" +
                    (char)27 + "[31mHard" + (char)27 + "[0m requires users to type their answers (no multiple choice) and has a fast timer.");
            myHost.askDifficulty();
            scanner.nextLine();
            ans = scanner.nextInt();
        } else {}
        myHost.setDifficulty(ans); //set difficulty according to user response
        System.out.println("Difficulty set to " + myHost.getDifficulty().replace(".txt","")); //print back to user, omitting ".txt"

        myHost.askPlayerNumber(); //ask 1 or 2 players?
        scanner.nextLine();
        ans = scanner.nextInt();
        Players gamePlayers = new Players (ans); //instantiate gamePlayers with 1 or 2 numPlayers
        System.out.println("you selected " + gamePlayers.getNumPlayers() + " players"); //print back to user


        //experimental while-wrapper:
        while(questionNumber<9) {
            //create qf questionFile and start asking:
            QuestionFiles qf = new QuestionFiles("src/content/questions/" + myHost.getDifficulty());
            QuestionFiles af = new QuestionFiles("src/content/answers/" + myHost.getDifficulty());
            //int questionNumber=2; // replace this with the current round/turn # to cycle through questions in sequence
            myHost.askQuestion(qf, questionNumber); // myHost asks the question on line number questionNumber


            if (myHost.getLevel() == 0) { // if difficulty is easy, show 3x multiple choice options
                QuestionFiles choices = new QuestionFiles("src/content/easyChoices/choices.txt");
                myHost.giveChoices(choices, questionNumber);
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

                myHost.evaluateQuestion(af, questionNumber, choices, userResponse);
                questionNumber++;
            }
        }




        //accept and evaluate user response: HARD




    }
}


