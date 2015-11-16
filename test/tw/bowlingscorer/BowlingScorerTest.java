package tw.bowlingscorer;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static tw.bowlingscorer.BowlingScorer.getScoresFromInputNumbers;

public class BowlingScorerTest {
    private BowlingScorer bowlingScorer;

    @Before
    public void setUp() {
        bowlingScorer = new BowlingScorer();
    }

    @Test
    public void shouldReturnNumberOneWhenInputNumberOne() {
        assertEquals(1, getScoresFromInputNumbers(Arrays.asList(1)));
    }

    @Test
    public void shouldReturnSumOfThreeWhenInputOneAndTWo() {
        assertEquals(3, getScoresFromInputNumbers(Arrays.asList(1, 2)));
    }

    @Test
    public void shouldReturnSumWhenInputThreeNumbers() {
        assertEquals(6, getScoresFromInputNumbers(Arrays.asList(1, 2, 3)));
    }

    @Test
    public void shouldReturnArrayOfOneWhenInputString() {
        assertThat(bowlingScorer.parseStringToIntegerList("1"), is(Arrays.asList(1)));
    }

    @Test
    public void shouldReturnArrayContainsIntegerOneAndTwoWhenInputStringOfOneAndTwo() {
        assertThat(bowlingScorer.parseStringToIntegerList("1 2"), is(Arrays.asList(1, 2)));
    }

    @Test
    public void shouldReturnArrayContainsIntegerWhenInputString() {
        assertThat(bowlingScorer.parseStringToIntegerList("1 2 3"), is(Arrays.asList(1, 2, 3)));
    }

    @Test
    public void shouldReturnArrayContainsIntegerWhenInputStringWithComma() {
        assertThat(bowlingScorer.parseStringToIntegerList("1,2,3"), is(Arrays.asList(1, 2, 3)));
    }

    @Test
    public void shouldReturnArrayContainsIntegerWhenInputStringWithMultipleCommasAndMultipleSpaces() {
        assertThat(bowlingScorer.parseStringToIntegerList("1,2   ,   3, 4"), is(Arrays.asList(1, 2, 3, 4)));
    }

    @Test
    public void shouldReturnArrayContainsIntegerWhenInputStringWithMoreCommas() {
        assertThat(bowlingScorer.parseStringToIntegerList("1,2  , ,,   3, 4"), is(Arrays.asList(1, 2, 3, 4)));
    }

    @Test
    public void shouldReturnArrayContainsIntegerWhenInputStringWithCharacters() {
        assertThat(bowlingScorer.parseStringToIntegerList("1,2, a ,3, 4"), is(Arrays.asList(1, 2, 3, 4)));
    }

}
