package tw.bowlingscorer;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BowlingScorerTest {
    @Test
    public void shouldReturnNumberOneWhenInputNumberOne() {
        assertEquals(1, BowlingScorer.getScoresFromInputNumbers(1));
    }


}
