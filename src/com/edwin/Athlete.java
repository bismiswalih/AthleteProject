package com.edwin;

import java.util.ArrayList;

public class Athlete {

    // Athlete variables.
    String athleteFirstName;
    String athleteLastName;
    int athleteID;
    ArrayList<Integer> athleteScores;

    // Constructor to populate the values for the athlete variables.
    public Athlete(String firstName, String lastName, int id, ArrayList<Integer> scores) {
        this.athleteFirstName = firstName;
        this.athleteLastName = lastName;
        this.athleteID = id;
        this.athleteScores = scores;
    }

    // Method to compute the average of the scores of the players
    public float computeAverage() {
        int total = 0;

        // Compute the sum of the scores
        for (int score : this.athleteScores) {
            total += score;
        }

        // Return the average of the scores
        return (float) total/this.athleteScores.size();
    }

    // Method to display the results to the users.
    public void displayResults() {
        float averageScore = computeAverage();
        System.out.println(this.athleteFirstName + "\t" + this.athleteLastName + "\t" + String.format("%.2f", averageScore));
    }
}
