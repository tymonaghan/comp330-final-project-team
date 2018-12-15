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

        //setup players
        myHost.askPlayerNumber(); //ask 1 or 2 players?
        int ans = scanner.nextInt();
        Player playerOne = new Player(); //instantiate gamePlayers with 1 or 2 numPlayers
        Player playerTwo = new Player(ans);
        numPlayers = (ans);
        System.out.println("you selected " + numPlayers + " players"); //print back to user
        playerOne.promptForName("One", scanner); //ask p1 for name
        if (playerTwo.getHumanity()){ // if p2 is human (2-player game selected) ask for their name as well
            playerTwo.promptForName("Two", scanner);
        }

        //set difficulty
        myHost.askDifficulty(); //ask user to select difficulty 1-3
        ans = scanner.nextInt(); //accept user's input as int
        //^^ i think i need to do a catch-type thing here since if the user enters not-an-int it crashes
        if (ans == 4) { //handle user pressing 4 to learn more about difficulty options
            myHost.explainDifficultyOptions();
            myHost.askDifficulty();
            scanner.nextLine();
            ans = scanner.nextInt();
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
            myHost.resetQuestionNumber(); // this doesn't work, exits with code 0 (even if it resets the number, triviaGame.run has come and gone by this point in main
        } else {
            myHost.quitGame(); //but this does work, shows message and then exits with code 0
        }
    }
}