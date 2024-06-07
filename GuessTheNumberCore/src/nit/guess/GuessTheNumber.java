package nit.guess;

import java.util.Random;
import javax.swing.JOptionPane;

public class GuessTheNumber {
    public static void main(String[] args) {
        // Create a Random object for generating random numbers
        Random random = new Random();
        
        // Variables to keep track of the score and number of rounds
        int totalScore = 0;
        
        String chooseNumberOfrounds = JOptionPane.showInputDialog("Enter the number of rounds you wants to play!");
        
        int numberOfRounds = Integer.parseInt(chooseNumberOfrounds);
        
        // Inform the user about the game
        JOptionPane.showMessageDialog(null, "Welcome to the Number Guessing Game!\n"
                + "You have " + numberOfRounds + " rounds to play.\n"
                + "Try to guess the number between 1 and 100.\n"
                + "And each round have 7 attempts.");

        // Loop through the number of rounds
        for (int round = 1; round <= numberOfRounds; round++) {
            int numberToGuess = random.nextInt(100) + 1;
            int attemptsLeft = 7;
            boolean guessedCorrectly = false;

            // Inform the user about the current round
            JOptionPane.showMessageDialog(null, "Round " + round + " begins!\n"
                    + "You have " + attemptsLeft + " attempts to guess the number.");

            // Loop until the user runs out of attempts or guesses the number
            while (attemptsLeft > 0 && !guessedCorrectly) {
                // Prompt the user to enter their guess
                String input = JOptionPane.showInputDialog("Enter your guess (1-100):");
                int userGuess;
                try {
                    userGuess = Integer.parseInt(input);
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Please enter a valid number.");
                    continue;
                }

                // Check if the guess is within the valid range
                if (userGuess < 1 || userGuess > 100) {
                    JOptionPane.showMessageDialog(null, "Please enter a number between 1 and 100.");
                    continue;
                }

                // Decrement the number of attempts left
                attemptsLeft--;

                // Provide feedback on the user's guess
                if (userGuess < numberToGuess) {
                    JOptionPane.showMessageDialog(null, "Too low! Try again.\n"
                            + "Attempts left: " + attemptsLeft);
                } else if (userGuess > numberToGuess) {
                    JOptionPane.showMessageDialog(null, "Too high! Try again.\n"
                            + "Attempts left: " + attemptsLeft);
                } else {
                    guessedCorrectly = true;
                    int score = attemptsLeft * 10;
                    totalScore += score;
                    JOptionPane.showMessageDialog(null, "Congratulations! You guessed the correct number.\n"
                            + "You scored " + score + " points in this round.");
                }
            }			// While loop ends here

            if (!guessedCorrectly) {
                JOptionPane.showMessageDialog(null, "Sorry! You ran out of attempts. The number was " + numberToGuess + ".");
            }
        }    			// For loop ends here

        // Display the final score
        JOptionPane.showMessageDialog(null, "Game Over!\nYour total score is: " + totalScore);
    }
}

