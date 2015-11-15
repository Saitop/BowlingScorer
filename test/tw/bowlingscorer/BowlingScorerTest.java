package tw.bowlingscorer;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BowlingScorerTest {
    @Test
    public void shouldReturnNumberOneWhenInputNumberOne() {
        assertEquals(1, BowlingScorer.getScoresFromInputNumbers(new int[]{1}));
    }

    @Test
    public void shouldReturnSumOfThreeWhenInputOneAndTWo() {
        assertEquals(3, BowlingScorer.getScoresFromInputNumbers(new int[]{1, 2}));

    }
}
