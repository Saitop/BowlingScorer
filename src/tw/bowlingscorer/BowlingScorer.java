package tw.bowlingscorer;

import java.util.Scanner;

public class BowlingScorer {

    public static int getScoresFromInputNumbers(int[] inputNumbers) {
        int sumOfScores = 0;
        for ( int score: inputNumbers) {
            sumOfScores += score;

        }
        return sumOfScores;
    }

    public static void parseInputStringToIntArray() {
        Scanner inputScanner = new Scanner(System.in);
        String inputString = inputScanner.nextLine();
        System.out.print(inputString);
    }
}
