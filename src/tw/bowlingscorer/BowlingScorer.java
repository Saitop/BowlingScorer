package tw.bowlingscorer;

import java.util.ArrayList;
import java.util.List;

public class BowlingScorer {

    private final List<Frame> frames;
    private int frameCounter = 0;
    private static final int MAX_FRAMES = 10;


    public BowlingScorer() {
        frames = new ArrayList<>(MAX_FRAMES);
        for (int i = 0; i < MAX_FRAMES; i++) {
            frames.add(new Frame());
        }
    }

    public void roll(int eachPin) {
        Frame frame = getFrame();
        frame.setScore(eachPin);
        if (isBonusFrame()) {
            Frame prev = getPreviousFrame();
            // restrict to one attempt, when last frame was spare
            if (prev.isSpare() || prev.isStrike()) {
                frame.limitToOneAttempt();
            }
        }

    }

    private Frame getFrame() {

        Frame frame = getCurrentFrame();

        if (frame.isDone()) {

            // new bonus frame
            if (isLastFrame() && (frame.isSpare() || frame.isStrike())) {
                Frame bonus = new Frame();
                frames.add(bonus);
                frameCounter++;
                return bonus;
            }

            frameCounter++;
            if (frameCounter == MAX_FRAMES || isBonusFrame()) {
                return null;
            }

            frame = getCurrentFrame();
        }

        return frame;
    }


    public int score() {
        int score;
        // first frame
        if (frameCounter == 0) {
            Frame curr = getCurrentFrame();
            return curr.eachFrameScore();
        } else {

            Frame curr = getCurrentFrame();
            Frame prev = getPreviousFrame();

            if (isBonusFrame()) {
                return prev.eachFrameScore() + curr.eachFrameScore();
            }
            score = curr.eachFrameScore() + prev.eachFrameScore();
            for(int i=frameCounter;i>=1;i--){
                if (prev.isSpare()) {
                    score += curr.getFirstScore();
                }
                if (prev.isStrike()) {
                    score += (curr.getFirstScore()+curr.getSecondScore());
                }
            }

        }
        return score;
    }

    private Frame getPreviousFrame() {
        return frames.get(frameCounter - 1);
    }

    private Frame getCurrentFrame() {
        return frames.get(frameCounter);
    }

    private boolean isBonusFrame() {
        return frames.size() > MAX_FRAMES;
    }

    private boolean isLastFrame() {
        return frameCounter == MAX_FRAMES - 1;
    }


    public int getSumOfScore(String inputString) {
        List<Integer> inputPins = parseStringToIntegerList(inputString);
        for (int eachPin : inputPins) {
            roll(eachPin);
        }
        return score();
    }

    public List<Integer> parseStringToIntegerList(String inputString) {
        List<Integer> resultList = new ArrayList<>();
        String[] inputStringArray = inputString.replaceAll("[^\\d]+", ",").split(",");
        for (String eachString : inputStringArray) {
            int eachInt = Integer.parseInt(eachString);
            resultList.add(eachInt);
        }
        return resultList;
    }
}
