package tw.bowlingscorer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BowlingScorer {

    public static int getScoresFromInputNumbers(List<Integer> inputNumbers) {
        int sumOfScores = 0;
        for (int score : inputNumbers) {
            sumOfScores += score;

        }
        return sumOfScores;
    }

    public int score(String inputString) {
        int scores = getScoresFromInputNumbers(parseStringToIntegerList(inputString));
        return scores;
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
