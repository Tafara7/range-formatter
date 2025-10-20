package numberrangesummarizer;

import java.util.Collection;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        NumberRangeSummarizerImpl impl = new NumberRangeSummarizerImpl();
        System.out.println("Enter comma-separated integers (or press Enter to use sample):");
        try (Scanner sc = new Scanner(System.in)) {
            String line = sc.nextLine();
            if (line == null || line.trim().isEmpty()) {
                line = "1,3,6,7,8,12,13,14,15,21,22,23,24,31";
            }
            Collection<Integer> collected = impl.collect(line);
            String summary = impl.summarizeCollection(collected);
            System.out.println("Summary: " + summary);
        }
    }
}
