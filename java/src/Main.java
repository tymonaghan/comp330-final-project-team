import java.util.Scanner;

public class Main {

    //private int difficulty;
    public static void main(String[] args) {
        int questionsAsked=0;
        int questionLimit = 4;
        int numPlayers;
        int gameState = 0;

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

        //set difficulty
        myHost.askDifficulty(); //ask user to select difficulty 1-3
        ans = scanner.nextInt(); //accept user's input as int
        if (ans == 4) { //handle user pressing 4 to learn more about difficulty options
            myHost.explainDifficultyOptions();
            myHost.askDifficulty();
            scanner.nextLine();
            ans = scanner.nextInt();
        }
        myHost.setDifficulty(ans); //set difficulty according to user response
        System.out.println("Difficulty set to " + myHost.getDifficulty().replace(".txt", "")); //print back to user, omitting ".txt"

        //instantiate new Game and play it:
        Game triviaGame = new Game();
        while (questionsAsked<questionLimit) {
            triviaGame.play(myHost, scanner, playerOne, playerTwo);
            questionsAsked++;
        }

        myHost.declareWinner();
        myHost.playAgain();
        //scanner.nextLine();
        int userResponse = scanner.nextInt();
        if (userResponse == 1) { //if user wants to play again, reset questionNumber
            myHost.resetQuestionNumber(); // this doesn't work, exits with code 0
        } else {
            myHost.quitGame(); //but this does work, shows message and then exits with code 0
        }

    }
}


