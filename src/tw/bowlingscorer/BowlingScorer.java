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

    public static void outputResultOnCommandLine() {
        Scanner inputScanner = new Scanner(System.in);
        String inputString = inputScanner.nextLine();
        int scores = getScoresFromInputNumbers(parseStringToIntegerList(inputString));
        System.out.print("input number:" + inputString + "\n");
        System.out.print("Scores:" + scores + "\n");
    }

    public static List<Integer> parseStringToIntegerList(String inputString) {
        List<Integer> resultList = new ArrayList<>();
        String[] inputStringArray = inputString.split(" ");
        for (String eachString : inputStringArray) {
            int eachInt = Integer.parseInt(eachString);
            resultList.add(eachInt);
        }
        return resultList;
    }
}
