package tw.bowlingscorer;

import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static tw.bowlingscorer.BowlingScorer.getScoresFromInputNumbers;

public class BowlingScorerTest {
    @Test
    public void shouldReturnNumberOneWhenInputNumberOne() {
        assertEquals(1, getScoresFromInputNumbers(Arrays.asList(1)));
    }

    @Test
    public void shouldReturnSumOfThreeWhenInputOneAndTWo() {
        assertEquals(3, getScoresFromInputNumbers(Arrays.asList(1,2)));
    }

    @Test
    public void shouldReturnSumWhenInputThreeNumbers() {
        assertEquals(6, getScoresFromInputNumbers(Arrays.asList(1,2,3)));
    }

    @Test
    public void shouldReturnArrayOfOneWhenInputString() {
        assertThat(BowlingScorer.parseStringToIntegerList("1"), is(Arrays.asList(1)));
    }

    @Test
    public void shouldReturnArrayContainsIntegerOneAndTwoWhenInputStringOfOneAndTwo() {
        assertThat(BowlingScorer.parseStringToIntegerList("1 2"), is(Arrays.asList(1,2)));
    }

    @Test
    public void shouldReturnArrayContainsIntegerWhenInputString() {
        assertThat(BowlingScorer.parseStringToIntegerList("1 2 3"), is(Arrays.asList(1,2,3)));
    }

    @Test
    public void shouldReturnArrayContainsIntegerWhenInputStringWithComma() {
        assertThat(BowlingScorer.parseStringToIntegerList("1,2,3"), is(Arrays.asList(1,2,3)));
    }
}
