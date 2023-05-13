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
    }

    public void wordSetCreator() {

    }

    private int calculateMaxLength() {

    }

    private int calculateMinLength() {

    }

    public int getMaxLength() {

    }

    public int getMinLength() {

    }

    public HashSet<String> getWords() {
        return words;
    }

    public double getAverage() {
        return average;
    }

    @Override
    public void run() {

    }
}
