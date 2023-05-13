import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashSet;

public class Task implements Runnable{
    private HashSet<String> words;
    private int maxLength;
    private int minLength;
    private double average;
    private FileReader fileReader;

    public Task(int number) throws FileNotFoundException {
        words = new HashSet<>();
        fileReader = new FileReader("assets\\file_" + number + ".txt");
        maxLength = 0;
        minLength = 0;
        average = 0;
    }

    public void wordSetCreator() {

    }

    private void calculateMaxLength() {
        for(String word : words) {
            if (maxLength < word.length()) {
                maxLength = word.length();
            }
        }
    }

    private void calculateMinLength() {
        for(String word : words) {
            if (minLength == 0) {
                minLength = word.length();
            } else if (minLength > word.length()) {
                minLength = word.length();
            }
        }
    }

    public int getMaxLength() {
        return maxLength;
    }

    public int getMinLength() {
        return minLength;
    }

    public HashSet<String> getWords() {
        return words;
    }

    public double getAverage() {
        return average;
    }

    @Override
    public void run() {
        wordSetCreator();
        calculateMaxLength();
        calculateMinLength();
    }
}
