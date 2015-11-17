package tw.bowlingscorer;

public class Frame {

    private static final int MAX_PINS = 10;
    private static final int MAX_ATTEMPTS_PER_FRAME = 2;

    public int[] scores = new int[2];
    public int remainsPins = 10;
    public int attemptsCounter = 0;

    public boolean isStrike = false;

    public void setScore(int score) {
        scores[attemptsCounter++] = score;
        remainsPins -= score;

        if (score == MAX_PINS) {
            isStrike = true;
            limitToOneAttempt();
        }
    }

    public boolean isSpare() {
        return remainsPins == 0 && attemptsCounter == MAX_ATTEMPTS_PER_FRAME && !isStrike;
    }

    public boolean isStrike() {
        return remainsPins == 0 && isStrike;
    }

    public boolean isDone() {
        return attemptsCounter == MAX_ATTEMPTS_PER_FRAME;
    }


    public void limitToOneAttempt() {
        scores[1] = 0;
        attemptsCounter++;
    }

    public int getFrameScores() {
        return scores[0] + scores[1];
    }

    public int getFirstScore() {
        return scores[0];
    }

    public int getSecondScore() {
        return scores[1];
    }

}
