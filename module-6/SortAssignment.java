/*
    Xavier Grunitzky
    4/26/26
    Module Assignment 6.2
    This program uses two methods—one using the Comparable interface and one using the Comparator
    interface—to sort objects using the bubble sort algorithm.
*/
import java.util.Comparator;

public class SortAssignment {

    // Method 1: Bubble Sort using Comparable
    public static <T extends Comparable<T>> void SortComparable(T[] list) {
        for (int i = 0; i < list.length - 1; i++) {
            for (int j = 0; j < list.length - 1 - i; j++) {

                if (list[j].compareTo(list[j + 1]) > 0) {
                    T temp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = temp;
                }
            }
        }
    }

    // Method 2: Bubble Sort using Comparator
    public static <T> void SortComparator(T[] list, Comparator<T> comp) {
        for (int i = 0; i < list.length - 1; i++) {
            for (int j = 0; j < list.length - 1 - i; j++) {

                if (comp.compare(list[j], list[j + 1]) > 0) {
                    T temp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = temp;
                }
            }
        }
    }

    // Print method
    public static <T> void printArray(T[] list) {
        for (T item : list) {
            System.out.print(item + " ");
        }
        System.out.println();
    }

    // Test code
    public static void main(String[] args) {

        //sorting numbers
        Integer[] numbers = {10, 7, 20, 2, 5, 35, 25, 30};

        System.out.println("Before Comparable Sort:");
        printArray(numbers);

        SortComparable(numbers);

        System.out.println("After Comparable Sort:");
        printArray(numbers);

        //sorting animal names
        String[] words = {"Dog", "Cat", "Pig", "Monkey", "Horse", "Lion", "Bird"};

        System.out.println("\nBefore Comparator Sort (Reverse Alphabetical):");
        printArray(words);

        SortComparator(words, Comparator.reverseOrder());

        System.out.println("After Comparator Sort (Reverse Alphabetical):");
        printArray(words);
    }
}
