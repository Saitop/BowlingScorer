package tw.bowlingscorer;

public class BowlingScorer {

    public static int getScoresFromInputNumbers(int[] inputNumbers) {
        int sumOfScores = 0;
        for ( int score: inputNumbers) {
            sumOfScores += score;

        }
        return sumOfScores;
    }
}
