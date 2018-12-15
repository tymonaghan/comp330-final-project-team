import java.util.Scanner;

class Game {
    String userResponseString;
    public Game() {
    } //end Game() constructor

    public void play(Host myHost, Scanner scanner, Player playerOne, Player playerTwo) {
        //read in question and answer files"
        QuestionFiles qf = new QuestionFiles("src/content/questions/" + myHost.getDifficulty());
        QuestionFiles af = new QuestionFiles("src/content/answers/answers.txt");
        //ask questions, alternating p1 and p2
        if (myHost.getQuestionNumber() % 2 == 0) {
            myHost.askQuestion(qf, myHost.getQuestionNumber(), playerOne); // myHost asks the question on line number questionNumber to playerOne
        } else {
            myHost.askQuestion(qf, myHost.getQuestionNumber(), playerTwo); // myHost asks the question on line number questionNumber to playerTwo
        }

        //gather and evaluate user responses -- EASY and MEDIUM mode:
        System.out.println(myHost.getLevel());
        if (myHost.getLevel() == 1 || myHost.getLevel()==2) { // if difficulty is EASY or MEDIUM, show 3x multiple choice options
            QuestionFiles choices = new QuestionFiles("src/content/easyChoices/choices.txt"); // read in the multiple choices for each question
            myHost.giveChoices(choices, myHost.getQuestionNumber()); //print choices to the user
            scanner.nextLine();
            int userResponse = scanner.nextInt(); //accept user input to answer question
            if (myHost.getQuestionNumber() % 2 == 0) {
                myHost.evaluateQuestion(af, choices, userResponse, playerOne); //evaluate user response (correct/incorrect)
            } else {
                myHost.evaluateQuestion(af, choices, userResponse, playerTwo); //evaluate user response (correct/incorrect)
            }
            myHost.incrementQuestionNumber(); // move to next question
        } //end if-easy block

        else if (myHost.getLevel()==3) { //if difficulty set to HARD, no multi-choice options.
            System.out.println("Type your answer and press ENTER");
            scanner.nextLine();
            this.userResponseString = scanner.next();
            if (myHost.getQuestionNumber() % 2 == 0) {
                myHost.evaluateQuestion(af, userResponseString, playerOne); //evaluate user response (correct/incorrect)
            } else {
                myHost.evaluateQuestion(af, userResponseString, playerTwo); //evaluate user response (correct/incorrect)
            }
        } //end if-hard difficulty block


        playerOne.printScore();
        playerTwo.printScore();
        myHost.countdownToNextQuestion();

        //add code for HARD mode

    } // end Game.play()
} //end Game class