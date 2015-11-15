package tw.bowlingscorer;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static tw.bowlingscorer.BowlingScorer.getScoresFromInputNumbers;

public class BowlingScorerTest {
    @Test
    public void shouldReturnNumberOneWhenInputNumberOne() {
        assertEquals(1, getScoresFromInputNumbers(new int[]{1}));
    }

    @Test
    public void shouldReturnSumOfThreeWhenInputOneAndTWo() {
        assertEquals(3, getScoresFromInputNumbers(new int[]{1, 2}));
    }

    @Test
    public void shouldReturnSumWhenInputThreeNumbers() {
        assertEquals(6, getScoresFromInputNumbers(new int[]{1, 2, 3}));
    }

}
