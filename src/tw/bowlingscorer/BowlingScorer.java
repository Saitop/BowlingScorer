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

    public static void outputResultOnCommandLine() {
        Scanner inputScanner = new Scanner(System.in);
        String inputString = inputScanner.nextLine();
        System.out.print(inputString);
    }

    public static int[] parseStringngToIntegerArray(String inputString) {
        return new int[]{1};
    }
}
