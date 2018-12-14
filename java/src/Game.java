import java.util.Scanner;

class Game {
    public Game() {
    } //end Game() constructor

    public void play(Host myHost, Scanner scanner, Player playerOne, Player playerTwo) {
        //create qf questionFile and start asking:
        QuestionFiles qf = new QuestionFiles("src/content/questions/" + myHost.getDifficulty());
        QuestionFiles af = new QuestionFiles("src/content/answers/answers.txt");
        if (myHost.getQuestionNumber() % 2 == 0) {
            myHost.askQuestion(qf, myHost.getQuestionNumber(), playerOne); // myHost asks the question on line number questionNumber
        } else {
            myHost.askQuestion(qf, myHost.getQuestionNumber(), playerTwo); // myHost asks the question on line number questionNumber
        }


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
    } // end Game.play()
} //end Game class