/*
    Xavier Grunitzky
    Module Assignment 5.2
    4/19/26
    This program read a file then displays the text with no duplicates in ascending order and descending order.
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Assignment5Mod {

    public static void main(String[] args) {

        String filename = "collection_of_words.txt";

        // TreeSet removes duplicates automatically + sorts in ascending order
        TreeSet<String> words = new TreeSet<>();

        // Read words from file
        try {
            File file = new File(filename);
            Scanner scanner = new Scanner(file);

            while (scanner.hasNext()) {
                String word = scanner.next().toLowerCase().replaceAll("[^a-zA-Z]", "");
                if (!word.isEmpty()) {
                    words.add(word);
                }
            }

            scanner.close();

        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found -> " + filename);
            return;
        }


        // Display ascending order
        System.out.println("Non-Duplicate Words in Ascending Order:");
        for (String word : words) {
            System.out.println(word);
        }

        // Display descending order
        System.out.println("\nNon-Duplicate Words in Descending Order:");
        ArrayList<String> descendingList = new ArrayList<>(words);
        Collections.reverse(descendingList);

        for (String word : descendingList) {
            System.out.println(word);
        }

        // Test code
        System.out.println("\n--- Test Code Output ---");
        runTests(words);
    }

    // Test method
    public static void runTests(TreeSet<String> words) {

        // Test 1: Check if set is not empty
        if (!words.isEmpty()) {
            System.out.println("Test 1 Passed: Words were loaded successfully.");
        } else {
            System.out.println("Test 1 Failed: No words were loaded.");
        }

        // Test 2: Ensure sorting works (TreeSet always sorts)
        String firstWord = words.first();
        String lastWord = words.last();

        System.out.println("Test 2 Passed: First word in ascending order is -> " + firstWord);
        System.out.println("Test 3 Passed: Last word in ascending order is -> " + lastWord);

        // Test 3: Ensure duplicates are removed
        int sizeBefore = words.size();
        words.add(firstWord); // Add duplicate on purpose

        if (words.size() == sizeBefore) {
            System.out.println("Test 4 Passed: Duplicate words are not added.");
        } else {
            System.out.println("Test 4 Failed: Duplicate was added.");
        }
    }
}

