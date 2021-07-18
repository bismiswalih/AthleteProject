package com.edwin;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Create an object array of Athlete.
        Athlete[] athletes;
        athletes = inputAndDisplayDetails();

        // Display results of the players.
        System.out.println("Player\t\t\tStats");
        System.out.println("************************");
        for (Athlete athlete : athletes) {
            athlete.displayResults();
        }
    }

    // Method to accept entry from the users.
    public static Athlete[] inputAndDisplayDetails() {
        // Create variable to store the values.
        int playerCount;
        String playerFirstName;
        String playerLastName;
        int playerID;
        ArrayList<Integer> playerScores;

        // Get the number of players from the users.
        Scanner input = new Scanner(System.in);
        System.out.print("How many players are you going to enter: ");
        playerCount = checkNumeric(input);

        // Create Athlete objects based on the player count.
        Athlete[] athlete = new Athlete[playerCount];

        // Get the details for all players.
        for (int p = 0; p < playerCount; ++p) {
            System.out.println("\nEnter Details for Player " + (p + 1));

            // Get the name of the player.
            System.out.print("Enter player first name: ");
            playerFirstName = checkNonNumeric(input);
            System.out.print("Enter player last name: ");
            playerLastName = checkNonNumeric(input);

            // Get the ID of the player.
            System.out.print("Enter player id number: ");
            playerID = checkNumeric(input);

            // Get the scores of the players
            playerScores = inputScores();

            // Assign values to object array.
            athlete[p] = new Athlete(playerFirstName, playerLastName, playerID, playerScores);
        }
        // Return the Athlete object array.
        return athlete;
    }

    // Method to accept scores of each players.
    public static ArrayList<Integer> inputScores() {
        Scanner input = new Scanner(System.in);
        int score = 0;
        ArrayList<Integer> playerScores = new ArrayList<>();

        // Input the scores of the player.
        while (score != 1) {
            System.out.print("Enter the game score per game of the player, press 1 to end: ");
            score = checkNumeric(input);
            // Enter the score, if not 1.
            if (score != 1) {
                playerScores.add(score);
            }
        }
        // Return the playerScores arraylist.
        return playerScores;
    }

    // Method to check validation for non-numeric values.
    public static String checkNonNumeric(Scanner input) {
        while(input.hasNextInt()) {
            System.out.print("Value cannot be numeric. Re-enter correct value: ");
            input.next();
        }
        return input.next();
    }

    // Method to check validation for numeric values.
    public static int checkNumeric(Scanner input) {
        while(!input.hasNextInt()) {
            System.out.print("Value cannot be text. Re-enter correct value: ");
            input.next();
        }
        return input.nextInt();
    }

}
