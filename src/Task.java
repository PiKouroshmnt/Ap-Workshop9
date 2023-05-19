import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class Task implements Runnable{
    private HashSet<String> words;
    private int maxLength;
    private String maxLengthWord;
    private int minLength;
    private String minLengthWord;

    private double average;
    private FileReader fileReader;
    private Scanner scanner;

    public Task(int number) throws FileNotFoundException {
        words = new HashSet<>();
        scanner = new Scanner(new File("assets\\file_" + number + ".txt"));
        maxLength = 0;
        minLength = 0;
        average = 0;
    }

    public void wordSetCreator() {
        do {
            words.add(scanner.nextLine());
        }while (scanner.hasNext());
    }

    private void calculateMaxLength() {
        for(String word : words) {
            if (maxLength < word.length()) {
                maxLength = word.length();
                maxLengthWord = word;
            }
        }
    }

    private void calculateMinLength() {
        for(String word : words) {
            if (minLength == 0) {
                minLength = word.length();
                minLengthWord = word;
            } else if (minLength > word.length()) {
                minLength = word.length();
                minLengthWord = word;
            }
        }
    }
    private void calculateAverage(){
        double total = 0;
        for (String word : words){
            total += word.length();
        }
        average = total/words.size();
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
        calculateAverage();
        return average;
    }

    public String getMaxLengthWord() {
        return maxLengthWord;
    }

    public String getMinLengthWord() {
        return minLengthWord;
    }

    @Override
    public void run() {
        wordSetCreator();
        calculateMaxLength();
        calculateMinLength();
    }
}
