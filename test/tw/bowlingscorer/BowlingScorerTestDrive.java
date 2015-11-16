package tw.bowlingscorer;

import java.util.Scanner;

public class BowlingScorerTestDrive {
    public static void main(String[] args) {
        while (true){
            BowlingScorer bowlingScorer = new BowlingScorer();
            Scanner inputScanner = new Scanner(System.in);
            String inputString = inputScanner.nextLine().replaceAll("[^\\d]+", ",");
            int scores = bowlingScorer.getSumOfScore(inputString);
            System.out.print("Numbers inputted: " + inputString + "\n");
            System.out.print("Scores: " + scores + "\n");
        }
    }

}
