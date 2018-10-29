# COMP-330-final-project-team: Requirements

## Project team
- Abdur Khan
- Ivan Kavanagh
- Neal McMahon
- Keyti Toromanova
- Tyler Monaghan

## Overview
"Trivia of the Union" is a trivia quiz game. It uses the corpus of US Presidents' "State of the Union" addresses collected by the [SOTU-db project](http://gitpages.sotu-db.com) to generate questions. Two players compete to see who can answer the most correct questions in a round. Language-processing tools like text mining with R and the NLTK (natural language toolkit) Python library will be used to programmatically generate questions (for example, "which President had the longest average sentences").
## Implementation Objectives
#### Key Objectives:
- To complete the project using an object oriented approach
- To follow Programmatic philosophies SoC and loose coupling
- Create a dynamic system that will be able to change itself at runtime
- Achieve a greater understanding of turn based systems and how Actors should interact

#### Program Requirements:
- Program must be built using java or a java-based framework
-	Program must terminate gracefully
-	Program must have clear parameter indicating when termination is necessary
-	Program must consider all possible outcomes A winner, A loser, A tie
-	Program must hold the user to a set of rules
-	Program must handle breaking of rules gracefully

#### Data Requirements:
-	Program must keep a reference to every instance of user input
-	User input must be archived to eliminate redundancy
-	User input must be of a valid type
-	System must be able to handle multiple data sets


## Functional Requirements

### Minimum Requirements:
*"Minimum requirements" refer to requirements that must be included in order for the software to be considered a "minimum viable product" (must-haves)*

1. **Two simultaneous head-to-head players:** the system should allow two players to compete simultaneously in the game.

2. **Indicate player turn:** by default, player 1 answers the first question, and play alternates with each question. After five questions for each player, the round is over (see requirement 8).

3. **Display trivia questions:** the system should randomly choose a trivia question to display to the players.
> 3a. optionally, the system should choose the trivia question based on the chosen difficulty level of the game (see requirement 10)

4. **Accept user input/answer selection:** Once the question is displayed, the system should prompt the user to input their response. *(We should choose an answer method from 4a-4c below, or make clear which will be used under what conditions)*
>4a. the software displays a list of possible "multiple choice" responses along with the question. The player who buzzes in selects from these responses.
>4b. the software displays a list of possible "multiple choice" responses only after a user has buzzed in. The user then selects from these responses.
>4c. the software accepts a typed String as input from the user.

5. **Check user answer:** once a player has responded to the question, the software performs a check *(specific method will depend on implementation of requirement 4)* to determine whether the player's response was correct.

6. **Assign points:** if the player's answer is deemed correct, points are added to that player's score.
>tbd: are different questions worth different amounts of points?

7. **Alternate player turns:** once a player has answered their question, the system should indicate that it is now the opposite player's turn.

8. **Indicate end of round and award winner:** after each player has answered five questions, the game will print a message that the round has ended and indicate the winner of the round.

9. **Prompt for rematch/end of game:** after a round has ended and a winner is declared, the software should provide users with the option to "rematch" (start a new game) or "exit" (terminate the software)
>9a. if user aliases are implemented, another option could be to start a new game with different players (instead of the same two players, as in the case of a rematch)


### Preferred Requirements:
*"Preferred requirements" refer to requirements that may or may not be implemented in the final code, and are not required to reach "minimum viable product," but are nevertheless desirable (should-haves)*
10. **Selectable difficulty level:** players can choose from multiple difficulty levels which will change which questions are asked in the game.

11. **Listen for users to "buzz in:"** rather than simply alternating users, the software could listen for keypresses and allow users to "buzz in" to see who can answer the question more quickly (similar to Jeopardy!)

12. **Deduct points for incorrect responses:** the software will remove points from the player's score if the player provides an incorrect answer.

13. **Allow a player to steal:** when a player answers a question incorrectly (or timer expires, if requirement 14 is implemented), the game gives the other player the option to "steal" those points by correctly answering the question.

14. **Question timer:** players will have a limited time (indicated on-screen) in which to answer the question. If time expires before the player responds, it counts as an incorrect answer.

14. **Allow player aliases:** collect usernames from each player and refer to them by these, rather than just "player 1" and "player 2"

15. **Display scoreboard:** the users' names and current scores should be displayed on the screen at all times

16. **Use natural-language processing to generate trivia questions:** the trivia questions in the software's database will be based on the corpus of "State of the Union" texts compiled by the "SOTU-db" project

## Tools Used
- **[Python, NLTK library:](https://www.nltk.org/)** natural language processing of texts
- **R, RStudio (IDE), tm, tidyverse packages** natural language processing of texts
- **GitHub** version control
- **BaseCamp** team communication
