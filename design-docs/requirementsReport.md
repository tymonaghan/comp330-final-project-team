# Requirements Report
*An assessment of the requirements of "Trivia of the Union" and their progress toward completion*

Format:<br>
**#. Short Name:**
Implementation progress and notes

**1. Two simultaneous head-to-head players:** <br>
The game actually asks whether the user wants a 1-player or 2-player game. Currently, playerTwo will be named "Computadora" if a "1-player" game is selected but otherwise performs identically to a "1-player" game.

**2. Gather player names:** <br>
Players are prompted to enter a name immediately after selected a 1-player or 2-player game. There is nothing in place to limit the length or characters used in a player's name, which could potentially cause errors.

**3. Gather difficulty level:** <br>
Players are prompted to select a difficulty after entering player names. The options are 1- easy, 2- medium, and 3-hard. Users enter the corresponding number and press enter. Entering a non-integer will return an error and prompt the user to enter a new number; entering a non-valid integer (e.g. 0, -1) will simply prompt the user to enter the number again without displaying an error

**4. Indicate player turn:** <br>
The system prints `[playerName], question number [questionNumber] is for you:` before asking each question. This means the player currently taking their turn is displayed on the console at all times during the question/answer main gameplay loop (reqs 4-11).

**5. Display trivia questions:** <br>
We have not implemented randomness yet; the questions are asked in a pre-set order each time the game is played. However, the questions are displayed to the user properly.

**6. Display multiple choice options:** <br>
The options are displayed properly, one on each line, each prefixed with a number 1-3 that the user can use to select the corresponding option. These are read from a text file.

**7. Question timer:** <br>
The timer has not yet been implemented - there is no time restriction on players at any time during the game.

**8. Accept user input/answer selection:** <br>
>**8a.** "EASY" and "MEDIUM" difficulty: users can press 1, 2, or 3 followed by the ENTER key to submit their response corresponding to the number they pressed.<br>
>**8b.** "HARD" difficulty: users can type a string into the console and press ENTER to submit their response."

Currently, users are not notified explicitly to "Press 1-3" or "type your answer and press ENTER."


**9. Check user answer:** <br>
>**9a.** on EASY and MEDIUM difficulty, regular expressions are used to match the user's input (1, 2, or 3) to the first character of an "answers.txt" file. If the match is successful, the user's answer is correct. <br>
>**9b.** on HARD difficulty, regular expressions are used to determine whether the user's string appears in the line of a "hardstrings.txt" text file, optimized for this task. If the match is successful, the user's answer is correct. The regular expression pattern used is case-insensitive and allows for one extraneous character on each side of the response (for example,  reagan?" will match whatever "Reagan" would match)

**10. Display question outcome (correct/incorrect):** <br>
After the user's answer has been checked, three things happen. First, the user's answer is echoed back to them in the console (`Your answer: [player's answer]`). Second, the correct answer is printed to the console ("The correct answer is: [correct answer, and some more information/context about it]"). Third, the system displays a congratulatory text message if the answer was correct, or a message stating that the answer was incorrect, if that was the case.

**11. Assign points:** <br>
If the user was correct, the "questionsCorrect" field of their Player object is incremented. If the user was incorrect, "questionsCorrect" remains unchanged. In either case, the Player object's "questionsAttempted" field is incremented.

**12. Display scoreboard:** <br>
A score for each player is printed after each response is confirmed as correct or incorrect as in Requirement 10. For example, `playerOne's score: 2 (out of 3 attempted`.

**13. Alternate player turns:** <br>
The system clearly displays whose turn it is each time it asks a question. This information is on the screen nearly all the time that the program is running.

**14. Indicate end of round and award winner:** <br>
The system correctly identifies when the questionLimit has been reached, prints a message informing the user that the round is over (`The game is over!`), and prints a statement about the winner (`playerOne wins!`)

**15. Prompt for rematch/end of game:** <br>
Immediately after displaying the winner, the system prints a message asking players to press 1 to play again or 2 to exit. Pressing 1 does not properly reset the game as of now, and generally leads to a code-0 exit. Pressing 2 prints a message ("Thank you for playing, goodbye!") to the user and then exits with code 0.

**16. Use natural-language processing to generate trivia questions:** <br>
We have not integrated the coreNLP or any other NLP library into our Java software. Instead, text mining tools like Voyant-tools.org and www.sotu-db.com were used to generate a sample set of questions, which are currently the same for every round of Trivia of the Union.
