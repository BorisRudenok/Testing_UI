package utils;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GenerateRandomMarkedFields {
    private final Random random = new Random();

    public List<Integer> randomSend(int numberRandomNumbers, int rangeSelectionNumbers, int skipCheckBox) {
        ArrayList<Integer> randomNumbersToClick = new ArrayList<>();
        int randomNamber = random.nextInt(rangeSelectionNumbers);
        while ((randomNumbersToClick.size() <= numberRandomNumbers)) {
            if ((randomNamber != skipCheckBox) && (!randomNumbersToClick.contains(randomNamber))) {
                randomNumbersToClick.add(randomNamber);
            }
            randomNamber = random.nextInt(rangeSelectionNumbers);
        }
        return randomNumbersToClick;
    }
}
