import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicLong;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Task[] tasks;
        tasks = new Task[20];
        for (int i = 0 ; i < 20; i++) {
            int fileNumber = 1;
            tasks[i] = new Task(fileNumber);
            fileNumber++;
        }
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 20; i++) {
            executorService.execute(tasks[i]);
        }
        System.out.println("""
                                Welcome to Word Analyzor!
                                Select what U want:
                                1) Word Count
                                2) Longest Word and its length
                                3) Shortest Word and its length
                                4) All words length Average
                                5) Exit
                                Which One?""");
        Scanner scanner = new Scanner(System.in);
        String input;
        do {
            input = scanner.next();
            switch (input) {
                case ("1") -> {
                    int count = 0;
                    for (int i = 0; i < 20; i++) {
                        count += tasks[i].getWords().size();
                    }
                    System.out.println("Word count is : " + count);
                }
                case ("2") -> {
                    String maxLengthWord = tasks[0].getMaxLengthWord();
                    int maxLength = tasks[0].getMaxLength();
                    for (Task task : tasks) {
                        if (task.getMaxLength() > maxLength) {
                            maxLengthWord = task.getMinLengthWord();
                            maxLength = task.getMaxLength();
                        }
                    }
                    System.out.println("Longest word is : " + maxLengthWord + " and its length is : " + maxLength);
                }
                case ("3") -> {
                    String minLengthWord = tasks[0].getMinLengthWord();
                    int minLength = tasks[0].getMinLength();
                    for (Task task : tasks) {
                        if (task.getMinLength() > minLength) {
                            minLengthWord = task.getMinLengthWord();
                            minLength = task.getMinLength();
                        }
                    }
                    System.out.println("Longest word is : " + minLengthWord + " and its length is : " + minLength);
                }
                case ("4") -> {
                    double average;
                    double total = 0;
                    for (Task task : tasks) {
                        total += task.getAverage();
                    }
                    average = total / 20;
                    System.out.println("All word average in this world is : " + average);
                }
                default -> System.out.println("invalid input");
            }
        }while (!input.equals("5"));
        }

    }



