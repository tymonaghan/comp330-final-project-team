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
*"Minimum requirements" refer to requirements that must be included in order for the software to be considered a "minimum viable product" (must-haves)*

**1. Two simultaneous head-to-head players:** the system should allow two players to compete simultaneously in the game, taking alternating turns answering trivia questions.

**2. Gather player names:** the system should prompt users to enter their names. Users can enter a string with their device's keyboard, and the game will refer to the player by name in messages for the remainder of the game.

**3. Gather difficulty level:** the system should prompt users to select EASY, MEDIUM, or HARD difficulty.

**4. Indicate player turn:** the system must display to users whether it is currently player 1 or player 2's turn. By default, player 1 answers the first question, and play alternates with each question. After five questions for each player, the round is over (see requirement 8).

**5. Display trivia questions:** On each turn, the system should randomly choose a trivia question to display to the player whose turn is currently being taken.

**6. Display multiple choice options:** After asking the question, display three possible choices to the user (note: does not apply to HARD difficulty).

**7. Question timer:** players will have a limited time (indicated on-screen) in which to answer the question. If time expires before the player responds, it counts as an incorrect answer.

**8. Accept user input/answer selection:** Once the question is displayed, the system should prompt the user to input their response.
>**8a.** on "EASY" and "MEDIUM" difficulty, the software displays a list of possible "multiple choice" responses along with the question. The user presses key 1, 2, or 3 to select the corresponding answer displayed on screen. <br>
>**8b.** on "HARD" difficulty, the software accepts a typed String as input from the user.

**9. Check user answer:** once a player has responded to the question, the software performs a check to determine whether the player's response was correct. The system will display a message indicating whether the user's response is correct or incorrect.
>**9a.** on EASY and MEDIUM difficulty, regular expressions are used to match the user's input (1, 2, or 3) to the first character of an "answers.txt" file
>**9b.** on HARD difficulty, regular expressions are used to determine whether the user's string appears in the line of a "hardstrings.txt" text file, optimized for this task

**10. Display question outcome (correct/incorrect):** the system should display to the user whether they answered the question correctly or incorrectly, in plain language (e.g. "PlayerOne, your answer was incorrect.") based on the results of requirement 7.

**11. Assign points:** if the player's answer is deemed correct, points are added to that player's score.
>tbd: are different questions worth different amounts of points?

**12. Display scoreboard:** the users' names and current scores should be displayed on the screen after each question is answered, reflecting the points earned (if any) from the most recently-asked question.

**13. Alternate player turns:** once a player has answered their question, the system should indicate that it is now the opposite player's turn. This brings the user back to requirement 4, and users alternate completing the steps in requirements 4-11 until the round ends (when a set number of questions have been asked, currently set to ten).

**14. Indicate end of round and award winner:** after each player has answered five questions, the game will print a message that the round has ended and indicate the winner of the round in plain language (e.g. "Congratulations playerOne, you won the game!").

**15. Prompt for rematch/end of game:** after a round has ended and a winner is declared, the software should provide users with the option to "rematch" (start a new game) or "exit" (terminate the software)

**16. Use natural-language processing to generate trivia questions:** the trivia questions in the software's database will be based on the corpus of "State of the Union" texts compiled by the "SOTU-db" project

## Tools Used
- **GitHub** version control
- **BaseCamp** team communication
- **IDEA IntelliJ** Java IDE
- **[Python, NLTK library:](https://www.nltk.org/)** natural language processing of texts
- **R, RStudio (IDE), tm, tidyverse packages** natural language processing of texts
