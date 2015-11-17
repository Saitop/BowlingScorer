package tw.bowlingscorer;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class BowlingScorerTest {
    private BowlingScorer bowlingScorer;

    @Before
    public void setUp() {
        bowlingScorer = new BowlingScorer();
    }
    @Test
    public void shouldReturnThreeWhenRollOneAndTwoPins() {
        bowlingScorer.roll(1);
        bowlingScorer.roll(2);

        assertEquals(3, bowlingScorer.score());

    }

    @Test
    public void shouldReturnTenPinsWhenRollOneToFourPins() {
        bowlingScorer.roll(1);
        bowlingScorer.roll(2);
        bowlingScorer.roll(3);
        bowlingScorer.roll(4);

        assertEquals(10, bowlingScorer.score());
    }

    @Test
    public void shouldReturnWithSpareBonusWhenRollTwoSpare() {
        bowlingScorer.roll(9);
        bowlingScorer.roll(1);
        bowlingScorer.roll(9);
        bowlingScorer.roll(1);

        assertEquals(29, bowlingScorer.score());
    }

    @Test
    public void shouldReturnWithStrikeBonusWhenRollOneStrike() {
        bowlingScorer.roll(10);
        bowlingScorer.roll(5);
        bowlingScorer.roll(5);

        Assert.assertEquals(30, bowlingScorer.score());
    }

    @Test
    public void shouldReturnWithStrikeBonusWhenRollTwoStrike() {
        bowlingScorer.roll(10);
        bowlingScorer.roll(5);
        bowlingScorer.roll(5);
        bowlingScorer.roll(10);
        bowlingScorer.roll(1);
        bowlingScorer.roll(1);

        Assert.assertEquals(54, bowlingScorer.score());
    }


    @Test
    public void shouldReturnWithStrikeBonusWhenRollOneStrikeInTheMiddle() {
        bowlingScorer.roll(1);
        bowlingScorer.roll(1);
        bowlingScorer.roll(1);
        bowlingScorer.roll(1);
        bowlingScorer.roll(10);
        bowlingScorer.roll(1);
        bowlingScorer.roll(1);
        assertEquals(18, bowlingScorer.score());
    }

    @Test
    public void shouldReturnThreeHundredPinsWhenRollAllStrikes() {
        bowlingScorer.roll(10);
        bowlingScorer.roll(10);
        bowlingScorer.roll(10);
        bowlingScorer.roll(10);
        bowlingScorer.roll(10);
        bowlingScorer.roll(10);
        bowlingScorer.roll(10);
        bowlingScorer.roll(10);
        bowlingScorer.roll(10);
        bowlingScorer.roll(10);
        bowlingScorer.roll(10);
        bowlingScorer.roll(10);
        assertEquals(300, bowlingScorer.score());
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
