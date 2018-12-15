import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    //private int difficulty;
    public static void main(String[] args) {
        int questionLimit = 4;
        int numPlayers;

        // instantiate host, scanner
        Host myHost = new Host();
        Scanner scanner = new Scanner(System.in);

        //welcome message
        myHost.displayWelcome(); //welcome/intro message with game name, etc.

        //ask number of players and instantiate Player objects for them
        int ans=0;
        while (!(ans==1 | ans==2)){
            try{
                myHost.askPlayerNumber(); //ask 1 or 2 players?
                ans = scanner.nextInt();
            } catch (InputMismatchException e){
                System.out.println((char)27 + "[7mInvalid input; please enter a number 1-4" + (char)27 + "[27m");
            }
            scanner.nextLine(); // clear buffer
        }
        Player playerOne = new Player(); //instantiate gamePlayers with 1 or 2 numPlayers
        Player playerTwo = new Player(ans);
        numPlayers = (ans);
        System.out.println("you selected " + numPlayers + " players"); //print back to user
        playerOne.promptForName("One", scanner); //ask p1 for name
        if (playerTwo.getHumanity()){ // if p2 is human (2-player game selected) ask for their name as well
            playerTwo.promptForName("Two", scanner);
        }

        //set difficulty
        ans = 0;
        while (!(ans == 1 | ans == 2 | ans == 3 | ans ==4)) {
            try {
                myHost.askDifficulty(); //ask user to select difficulty 1-3
                ans = scanner.nextInt(); //accept user's input as int
            } catch (InputMismatchException e) {
                System.out.println((char)27 + "[7mInvalid input; please enter a number 1-4" + (char)27 + "[27m");
            }
            scanner.nextLine(); // clears the buffer
        }  //avoid wrong int inputs like 5, -1, etc. that would throw NullPointerExceptions

        if (ans == 4) { //handle user pressing 4 to learn more about difficulty options
            myHost.explainDifficultyOptions();
            while (!(ans == 1 | ans == 2 | ans == 3)) {  //avoid wrong int
                try {
                    myHost.askDifficulty(); //ask user to select difficulty 1-3
                    ans = scanner.nextInt(); //accept user's input as int
                } catch (InputMismatchException e) {
                    System.out.println((char) 27 + "[7mInvalid input; please enter a number 1-4" + (char) 27 + "[27m");
                }
                scanner.nextLine(); // clear buffer
            }
        }
        myHost.setDifficulty(ans); //set difficulty according to user response
        System.out.println("Difficulty set to " + myHost.getDifficulty().replace(".txt", "")); //print back to user, omitting ".txt"

        //instantiate new Game...
        Game triviaGame = new Game();
        //and play it until the questionLimit is reached.
        while (myHost.getQuestionNumber()<questionLimit) {
            triviaGame.play(myHost, scanner, playerOne, playerTwo);
        }

        //end-of-round functions, when questionLimit is reached
        myHost.declareWinner(); //announce the winner of the round
        myHost.playAgain(); //ask whether to play again
        scanner.nextLine();
        int userResponse = scanner.nextInt();
        if (userResponse == 1) { //if user wants to play again, reset questionNumber
            myHost.resetGame(playerOne, playerTwo); // this doesn't work, exits with code 0 (even if it resets the number, triviaGame.run has come and gone by this point in main
        } else {
            myHost.quitGame(); //but this does work, shows message and then exits with code 0
        }
    }
}