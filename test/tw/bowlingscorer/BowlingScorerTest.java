package tw.bowlingscorer;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
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

    @Test
    public void shouldReturnArrayOfOneWhenInputString() {
        assertThat(BowlingScorer.parseStringngToIntegerArray("1"), is(new int[]{1}));
    }
}
