package tw.bowlingscorer;

import java.util.ArrayList;
import java.util.List;

public class BowlingScorer {

    private final List<Frame> frames;
    private int frameCounter = 0;
    private static final int MAX_FRAMES = 12;


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
            if (prev.isSpare() || prev.isStrike()) {
                frame.limitToOneAttempt();
            }
        }

    }

    private Frame getFrame() {
        Frame frame = getCurrentFrame();
        if (frame.isDone()) {
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
        int score = 0;
        Frame curr = getSpecificFrame(frameCounter);
        if (frameCounter == 0) {
            return curr.getFrameScores();
        } else {
            Frame prev = getSpecificFrame(frameCounter - 1);
            if (isBonusFrame()) {
                return prev.getFrameScores() + curr.getFrameScores();
            }
            score = curr.getFrameScores();
            for (int i = frameCounter; i >= 1; i--) {
                Frame currentFrame = getSpecificFrame(i);
                Frame previousOneFrame = getSpecificFrame(i - 1);
                score += previousOneFrame.getFrameScores();
                if (previousOneFrame.isSpare()) {
                    score += currentFrame.getFirstScore();
                }
                if (previousOneFrame.isStrike()) {
                    score += (currentFrame.getFrameScores());
                    if (i-2>0){
                        Frame previousTwoFrame = getSpecificFrame(i - 2);
                        if (previousTwoFrame.isStrike()) {
                            score = score+ previousOneFrame.getFrameScores();
                            if(i==11){
                                score -= 10*2;
                            }
                        }

                    }
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

    private Frame getSpecificFrame(int position) {
        return frames.get(position);
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
